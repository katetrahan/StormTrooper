package com.example.guest.stormtrooper.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.models.Weather;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlantListAdapter{
    private Context mContext;

    public PlantListAdapter(Context context) {
        mContext = context;

    }

//    @Override
//    public PlantListAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_list_item, parent, false);
//        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
//        return viewHolder;
//    }

//    @Override
//    public void onBindViewHolder(PlantListAdapter.WeatherViewHolder holder, int position) {
//
//    }

//    @Override
//    public int getItemCount() {
//
//    }


    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.weatherMainTextView)
        TextView mWeatherMainTextView;

        private Context mContext;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

        }

        public void bindWeather(Weather weather) {
            mWeatherMainTextView.setText(weather.getMain());
        }

    }

}
