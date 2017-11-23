package com.example.ba_hung.custom_toast.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ba_hung.custom_toast.R;
import com.example.ba_hung.custom_toast.adapter.MusicAdapter;
import com.example.ba_hung.custom_toast.model.MusicModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    public ArrayList<MusicModel> music = new ArrayList<MusicModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);

        music.add(new MusicModel("Yêu Là Tha Thu","Only C"));
        music.add(new MusicModel("Giá Như Có Thể Ôm Ai Đó Và Khóc","Phạm Hồng Phước"));
        music.add(new MusicModel("Quăng Tao Cái Boong","Huỳnh Jame"));
        music.add(new MusicModel("Mong Kiếp Sau Là Anh Em","Akira Phan"));
        music.add(new MusicModel("Sau Tất Cả","Erick"));

        MusicAdapter musicAdapter = new MusicAdapter(MainActivity.this, music);
        lv.setAdapter(musicAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, music.get(position).getTenBaiHat(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
