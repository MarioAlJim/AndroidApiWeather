package com.silver.climaapi.model.api;

import com.silver.climaapi.model.objects.CurrentWeather;
import com.silver.climaapi.model.objects.WeatherForecast;

public class Response {
    public boolean Error;
    public String Message;
    public CurrentWeather WeatherReport;
    public WeatherForecast WeatherForecast;

    public boolean isError() {
        return Error;
    }

    public void setError(boolean error) {
        Error = error;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public CurrentWeather getWeatherReport() {
        return WeatherReport;
    }

    public void setWeatherReport(CurrentWeather weatherReport) {
        WeatherReport = weatherReport;
    }

    public com.silver.climaapi.model.objects.WeatherForecast getWeatherForecast() {
        return WeatherForecast;
    }

    public void setWeatherForecast(com.silver.climaapi.model.objects.WeatherForecast weatherForecast) {
        WeatherForecast = weatherForecast;
    }
}
