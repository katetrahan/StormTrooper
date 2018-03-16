package com.example.guest.stormtrooper;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.returnWeatherButton) Button mReturnWeatherButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.locationPageTextView) TextView mLocationPageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Typeface droidFont = Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
        mLocationPageTextView.setTypeface(droidFont);
        mReturnWeatherButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v == mReturnWeatherButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(WeatherActivity.this,WeatherDetailActivity.class);
            intent.putExtra("location",location);
            startActivity(intent);
        }

    }
}
