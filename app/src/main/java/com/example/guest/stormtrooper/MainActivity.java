package com.example.guest.stormtrooper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findWeatherButton) Button mFindWeatherButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindWeatherButton.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        if(v == mFindWeatherButton){
            Intent intent = new Intent(MainActivity.this,WeatherActivity.class);
            startActivity(intent);
        }
    }
}
