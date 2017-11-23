package com.example.ba_hung.progressdialogcustom;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the Drawable custom_progressbar
        Drawable draw=this.getDrawable(R.drawable.animation_loading);
// set the drawable as progress drawable
        progressBar.setProgressDrawable(draw);
    }
}
