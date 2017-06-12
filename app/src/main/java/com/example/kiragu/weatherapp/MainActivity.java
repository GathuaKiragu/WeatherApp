package com.example.kiragu.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.findLocation)
    Button mFindLocation;
    @Bind(R.id.locationEditText)
    EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
// Onclick listener
        mFindLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mFindLocation) {
                    String location = mLocationEditText.getText().toString();
                    Intent intent = new Intent(MainActivity.this, Locations.class);
                    intent.putExtra("location", location);
                    startActivity(intent);
                }
            }
        });
    }
}