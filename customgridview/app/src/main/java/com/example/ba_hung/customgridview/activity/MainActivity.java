package com.example.ba_hung.customgridview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.ba_hung.customgridview.Model.imageModel;
import com.example.ba_hung.customgridview.R;
import com.example.ba_hung.customgridview.adapter.imageAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gv;
    private ArrayList<imageModel> datas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = (GridView) findViewById(R.id.gv) ;

        datas.add(new imageModel(R.drawable.index1,"image 1"));
        datas.add(new imageModel(R.drawable.index2,"image 2"));
        datas.add(new imageModel(R.drawable.index3,"image 3"));
        datas.add(new imageModel(R.drawable.index4,"image 4"));
        datas.add(new imageModel(R.drawable.index5,"image 5"));

        imageAdapter imageAdapter = new imageAdapter(MainActivity.this, datas);

        gv.setAdapter(imageAdapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, datas.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
