package com.example.ba_hung.girdviewcustom.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.ba_hung.girdviewcustom.R;
import com.example.ba_hung.girdviewcustom.adapter.MusicAdapter;
import com.example.ba_hung.girdviewcustom.model.MusicModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gv;
    private ArrayList<MusicModel> music = new ArrayList<MusicModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = (GridView) findViewById(R.id.gv);

        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc Vui", "Hùng"));
        music.add(new MusicModel("Hát", "Cường"));
        music.add(new MusicModel("Khóc Hè", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc Cho Vui", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));
        music.add(new MusicModel("Khóc", "Hùng"));

        MusicAdapter musicAdapter = new MusicAdapter(MainActivity.this,music);
        gv.setAdapter(musicAdapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Dzzzzzzzzzzzzzzzzzzzzzzzx", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
