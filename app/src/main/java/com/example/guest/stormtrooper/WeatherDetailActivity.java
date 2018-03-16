package com.example.guest.stormtrooper;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;



public class WeatherDetailActivity extends AppCompatActivity {
    @BindView(R.id.detailsTextView) TextView mDetailsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String location = intent.getStringExtra("location");


        mDetailsTextView.setText("The weather for:  " + location);

    }
}
