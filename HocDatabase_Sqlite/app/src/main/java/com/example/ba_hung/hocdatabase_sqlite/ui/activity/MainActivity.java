package com.example.ba_hung.hocdatabase_sqlite.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ba_hung.hocdatabase_sqlite.R;
import com.example.ba_hung.hocdatabase_sqlite.data.QuanLySinhVienDAO;
import com.example.ba_hung.hocdatabase_sqlite.model.SinhVienModel;

public class MainActivity extends AppCompatActivity {
    private EditText edtTen, edtTuoi;
    private QuanLySinhVienDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        dao = new QuanLySinhVienDAO(MainActivity.this);
        dao.open();

    }

    private void AnhXa() {

        edtTen = (EditText) findViewById(R.id.edtTen);
        edtTuoi = (EditText) findViewById(R.id.edtTuoi);
    }

    public void doSomeThing(View view) {
        if (view.getId() == R.id.btnThem) {
            SinhVienModel sv = new SinhVienModel(edtTen.getText().toString(), Integer.parseInt(edtTuoi.getText().toString()));
            if(dao.addSV(sv)){
                Toast.makeText(this, "Đã thêm thành công!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Không thể thêm sinh viên vào!", Toast.LENGTH_SHORT).show();
            }

            edtTuoi.setText("");
            edtTen.setText("");


        } else if (view.getId() == R.id.btnXem) {
            Intent intent = new Intent(MainActivity.this, XemActivity.class);
            startActivity(intent);
        }
    }
}
