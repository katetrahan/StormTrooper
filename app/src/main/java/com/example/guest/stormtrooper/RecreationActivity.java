package com.example.guest.stormtrooper;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecreationActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView)TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    private String[] recreation = new String[] {"walk", "run", "swim", "fly a kite", "drink coffee", "go to a movie", "call your mom"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recreation);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        mLocationTextView.setText("The weather for " + location);
    }
}
