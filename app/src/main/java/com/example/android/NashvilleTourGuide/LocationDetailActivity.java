package com.example.android.NashvilleTourGuide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LocationDetailActivity extends AppCompatActivity {

    int locations;
    TextView musicTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_detail);

        // Name of location
        findViewById(R.id.titleTextView);

        //get the current intent
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            locations = bundle.getInt("musicTitle");


            String locationTitle = locations.get(position).getTitle();
            String locationAddress = locations.get(position).getAddress();
            String locationHours = locations.get(position).getBusinessHours();
            String locationPrice = locations.get(position).getPrice();
            String locationDescription = locations.get(position).getDescription();
            int locationResource = locations.get(position).getImageResourceId();

        }
    }
}
