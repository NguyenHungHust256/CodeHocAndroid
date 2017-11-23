package com.example.ba_hung.hocdatabase_sqlite.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.ba_hung.hocdatabase_sqlite.R;
import com.example.ba_hung.hocdatabase_sqlite.data.QuanLySinhVienDAO;
import com.example.ba_hung.hocdatabase_sqlite.model.SinhVienModel;
import com.example.ba_hung.hocdatabase_sqlite.ui.adapter.SinhVienAdapter;

import java.util.ArrayList;

public class XemActivity extends AppCompatActivity {
    private ListView lv;
    private QuanLySinhVienDAO dao;
    private ArrayList<SinhVienModel> datas ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem);

        lv = (ListView) findViewById(R.id.lvSinhVien);

        dao = new QuanLySinhVienDAO(XemActivity.this);
        dao.open();

        datas = dao.getStudents();

        SinhVienAdapter adapter = new SinhVienAdapter(XemActivity.this,datas);
        lv.setAdapter(adapter);

    }
}
