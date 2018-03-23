package com.example.guest.stormtrooper.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.models.Weather;

import java.util.ArrayList;

import butterknife.BindView;

public class ConditionsArrayAdapter extends  RecyclerView.Adapter<ConditionsArrayAdapter.ConditonViewHolder>{
    private ArrayList<Weather> mWeather = new ArrayList<>();
    private Context mContext;

    public ConditionsArrayAdapter(Context context, ArrayList<Weather> conditions) {
        mContext = context;
        mWeather = conditions;
    }


    @Override
    public ConditionsArrayAdapter.ConditionViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recreation, parent, false);
        ConditionViewHolder viewHolder = new RecyclerView.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ConditionsArrayAdapter.ConditionViewHolder holder, int position){
        holder.bindWeather(mWeather.get(position));
    }


    @Override
    public int getItemCount() {
        return mWeather.size();
    }

    public class ConditionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.)
    }
}
