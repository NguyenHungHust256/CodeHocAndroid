package com.example.ba_hung.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    ArrayList<String> tenKhoaHoc = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);

        tenKhoaHoc.add("PHP");
        tenKhoaHoc.add("ANDROID");
        tenKhoaHoc.add("IOS");
        tenKhoaHoc.add("DATABASE");
        tenKhoaHoc.add("WORDPRESS");
        tenKhoaHoc.add("RUBY ON RAILS");

        ListAdapter adapter = new com.example.ba_hung.customlistview.adapter.ListAdapter(MainActivity.this, R.layout.custom_listview,tenKhoaHoc);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, tenKhoaHoc.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
