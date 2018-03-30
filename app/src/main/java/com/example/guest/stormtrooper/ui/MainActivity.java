package com.example.guest.stormtrooper.ui;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.models.Weather;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    private SharedPreferences mSharedPreferences;
//    private String mRecentLocation;
//    private SharedPreferences.Editor mEditor;

    private DatabaseReference mSearchedLocationReference;


    @BindView(R.id.findWeatherButton) Button mFindWeatherButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.frontPageTextView) TextView mFrontPageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSearchedLocationReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();

        Typeface droidFont = Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
        mFrontPageTextView.setTypeface(droidFont);

        mFindWeatherButton.setOnClickListener(this);


        }


    @Override
    public void onClick (View v) {
        if (v == mFindWeatherButton) {
            String location = mLocationEditText.getText().toString();

            saveLocationtoFirebase(location);

//            if(!(location).equals("")){
//                addToSharedPreferences(location);
//            }
//            if (location.length() <= 1) {
//                Toast.makeText(MainActivity.this, "Please add a location", Toast.LENGTH_LONG).show();
//            } else {
                Intent intent = new Intent(MainActivity.this, WeatherDetailActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);

            }
        }

        public void saveLocationtoFirebase(String location) {
        mSearchedLocationReference.push().setValue(location);
        }
//    }


//        private void addToSharedPreferences(String location) {
//            mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
//        }

    }



