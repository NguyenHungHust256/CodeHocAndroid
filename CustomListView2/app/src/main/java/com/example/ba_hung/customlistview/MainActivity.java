package com.example.ba_hung.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    ArrayList<String> Datas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);

        Datas.add("VN");
        Datas.add("ENGLAND");
        Datas.add("THAILANDS");
        Datas.add("SINGAPORE");
        Datas.add("CAMPODIA");
        Datas.add("AMERICAN");
        Datas.add("MEXICO");

        //Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, Datas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ấn vào dòng nào toast ra tên quốc gia ấy
                Toast.makeText(MainActivity.this, Datas.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
