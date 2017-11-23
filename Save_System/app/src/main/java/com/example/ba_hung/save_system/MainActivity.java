package com.example.ba_hung.save_system;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtPassword;
    CheckBox cbDangNhap;
    Button btnXacNhan;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();

        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        //Lay gia tri tu sharedPreferences

        edtName.setText(sharedPreferences.getString("taikhoan",""));
        edtPassword.setText(sharedPreferences.getString("matkhau",""));
        cbDangNhap.setChecked(sharedPreferences.getBoolean("checked", false));



        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtName.getText().toString().trim();
                String pw = edtPassword.getText().toString().trim();

                Toast t = new Toast(MainActivity.this);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                if(ten.equals("hungnhu")&& pw.equals("12345678")){
                    v = inflater.inflate(R.layout.custom_toast_ok,null);
                    t.setView(v);
                    t.show();
                    if(cbDangNhap.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan",ten);
                        editor.putString("matkhau",pw);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                }
                else {
                    v = inflater.inflate(R.layout.custom_toast_fail,null);
                    t.setView(v);
                    t.show();
                }
            }
        });

    }

    private void Anhxa() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtPassword = (EditText) findViewById(R.id.edtPassWord);
        cbDangNhap = (CheckBox) findViewById(R.id.cbDangNhap);
        btnXacNhan= (Button) findViewById(R.id.btnXacNhan);
    }
}
