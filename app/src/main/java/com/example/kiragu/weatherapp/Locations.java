package com.example.kiragu.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class Locations extends AppCompatActivity {
    public static final String TAG = Locations.class.getSimpleName();
    @Bind(R.id.locationText)
    TextView mLocationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationText.setText("Weather Information in: " + location);
        getLocation(location);
    }

//method that recieves the responce from the api
    private void getLocation(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findWeatherInfo(location, new Callback() {

// Called when the request is unsuccessfull
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
