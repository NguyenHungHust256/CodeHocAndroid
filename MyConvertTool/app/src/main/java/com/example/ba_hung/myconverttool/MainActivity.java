package com.example.ba_hung.myconverttool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout distanceItem, weightItem, tempItem, speedItem;
    public static int DISTANCE_CONVERT = 0;
    public static int WEIGHT_CONVERT = 1;
    public static int TEMPERATURE_CONVERT = 2;
    public static int SPEED_CONVERT = 3;

    public int convert_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distanceItem = (RelativeLayout) findViewById(R.id.distance_item);
        weightItem = (RelativeLayout) findViewById(R.id.weight_item);
        tempItem = (RelativeLayout) findViewById(R.id.temperature_item);
        speedItem = (RelativeLayout) findViewById(R.id.speed_item);

        distanceItem.setOnClickListener(this);
        weightItem.setOnClickListener(this);
        tempItem.setOnClickListener(this);
        speedItem.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.distance_item)
        {
            convert_type =DISTANCE_CONVERT;
            Intent intent = new Intent(this,ConvertActivity.class);
            intent.putExtra("convert_type", convert_type);
            startActivity(intent);
        }
    }
}
