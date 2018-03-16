package com.example.guest.stormtrooper;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.returnWeatherButton) Button mReturnWeatherButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        mReturnWeatherButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if (v == mReturnWeatherButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(WeatherActivity.this,RecreationActivity.class);
            intent.putExtra("location",location);
            startActivity(intent);
        }

    }
}
