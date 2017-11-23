package com.example.ba_hung.animationhomework.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.ba_hung.animationhomework.Adapter.dataAdapter;
import com.example.ba_hung.animationhomework.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    ArrayList<String> datas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);


        initData();

        dataAdapter adapter = new dataAdapter(MainActivity.this, datas);
        lv.setAdapter(adapter);


    }

    private void initData() {
       datas.add(new )
    }
}
