package com.example.android.NashvilleTourGuide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutNashville extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_nashville);

        TextView textView = findViewById(R.id.link);
        Spanned spanned = Html.fromHtml(getString(R.string.link));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spanned);
    }
}
