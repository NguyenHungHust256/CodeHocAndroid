package com.example.ba_hung.myapplication;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView lbchangeFont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lbchangeFont = (TextView) this.findViewById(R.id.lbfont);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/cooperb.ttf");
        lbchangeFont.setTypeface(typeface);
    }
}
