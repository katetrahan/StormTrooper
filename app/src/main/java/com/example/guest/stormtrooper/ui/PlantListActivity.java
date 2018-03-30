package com.example.guest.stormtrooper.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest.stormtrooper.R;

import butterknife.ButterKnife;

public class PlantListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_list_item);
        ButterKnife.bind(this);


    }
}
