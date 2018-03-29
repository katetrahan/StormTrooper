package com.example.guest.stormtrooper.adapters;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.models.Forecast;
import com.example.guest.stormtrooper.models.Weather;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherPagerAdapter extends RecyclerView.Adapter<WeatherPagerAdapter.WeatherViewHolder> {
    private ArrayList<Forecast> mForecast;
    private Context mContext;

    public WeatherPagerAdapter(Context context, ArrayList<Forecast> forecast) {
        mContext = context;
        mForecast = forecast;
    }
    @Override
    public void onBindViewHolder(WeatherPagerAdapter.WeatherViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }
    @Override
    public int getItemCount() {
        return mForecast.size();
    }
    @Override
    public WeatherPagerAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(WeatherPagerAdapter.WeatherViewHolder holder, int position) {
        holder.bindWeather(mForecast.get(position));
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.forecastTextView) TextView mConditionsView;
        @BindView(R.id.forecastDateTextView) TextView mConditionsDateView;
        @BindView(R.id.forecastRainTextView) TextView mConditionsRainView;
        private Context mContext;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindWeather(Forecast forecast) {
            mConditionsView.setText(forecast.getDesc());
            mConditionsDateView.setText(forecast.getDate());
//            mConditionsRainView.setText(forecast.getRain());

        }

    }

}


