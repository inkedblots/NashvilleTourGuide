package com.example.android.NashvilleTourGuide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationDetailActivity extends AppCompatActivity {

    String locationTitle;
    String locationAddress;
    String locationHours;
    String locationPrice;
    String locationDescription;
    int locationResource;

    TextView locationTextView;
    TextView descriptionTextView;
    TextView addressTextView;
    TextView businessHoursTextView;
    TextView priceTextView;
    ImageView resourceImageView;


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
            locationTitle = getIntent().getStringExtra("title");
            locationAddress = getIntent().getStringExtra("address");
            locationHours = getIntent().getStringExtra("hours");
            locationPrice = getIntent().getStringExtra("price");
            locationDescription = getIntent().getStringExtra("description");
            locationResource = getIntent().getIntExtra("image", 0);
        }
        locationTextView = findViewById(R.id.locationTextView);
        locationTextView.setText(locationTitle);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        descriptionTextView.setText(locationDescription);
        addressTextView = findViewById(R.id.addressTextView);
        addressTextView.setText(locationAddress);
        businessHoursTextView = findViewById(R.id.businessHoursTextView);
        businessHoursTextView.setText(locationHours);
        priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText(locationPrice);
        resourceImageView = findViewById(R.id.resourceImageView);
        resourceImageView.setImageResource(locationResource);

    }
}

