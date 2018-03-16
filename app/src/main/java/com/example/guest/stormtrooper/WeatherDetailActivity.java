package com.example.guest.stormtrooper;



import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;



public class WeatherDetailActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.detailsTextView) TextView mDetailsTextView;
    @BindView(R.id.getIdeasButton) Button mGetIdeasButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        Typeface droidFont = Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
        mDetailsTextView.setTypeface(droidFont);


        mDetailsTextView.setText("The weather for:  " + location);
        mGetIdeasButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if (v == mGetIdeasButton) {

            Intent intent = new Intent(WeatherDetailActivity.this,RecreationActivity.class);
            startActivity(intent);

        }

    }
}

