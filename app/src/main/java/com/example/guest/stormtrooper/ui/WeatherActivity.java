package com.example.guest.stormtrooper.ui;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.Call;
import okhttp3.Callback;

import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.models.Weather;
import com.example.guest.stormtrooper.services.WeatherService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

//public class WeatherActivity extends AppCompatActivity implements View.OnClickListener {
//    public static final String TAG = WeatherActivity.class.getSimpleName();
//    @BindView(R.id.returnWeatherButton)
//    Button mReturnWeatherButton;
//    @BindView(R.id.locationEditText)
//    EditText mLocationEditText;
////    @BindView(R.id.locationPageTextView)
////    TextView mLocationPageTextView;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_weather);
//        ButterKnife.bind(this);
//
//        Typeface droidFont = Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
//        mLocationPageTextView.setTypeface(droidFont);
//        mReturnWeatherButton.setOnClickListener(this);
//        Intent intent = getIntent();
//        String location = intent.getStringExtra("location");
//
//        getWeather(location);
//    }
//
//    @Override
//    public void onClick(View v) {
//        if (v == mReturnWeatherButton) {
//            String location = mLocationEditText.getText().toString();
//            if(location.length() <= 1){
//                Toast.makeText(WeatherActivity.this, "Please add a location", Toast.LENGTH_LONG).show();
//            } else {
//                Intent intent = new Intent(WeatherActivity.this, WeatherDetailActivity.class);
//                intent.putExtra("location", location);
//                startActivity(intent);
//
//            }
//        }
//
//    }
//
//    private void getWeather(String location) {
//        final WeatherService yService = new WeatherService();
//        String test = "portland";
//        yService.findWeather(test, new Callback() {
//
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                try {
//                    String jsonData = response.body().string();
//                    Log.v(TAG, jsonData);
////                    Log.v(TAG,);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//
//        });
//    }
//}
