//package com.example.guest.stormtrooper.adapters;
//
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.support.v7.widget.RecyclerView;
//
//import com.example.guest.stormtrooper.R;
//import com.example.guest.stormtrooper.models.Weather;
//
//import java.util.ArrayList;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>{
//    private ArrayList<Weather> mWeather = new ArrayList<>();
//    private Context mContext;
//
//    public WeatherListAdapter(Context context, ArrayList<Weather> weathers){
//        mContext = context;
//        mWeather = weathers;
//    }
//
//    @Override
//    public WeatherListAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item,parent, false);
//        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(WeatherListAdapter.WeatherViewHolder holder, int position) {
//        holder.bindWeather(mWeather.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mWeather.size();
//    }
//
//    public class WeatherViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.weatherMainTextView)
//        TextView mWeatherMainTextView;
//
//        private Context mContext;
//
//        public WeatherViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//            mContext = itemView.getContext();
//
//        }
//
//        public void bindWeather(Weather weather) {
//            mWeatherMainTextView.setText(weather.getMain());
//        }
//
//    }
//
//}
