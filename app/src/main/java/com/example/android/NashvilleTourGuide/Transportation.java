package com.example.android.NashvilleTourGuide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.view.View.OnClickListener;


public class Transportation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        ImageView Button = findViewById(R.id.mta);

        Button.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.nashvillemta.org/");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}

