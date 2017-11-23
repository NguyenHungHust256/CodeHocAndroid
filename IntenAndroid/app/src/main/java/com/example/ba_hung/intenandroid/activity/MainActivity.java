package com.example.ba_hung.intenandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ba_hung.intenandroid.R;
import com.example.ba_hung.intenandroid.model.SinhVien;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 =(Button) findViewById(R.id.btn1);

    }

    public void doSomeThing(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        String dataSend = "Xin chao Nguyen Ba Hung 2";
        SinhVien sv = new SinhVien("Nguyen Ba Hung pro nguyen");
        //Bước 1:  Tao thung thu de chua cac buc thu
        Bundle bd = new Bundle();

        //Buoc 3: Bo Thư vào thùng
        bd.putString("xinchao",dataSend);
        bd.putSerializable("bahung",sv);

        // Bước 3: Gửi hộp thư đi
        intent.putExtras(bd);

        startActivity(intent);

    }
}
