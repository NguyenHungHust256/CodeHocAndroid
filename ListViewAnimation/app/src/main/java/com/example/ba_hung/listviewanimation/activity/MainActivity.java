package com.example.ba_hung.listviewanimation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.ba_hung.listviewanimation.R;
import com.example.ba_hung.listviewanimation.adapter.QuocGiaAdapter;
import com.example.ba_hung.listviewanimation.model.QuocGiaModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvTenQuocGia;

    ArrayList<QuocGiaModel> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTenQuocGia = (ListView) findViewById(R.id.lvTenQuocGia);

        addDatas();

        QuocGiaAdapter adapter = new QuocGiaAdapter(MainActivity.this,datas);
        lvTenQuocGia.setAdapter(adapter);
    }

    private void addDatas() {
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
        datas.add(new QuocGiaModel("Viet Nam"));
    }


}
