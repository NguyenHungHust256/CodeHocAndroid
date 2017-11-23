package com.example.ba_hung.quytrinhthuchienmotapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 3 bước
    //B1: Thiết kế giao diện
    //B2: Ánh xạ các view
    //B3: Viết code -> Viết chức năng cho các view
    //ID: R.drawable.tenanh
    private TextView txt;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TenView = (KieuView) findViewById(R.id.idobenFileXml);
        txt = (TextView) findViewById(R.id.txt);
        img =(ImageView) findViewById(R.id.img);

        txt.setText("Nguyễn Bá Hùng");
        img.setImageResource(R.drawable.background);

    }
}
