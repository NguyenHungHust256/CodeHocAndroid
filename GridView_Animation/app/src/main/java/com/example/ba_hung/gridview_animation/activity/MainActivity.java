package com.example.ba_hung.gridview_animation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.ba_hung.gridview_animation.R;
import com.example.ba_hung.gridview_animation.adapter.ImageAdapter;
import com.example.ba_hung.gridview_animation.model.ImageModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gv;
    ArrayList<ImageModel> datas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = (GridView) findViewById(R.id.gv);

        initData();

        ImageAdapter imageAdapter = new ImageAdapter(MainActivity.this, datas);
        gv.setAdapter(imageAdapter);
    }

    private void initData() {
        datas.add(new ImageModel("Image 1",R.drawable.index1));
        datas.add(new ImageModel("Image 2",R.drawable.index2));
        datas.add(new ImageModel("Image 3",R.drawable.index3));
        datas.add(new ImageModel("Image 4",R.drawable.index4));
        datas.add(new ImageModel("Image 5",R.drawable.index5));
        datas.add(new ImageModel("Image 6",R.drawable.index6));
        datas.add(new ImageModel("Image 7",R.drawable.index7));
        datas.add(new ImageModel("Image 8",R.drawable.index8));
        datas.add(new ImageModel("Image 9",R.drawable.index9));
        datas.add(new ImageModel("Image 10",R.drawable.index10));
        datas.add(new ImageModel("Image 1",R.drawable.index1));
        datas.add(new ImageModel("Image 2",R.drawable.index2));
        datas.add(new ImageModel("Image 3",R.drawable.index3));
        datas.add(new ImageModel("Image 4",R.drawable.index4));
        datas.add(new ImageModel("Image 5",R.drawable.index5));
        datas.add(new ImageModel("Image 6",R.drawable.index6));
        datas.add(new ImageModel("Image 7",R.drawable.index7));
        datas.add(new ImageModel("Image 8",R.drawable.index8));
        datas.add(new ImageModel("Image 9",R.drawable.index9));
        datas.add(new ImageModel("Image 10",R.drawable.index10));
        datas.add(new ImageModel("Image 1",R.drawable.index1));
        datas.add(new ImageModel("Image 2",R.drawable.index2));
        datas.add(new ImageModel("Image 3",R.drawable.index3));
        datas.add(new ImageModel("Image 4",R.drawable.index4));
        datas.add(new ImageModel("Image 5",R.drawable.index5));
        datas.add(new ImageModel("Image 6",R.drawable.index6));
        datas.add(new ImageModel("Image 7",R.drawable.index7));
        datas.add(new ImageModel("Image 8",R.drawable.index8));
        datas.add(new ImageModel("Image 9",R.drawable.index9));
        datas.add(new ImageModel("Image 10",R.drawable.index10));
        datas.add(new ImageModel("Image 1",R.drawable.index1));
        datas.add(new ImageModel("Image 2",R.drawable.index2));
        datas.add(new ImageModel("Image 3",R.drawable.index3));
        datas.add(new ImageModel("Image 4",R.drawable.index4));
        datas.add(new ImageModel("Image 5",R.drawable.index5));
        datas.add(new ImageModel("Image 6",R.drawable.index6));
        datas.add(new ImageModel("Image 7",R.drawable.index7));
        datas.add(new ImageModel("Image 8",R.drawable.index8));
        datas.add(new ImageModel("Image 9",R.drawable.index9));
        datas.add(new ImageModel("Image 10",R.drawable.index10));
        datas.add(new ImageModel("Image 1",R.drawable.index1));
        datas.add(new ImageModel("Image 2",R.drawable.index2));
        datas.add(new ImageModel("Image 3",R.drawable.index3));
        datas.add(new ImageModel("Image 4",R.drawable.index4));
        datas.add(new ImageModel("Image 5",R.drawable.index5));
        datas.add(new ImageModel("Image 6",R.drawable.index6));
        datas.add(new ImageModel("Image 7",R.drawable.index7));
        datas.add(new ImageModel("Image 8",R.drawable.index8));
        datas.add(new ImageModel("Image 9",R.drawable.index9));
        datas.add(new ImageModel("Image 10",R.drawable.index10));



    }
}
