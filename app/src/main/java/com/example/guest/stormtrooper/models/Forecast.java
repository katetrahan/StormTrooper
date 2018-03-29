package com.example.guest.stormtrooper.models;


public class Forecast {
    private String desc;
    private String date;
    private String rain;

    public Forecast(String desc, String date){
        this.desc = desc;
        this.date = date;
        this.rain= rain;
    }
    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }

    public String getRain() {return rain; }
}
