package com.silver.climaapi;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;
import com.silver.climaapi.databinding.ActivityMainBinding;
import com.silver.climaapi.model.api.WeatherService;
import com.silver.climaapi.model.objects.CurrentWeather;
import com.silver.climaapi.model.objects.Main;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private String city;
    private String main = "";
    private String icon = "";
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = binding.city.getText().toString();
                loadWather(city);
            }
        });
    }

    private void loadWather(String city) {
        WeatherService.wtService weatherService = WeatherService.getInstance().getService();
        weatherService.getWeather(city, "7e3414afc121f59c98900a2a9a743393", "en", "metric").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    CurrentWeather currentWeather = currentWeather(response.body());
                    binding.maxTemp.setText(currentWeather.getMain().getTemp_max() +"");
                    binding.currentTemp.setText(currentWeather.getMain().getTemp() + "");
                    binding.state.setText(main);
                    String loadicon = "https://openweathermap.org/img/wn/" + icon + "@2x.png";
                    Picasso.get().load(loadicon).into(binding.imgWeather);
                    Toast.makeText(MainActivity.this, "Clima recuperado exitosamente", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString() + "Un error ha ocurrido", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private CurrentWeather currentWeather(String responseString){
        CurrentWeather currentWeather = new CurrentWeather();
        try {
            JSONObject jsonResponse = new JSONObject(responseString);
                JSONObject jsonMain = jsonResponse.getJSONObject("main");
                double temp = jsonMain.getDouble("temp");
                double temp_max = jsonMain.getDouble("temp_max");
                Main main = new Main();
                main.setTemp(temp);
                main.setTemp_max(temp_max);
                currentWeather.setMain(main);

                JSONArray jsonWeather = jsonResponse.getJSONArray("weather");
                    JSONObject weather1 = jsonWeather.getJSONObject(0);
                    this.icon = weather1.getString("icon");
                    this.main = weather1.getString("main");
            } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
        return currentWeather;
    }
}