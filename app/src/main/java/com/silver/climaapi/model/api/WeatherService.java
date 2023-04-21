package com.silver.climaapi.model.api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.silver.climaapi.model.objects.CurrentWeather;

public class WeatherService {
    public interface wtService {
        @GET("weather")
        Call<String> getWeather
                (@Query("q") String city,
                 @Query("appid") String key,
                 @Query("lang") String lang,
                 @Query("units") String units);
       /* @GET("weather?q={1}&appid={2}&lang=en&units=metric")
        Call<Weather> getWeather(@Path("id") String city, @Path("key") String key);*/
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    private wtService service;

    private static final WeatherService apiClient = new WeatherService();

    public static WeatherService getInstance() {
        return apiClient;
    }

    private WeatherService() {
    }

    public wtService getService() {
        if (service == null) {
            service = retrofit.create(wtService.class);
        }
        return service;
    }
}

/*
    private static String ICO_URL = "https://openweathermap.org/img/wn/";
    private static String ICO_URL_END = "@2x.png";
    public static BitmapImage generateWatherImage(string icon)
    {
        BitmapImage bitmap = new BitmapImage();
        bitmap.BeginInit();
        bitmap.UriSource = new Uri(ICO_URL + icon + ICO_URL_END);
        bitmap.EndInit();
        return bitmap;
    }
}*/
