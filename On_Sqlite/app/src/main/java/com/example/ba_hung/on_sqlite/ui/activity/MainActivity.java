package com.example.ba_hung.on_sqlite.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ba_hung.on_sqlite.R;
import com.example.ba_hung.on_sqlite.data.QuanLySinhVienDao;
import com.example.ba_hung.on_sqlite.model.SinhVienModel;

public class MainActivity extends AppCompatActivity {
    private EditText edtTen, edtTuoi;
    private Button btnThem, btnXem;
    QuanLySinhVienDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTen = (EditText) findViewById(R.id.edtTen);
        edtTuoi = (EditText) findViewById(R.id.edtTuoi);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnXem = (Button) findViewById(R.id.btnXem);

        dao = new QuanLySinhVienDao(MainActivity.this);
        dao.open();

    }

    public void doSomeThing(View view) {
        if (view.getId() == R.id.btnThem) {
            String ten = edtTen.getText().toString();
            int tuoi = Integer.parseInt(edtTuoi.getText().toString());
            SinhVienModel sv = new SinhVienModel(ten, tuoi);
            if (dao.addData(sv)) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
            }

            edtTen.setText("");
            edtTuoi.setText("");

        } else if (view.getId() == R.id.btnXem) {
            Intent intent = new Intent(MainActivity.this, XemActivity.class);
            startActivity(intent);

        }
    }
}
