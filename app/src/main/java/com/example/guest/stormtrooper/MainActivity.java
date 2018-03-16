package com.example.guest.stormtrooper;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findWeatherButton) Button mFindWeatherButton;
    @BindView(R.id.frontPageTextView) TextView mFrontPageTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
        mFrontPageTextView.setTypeface(ostrichFont);

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
