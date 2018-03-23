package com.example.guest.stormtrooper.services;

import android.graphics.drawable.Drawable;

import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.models.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherService {

    public static void findWeather(String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.W_BASE_URL).newBuilder();
//        urlBuilder.addQueryParameter(Constants.W_QUERY_PARAMETER, location);
//        urlBuilder.addQueryParameter(Constants.);
        urlBuilder.addQueryParameter(Constants.W_END_URL,Constants.W_TOKEN);
        urlBuilder.addQueryParameter(Constants.W_QUERY_PARAMETER, location);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Weather> processResults(Response response) {
        ArrayList<Weather> conditions = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            JSONObject wJSON = new JSONObject(jsonData);
            JSONArray reportJSON = wJSON.getJSONArray("main");
            for (int i = 0; i < reportJSON.length(); i++) {
                JSONObject weatherJSON = reportJSON.getJSONObject(i);
                String main = weatherJSON.getString("main");

//                ArrayList<String> address = new ArrayList<>();
//                JSONArray addressJSON = restaurantJSON.getJSONObject("location")
//                        .getJSONArray("display_address");
//                for (int y = 0; y < addressJSON.length(); y++) {
//                    address.add(addressJSON.get(y).toString());
//                }
//
//                ArrayList<String> categories = new ArrayList<>();
//                JSONArray categoriesJSON = restaurantJSON.getJSONArray("categories");
//
//                for (int y = 0; y < categoriesJSON.length(); y++) {
//                    categories.add(categoriesJSON.getJSONObject(y).getString("title"));
//                }
                Weather weather = new Weather(main);
                conditions.add(weather);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return conditions;
    }

}
