package com.example.guest.stormtrooper.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.hardware.ConsumerIrManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.R;
//import com.example.guest.stormtrooper.adapters.PlantListAdapter;
import com.example.guest.stormtrooper.adapters.WeatherPagerAdapter;
import com.example.guest.stormtrooper.models.Forecast;
import com.example.guest.stormtrooper.models.Weather;
import com.example.guest.stormtrooper.services.WeatherService;
import java.io.IOException;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import org.parceler.Parcels;


public class WeatherDetailActivity extends AppCompatActivity implements View.OnClickListener  {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    @BindView(R.id.detailsTextView) TextView mDetailsTextView;
    @BindView(R.id.detailsDataTextView) TextView mDetailsDataTextView;
    private WeatherPagerAdapter mAdapter;
    private ArrayList<Weather> mWeather = new ArrayList<>();
    private ArrayList<Forecast> mForecast = new ArrayList<>();
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.weatherLabel) TextView mWeatherLabel;
    private SharedPreferences mSharedPreferences;
    private String mRecentLocation;
    @BindView(R.id.getPlantingButton) Button mGetPlantingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        int startingPosition = getIntent().getIntExtra("position", 0);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        Typeface droidFont = Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
        mDetailsTextView.setTypeface(droidFont);

        mWeatherLabel.setOnClickListener(this);
        mGetPlantingButton.setOnClickListener(this);

       mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentLocation = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
        Log.d("Shared Pref Location", mRecentLocation);
        if (mRecentLocation != null) {
            Log.v("HI", mRecentLocation);
            getWeather(mRecentLocation);
            getForecast(mRecentLocation);


        }
        mDetailsTextView.setText("The weather for:  " + mRecentLocation);

//        getWeather(Constants.PREFERENCES_LOCATION_KEY);
//        getForecast(Constants.PREFERENCES_LOCATION_KEY);
    }


    @Override
    public void onClick(View v){
        if (v == mWeatherLabel) {

            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.conserveh2o.org"));
            startActivity(webIntent);

        }
            if (v == mGetPlantingButton) {
                    Intent intent = new Intent(WeatherDetailActivity.this, PlantNotesActivity.class);
                    startActivity(intent);

                }
            }


    private void getForecast(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findForecast(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mForecast = weatherService.processForecastResults(response);
                WeatherDetailActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        mAdapter = new WeatherPagerAdapter(getApplicationContext(), mForecast);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(WeatherDetailActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }


    private void getWeather(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findWeather(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mWeather = weatherService.processResults(response);
                WeatherDetailActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    if(mWeather.size() != 0) {
                        Weather main = mWeather.get(0);
                        mDetailsDataTextView.setText(main.getMain());

                    } else {
                        Toast.makeText(WeatherDetailActivity.this, "Location was not valid", Toast.LENGTH_LONG).show();
                    }

                    }
                });


            }
        });
    }


}

