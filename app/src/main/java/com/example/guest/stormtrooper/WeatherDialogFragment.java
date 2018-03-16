package com.example.guest.stormtrooper;


import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WeatherDialogFragment extends DialogFragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_weather_dialog, container, false);

        getDialog().setTitle("Simple Dialog");
        return rootView;
    }
}
