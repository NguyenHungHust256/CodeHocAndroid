package com.example.ba_hung.quanlysinhvien.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ba_hung.quanlysinhvien.R;
import com.example.ba_hung.quanlysinhvien.data.QuanLySinhVienDao;
import com.example.ba_hung.quanlysinhvien.model.SinhVienModel;

public class MainActivity extends AppCompatActivity {
    TextView txtThemTenSV, txtThemTuoiSV;
    Button btnThemSV, btnXemSV;
    private QuanLySinhVienDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ANh xa
        txtThemTenSV = (TextView) findViewById(R.id.txtThemTenSinhVien);
        txtThemTuoiSV =(TextView) findViewById(R.id.txtThemTuoiSinhVien);
        btnThemSV = (Button) findViewById(R.id.btnthemSV);
        btnXemSV = (Button) findViewById(R.id.btnXemSV);

        // Ket thuc anh xa
        // Tao database
        dao = new QuanLySinhVienDao(MainActivity.this);
        dao.open();

    }

    public void doSomeThing(View view) {
        if(view.getId()==R.id.btnthemSV){
            String tenSinhVien = txtThemTenSV.getText().toString();
            int tuoiSinhVien = Integer.parseInt( txtThemTuoiSV.getText().toString());

            SinhVienModel sv  = new SinhVienModel(tenSinhVien, tuoiSinhVien);
            if(dao.ThemDuLieu(sv)){
                Toast.makeText(this, "Ban them sinh vien thanh cong", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Ban khong them duoc", Toast.LENGTH_SHORT).show();
            }


        }

    }
}
