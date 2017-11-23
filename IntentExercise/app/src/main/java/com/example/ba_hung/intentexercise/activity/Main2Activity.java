package com.example.ba_hung.intentexercise.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ba_hung.intentexercise.R;
import com.example.ba_hung.intentexercise.model.SinhVien;

public class Main2Activity extends AppCompatActivity {

    TextView txtName, txtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtName = (TextView) findViewById(R.id.txtName);
        txtAge = (TextView) findViewById(R.id.txtAge);

        Bundle bd1 = getIntent().getExtras();

        SinhVien sv = (SinhVien) bd1.getSerializable("hung");
        if(bd1 != null){
            txtName.setText(sv.getName());
            txtAge.setText(sv.getAge()+"");
        }
    }
}
