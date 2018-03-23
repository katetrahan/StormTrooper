package com.example.guest.stormtrooper.ui;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import okhttp3.Call;
import okhttp3.Callback;

import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.adapters.RecArrayAdapter;
import com.example.guest.stormtrooper.models.Weather;
import com.example.guest.stormtrooper.services.WeatherService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = WeatherActivity.class.getSimpleName();
    @BindView(R.id.listView)
    ListView mListView;
//    @BindView(R.id.returnWeatherButton) Button mReturnWeatherButton;

    @BindView(R.id.locationPageTextView) TextView mLocationPageTextView;

    private RecArrayAdapter mAdapter;

    public ArrayList<Weather> conditions = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Typeface droidFont = Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
        mLocationPageTextView.setTypeface(droidFont);
//        mReturnWeatherButton.setOnClickListener(this);

        RecArrayAdapter adapter = new RecArrayAdapter(this, android.R.layout.simple_list_item_1, conditions);
        mListView.setAdapter(adapter);


        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        getWeather(location);
    }

//    @Override
//    public void onClick(View v) {
//        if (v == mReturnWeatherButton) {
//            String location = mLocationEditText.getText().toString();
//            Intent intent = new Intent(WeatherActivity.this, WeatherDetailActivity.class);
//            intent.putExtra("location", location);
//            startActivity(intent);
//        }
//
//    }

    private void getWeather(String location) {
        final WeatherService yService = new WeatherService();
        yService.findWeather(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    if (response.isSuccessful()) {
                        Log.v(TAG, jsonData);
                        conditions = yService.processResults(response);
                    }
                    Log.v(TAG, jsonData);
//                    Log.v(TAG,);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        });
    }
}
