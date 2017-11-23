package com.example.ba_hung.linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //Layout: (LinearLayout, RelativeLayout
    //Layout : Giup sap xếp và điều hướng các view theo các vị trí mà ta mong muốn
    //LinearLayout: Sắp xếp các view theo 2  chiều ngang or dọc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
