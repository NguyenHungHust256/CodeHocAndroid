package com.example.ba_hung.intentexercise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ba_hung.intentexercise.R;
import com.example.ba_hung.intentexercise.model.SinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAge;
    Button btnAdd, btnSee;
    ArrayList<SinhVien> arrSV = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = (EditText) findViewById(R.id.edtName);
        edtAge = (EditText) findViewById(R.id.edtAge);

    }

    public void doSomeThing(View view) {
        if (view.getId() == R.id.btnAdd) {
            arrSV.add(new SinhVien(edtName.getText().toString(), Integer.parseInt(edtAge.getText().toString())));
            Toast.makeText(this, "Ban da them " + edtName.getText() + " tuoi " + edtAge.getText(), Toast.LENGTH_SHORT).show();
            edtName.setText("");
            edtAge.setText("");
        } else if (view.getId() == R.id.btnSee) {
            if (arrSV.isEmpty()) {
                Toast.makeText(this, "Xin loi ban chua co sinh vien", Toast.LENGTH_SHORT).show();
            } else {
                int x, a = 0;
                x = arrSV.get(0).getAge();
                for (int i = 0; i < arrSV.size(); i++) {
                    if (x < arrSV.get(i).getAge()) a = i;
                }
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                Bundle bd = new Bundle();

                bd.putSerializable("hung", arrSV.get(a));
                intent.putExtras(bd);

                startActivity(intent);
            }
        }
    }
}