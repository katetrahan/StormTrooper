package com.example.guest.stormtrooper.services;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.models.Forecast;
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

    public static ArrayList<Weather> weathers;
    public static ArrayList<Forecast> forecasts;

    public static void findWeather(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.W_BASE_URL + Constants.W_WEATHER + location).newBuilder();
        urlBuilder.addQueryParameter(Constants.W_END_URL,Constants.W_TOKEN);
        String url = urlBuilder.build().toString();
        Log.v("TAG", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void findForecast(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.W_BASE_URL + Constants.W_FORECAST + location).newBuilder();
        urlBuilder.addQueryParameter(Constants.W_END_URL,Constants.W_TOKEN);
        String url = urlBuilder.build().toString();
        Log.v("TAG", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
    public ArrayList<Forecast> processForecastResults(Response response) {
        forecasts = new ArrayList<>();
        Log.v("BUTT", response.toString());


        try {

            String jsonData = response.body().string();
            JSONObject wJSON = new JSONObject(jsonData);
            Log.v("wJson", wJSON.toString());
            JSONArray conditionsJSONarray= wJSON.getJSONArray("list");
            Log.v("Log 4", "log 4");
            for(int i=0; i<conditionsJSONarray.length(); i++){
                JSONObject conditionsJSON = conditionsJSONarray.getJSONObject(i);
                JSONArray weatherMain = conditionsJSON.getJSONArray("weather");
                String date = conditionsJSON.getString("dt_txt");
                String desc = weatherMain.getJSONObject(0).getString("main");
                Forecast forecast = new Forecast(desc, date);
                forecasts.add(forecast);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return forecasts;
    }

    public static ArrayList<Weather> getWeathers() {
        return weathers;
    }

    public ArrayList<Weather> processResults(Response response) {
        weathers = new ArrayList<>();
        Log.v("BUTT", response.toString());
        try {

            String jsonData = response.body().string();

            JSONObject wJSON = new JSONObject(jsonData);
            Log.v("wJson", wJSON.toString());
            JSONArray conditionsJSONarray= wJSON.getJSONArray("weather");
            Log.v("Log 4", "log 4");
            JSONObject conditionsJSON = conditionsJSONarray.getJSONObject(0);
            String weatherMain = conditionsJSON.getString("main");
            Log.d("String", weatherMain);
            Weather weather = new Weather(weatherMain);
            weathers.add(weather);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weathers;
    }


}
