package com.example.guest.stormtrooper.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.models.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;
import org.parceler.Parcels;

public class WeatherFragment extends Fragment {
    @BindView(R.id.weatherMainTextView)
    TextView mTextLabel;
    private Weather mWeather;


    public WeatherFragment() {
        // Required empty public constructor
    }

    public static WeatherFragment newInstance(Weather weather) {
        WeatherFragment weatherFragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putParcelable("weather", Parcels.wrap(weather));
        weatherFragment.setArguments(args);
        return weatherFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWeather = Parcels.unwrap(getArguments().getParcelable("weather"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather2, container, false);
        ButterKnife.bind(this, view);
//        return inflater.inflate(R.layout.fragment_weather2, container, false);

        mTextLabel.setText(mWeather.getMain());

        return view;
    }
}

