package com.example.guest.stormtrooper;


public class Constants {
    public static final String Y_BASE_URL = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition.text%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22";
    public static final String Y_QUERY_PARAMETER = "location";
    public static final String Y_END_URL = "%2C%20tx%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
}
