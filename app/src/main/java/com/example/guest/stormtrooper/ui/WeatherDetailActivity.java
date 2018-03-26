package com.example.guest.stormtrooper.ui;



import android.content.Intent;
import android.graphics.Typeface;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
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

import com.example.guest.stormtrooper.R;
//import com.example.guest.stormtrooper.adapters.WeatherListAdapter;
import com.example.guest.stormtrooper.adapters.WeatherPagerAdapter;
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



public class WeatherDetailActivity extends AppCompatActivity  {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    @BindView(R.id.detailsTextView) TextView mDetailsTextView;
    @BindView(R.id.getIdeasButton) Button mGetIdeasButton;
    @BindView(R.id.detailsDataTextView) TextView mDetailsDataTextView;
    private WeatherPagerAdapter mAdapter;
    private ArrayList<Weather> mWeather = new ArrayList<>();
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
//        ArrayList<Weather> mWeather = new ArrayList<>();

//        mWeather = Parcels.unwrap(getIntent().getParcelableExtra("location"));

        int startingPosition = getIntent().getIntExtra("position", 0);




        Intent intent = getIntent();
        String location = intent.getStringExtra("location");


        Typeface droidFont = Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
        mDetailsTextView.setTypeface(droidFont);
//
//        adapterViewPager = new WeatherPagerAdapter(getSupportFragmentManager(), mWeather);
//        mViewPager.setAdapter(adapterViewPager);
//        mViewPager.setCurrentItem(startingPosition);


        mDetailsTextView.setText("The weather for:  " + location);
//        mGetIdeasButton.setOnClickListener(this);

        getWeather(location);

    }

//    @Override
//    public void onClick(View v){
//        if (v == mGetIdeasButton) {
//
//            Intent intent = new Intent(WeatherDetailActivity.this,RecreationActivity.class);
//            startActivity(intent);
//
//        }
//
//    }

    private void getWeather(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findWeather(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {



                WeatherDetailActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Log.v("TAG", String.valueOf(weatherService.getWeathers().size()));
                        mWeather = weatherService.processResults(response);
                        Log.v("help", String.valueOf(mWeather.size()));
//                        mDetailsDataTextView.setText(mWeather.get(0).getMain());

                        mAdapter = new WeatherPagerAdapter(getApplicationContext(), mWeather);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(WeatherDetailActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);

                    }
                });

//                for(int i = 0; i < mWeather.size(); i++) {
//                    mDetailsDataTextView.setText(mWeather.get(i).getMain());
//                    mDetailsDataTextView.setText("test");
//                }

            }
        });
    }


}

