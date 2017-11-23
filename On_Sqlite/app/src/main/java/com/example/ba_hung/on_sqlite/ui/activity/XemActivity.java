package com.example.ba_hung.on_sqlite.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ba_hung.on_sqlite.R;
import com.example.ba_hung.on_sqlite.data.QuanLySinhVienDao;
import com.example.ba_hung.on_sqlite.model.SinhVienModel;
import com.example.ba_hung.on_sqlite.ui.adapter.SinhVienAdapter;

import java.util.ArrayList;

public class XemActivity extends AppCompatActivity {

    private ListView lvSinhVien;
    private QuanLySinhVienDao dao;
    private ArrayList<SinhVienModel> datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem);

        // Ánh xạ ListView
        lvSinhVien = (ListView) findViewById(R.id.lvSinhVien);
        //Kết thúc ánh xạ listview

        dao = new QuanLySinhVienDao(XemActivity.this);
        dao.open();

        datas = dao.getStudents();

        SinhVienAdapter adapter = new SinhVienAdapter(XemActivity.this, datas, dao);
        lvSinhVien.setAdapter(adapter);

    }
}
