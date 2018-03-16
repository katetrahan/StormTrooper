package com.example.guest.stormtrooper;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        RecArrayAdapter adapter = new RecArrayAdapter(this, android.R.layout.simple_list_item_1, recreation);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String recreation = ((TextView)view).getText().toString();
                Toast.makeText(RecreationActivity.this, recreation, Toast.LENGTH_LONG).show();

            }
        });


                Intent intent = getIntent();
                String location = intent.getStringExtra("location");


                mLocationTextView.setText("The weather for:  " + location);



        }
    }
