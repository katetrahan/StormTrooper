//package com.example.guest.stormtrooper.ui;
//import android.app.FragmentManager;
//import android.content.Intent;
//import android.graphics.Typeface;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import okhttp3.Call;
//import okhttp3.Callback;
//
//import com.example.guest.stormtrooper.R;
//import com.example.guest.stormtrooper.adapters.RecArrayAdapter;
//import com.example.guest.stormtrooper.models.Weather;
//import com.example.guest.stormtrooper.services.WeatherService;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import okhttp3.Response;
//
//public class RecreationActivity extends AppCompatActivity {
//    public static final String TAG = RecreationActivity.class.getSimpleName();
//    @BindView(R.id.locationTextView)
//    TextView mLocationTextView;
////    @BindView(R.id.listView)
////    ListView mListView;
////    private String[] recreation = new String[] {"Walk", "Run", "Swim", "Fly a kite", "Drink coffee", "Go to a movie", "Call your mom"};
////    private String[] rainyDay = new String[] { "go to a movie", "watch netflix", "clean your room", "learn to sew"};
////    private String[] where = new String[] {"Terwiliger", "Forest Park", "Portland State Pool", "Local Park", "Stumptown", "Fox Tower Theatre", "Anywhere"};
//
//    public ArrayList<Weather> weathers = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recreation);
//        ButterKnife.bind(this);
//
////        RecArrayAdapter adapter = new RecArrayAdapter(this, android.R.layout.simple_list_item_1, recreation, where);
////        mListView.setAdapter(adapter);
//
////        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                String recreation = ((TextView) view).getText().toString();
////                Toast.makeText(RecreationActivity.this, recreation, Toast.LENGTH_LONG).show();
////
////            }
////        });
//
//        Intent intent = getIntent();
//        String location = intent.getStringExtra("location");
////        intent.putExtra("recreation", recreation);
////        intent.putExtra("where", where);
//
//        Typeface droidFont = Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
//        mLocationTextView.setTypeface(droidFont);
//
//        mLocationTextView.setText("What can I do today");
//
////        FragmentManager fm = getFragmentManager();
////        WeatherDialogFragment weatherDialogFragment = new WeatherDialogFragment();
////        weatherDialogFragment.show(fm, "Sample Fragment");
//
//
//    }
//
//    private void getWeather(String location) {
//        final WeatherService yService = new WeatherService();
//        yService.findWeather(location, new Callback() {
//
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                weathers = yService.processResults(response);
//
////                RecreationActivity.this.runOnUiThread(new Runnable() {
////                    @Override
////                    public void run() {
////                        String[] weathersMains = new String[weathers.size()];
////                        for (int i = 0; i < weathersMains.length; i++) {
////                            weathersMains[i] = weathers.get(i).getMain();
////                        }
////
////                        ArrayAdapter adapter = new ArrayAdapter(RecreationActivity.this,
////                                android.R.layout.simple_list_item_1,weathersMains);
////                        mListView.setAdapter(adapter);
////
////                        for (Weather weather: weathers) {
////                            Log.d(TAG, "Main"+ weather.getMain());
////                        }
//
//                }
//
//                });
////                try {
////                    String jsonData = response.body().string();
////                    if (response.isSuccessful()) {
////                        Log.v(TAG, jsonData);
////                        weathers = yService.processResults(response);
////                    }
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
//            }
//        });
//
//    }
//}
