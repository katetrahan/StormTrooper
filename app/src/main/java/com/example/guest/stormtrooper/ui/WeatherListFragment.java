package com.example.guest.stormtrooper.ui;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.R;
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
import android.support.v4.app.Fragment;


public class WeatherListFragment extends Fragment {
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.detailsTextView)
    TextView mDetailsTextView;
    @BindView(R.id.detailsDataTextView) TextView mDetailsDataTextView;
    private WeatherPagerAdapter mAdapter;
    private ArrayList<Weather> mWeather = new ArrayList<>();
    private ArrayList<Forecast> mForecast = new ArrayList<>();
    @BindView(R.id.weatherLabel) TextView mWeatherLabel;
    private SharedPreferences mSharedPreferences;
    private String mRecentLocation;
    @BindView(R.id.getPlantingButton)
    Button mGetPlantingButton;
    private SharedPreferences.Editor mEditor;




    public WeatherListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mEditor = mSharedPreferences.edit();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_weather_list, container, false);
        ButterKnife.bind(this, view);

        mRecentLocation = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY,null);

        if(mRecentLocation != null) {
            getForecast(mRecentLocation);
        }

        mDetailsTextView.setText("The weather for:  " + mRecentLocation);

        return view;
    }


    private void getForecast(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findForecast(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response)  {
                mForecast = weatherService.processForecastResults(response);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        mAdapter = new WeatherPagerAdapter(getActivity(), mForecast);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(getActivity());
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }


}
