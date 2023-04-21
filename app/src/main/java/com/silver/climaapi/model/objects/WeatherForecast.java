package com.silver.climaapi.model.objects;

import java.util.ArrayList;

public class WeatherForecast {
    public String cod;
    public int message;
    public int cnt;
    public ArrayList<com.silver.climaapi.model.objects.List> list;
    public City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<com.silver.climaapi.model.objects.List> getList() {
        return list;
    }

    public void setList(ArrayList<com.silver.climaapi.model.objects.List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
