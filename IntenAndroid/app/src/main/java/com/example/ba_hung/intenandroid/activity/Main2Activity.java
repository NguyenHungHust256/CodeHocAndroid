package com.example.ba_hung.intenandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ba_hung.intenandroid.R;
import com.example.ba_hung.intenandroid.model.SinhVien;

public class Main2Activity extends AppCompatActivity {
    Button btn2;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn2 = (Button) findViewById(R.id.btn2);
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);

        Bundle bd = getIntent().getExtras();
        //Kiểm tra xem bd != null thực sự nhận được một bundle
        if (bd != null) {
            SinhVien svReceive = (SinhVien) bd.getSerializable("bahung");
            txtKetQua.setText(svReceive.getTenSinhVien());
        }

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
