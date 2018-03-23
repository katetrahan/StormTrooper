package com.example.guest.stormtrooper.services;

import android.graphics.drawable.Drawable;

import com.example.guest.stormtrooper.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class WeatherService {

    public static void findWeather(String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.W_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.W_QUERY_PARAMETER, location);
//        urlBuilder.addQueryParameter(Constants.);
        urlBuilder.addQueryParameter(Constants.W_END_URL,Constants.W_TOKEN);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }
}
