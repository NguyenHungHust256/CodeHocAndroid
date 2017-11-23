package com.example.ba_hung.custom_listview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ba_hung.custom_listview.R;
import com.example.ba_hung.custom_listview.adapter.MusicAdapter;
import com.example.ba_hung.custom_listview.model.MusicModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;

    private ArrayList<MusicModel> datas;
    //Buoc 1: Kéo thả và ánh xạ ListView
    //Buoc 2: Tạo ra dữ liệu cho ListView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);

        datas = new ArrayList<>();
        datas.add(new MusicModel("Đếm ngày xa em"," Only C"));
        datas.add(new MusicModel("Quăng Ta Cái Boong","Huỳnh Jame"));
        datas.add(new MusicModel("Nước Ngoài","Phan Mạnh Quỳnh"));
        datas.add(new MusicModel("Sau Chia Tay","Phạm Hồng Phước"));
        datas.add(new MusicModel("Cơn Mưa Ngang Qua","Sơn Tùng"));

        MusicAdapter adapter = new MusicAdapter(MainActivity.this,datas);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,""+datas.get(position).getName() +" của "+datas.get(position).getAuthor() , Toast.LENGTH_SHORT).show();
            }
        });

    }

}
