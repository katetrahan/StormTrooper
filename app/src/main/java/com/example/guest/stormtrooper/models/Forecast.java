package com.example.guest.stormtrooper.models;


public class Forecast {
    private String desc;
    private String date;

    public Forecast(String desc, String date){
        this.desc = desc;
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }
}
