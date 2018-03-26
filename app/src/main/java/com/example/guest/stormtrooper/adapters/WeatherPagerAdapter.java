package com.example.guest.stormtrooper.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.models.Weather;
import com.example.guest.stormtrooper.ui.WeatherDetailActivity;
import com.example.guest.stormtrooper.ui.WeatherDialogFragment;
import com.example.guest.stormtrooper.ui.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WeatherPagerAdapter extends RecyclerView.Adapter<WeatherPagerAdapter.WeatherViewHolder> {
    private ArrayList<Weather> mWeather;
    private Context mContext;

    public WeatherPagerAdapter(Context context, ArrayList<Weather> weathers) {
        mContext = context;
        mWeather = weathers;
    }

    @Override
    public void onBindViewHolder(WeatherPagerAdapter.WeatherViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return mWeather.size();
    }

    @Override
    public WeatherPagerAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(WeatherPagerAdapter.WeatherViewHolder holder, int position) {
        holder.bindWeather(mWeather.get(position));
    }



    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.weatherConditionTextView)
        TextView mConditionsView;
        private Context mContext;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindWeather(Weather weather) {
            mConditionsView.setText(weather.getMain());
        }

    }

}


