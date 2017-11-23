package com.example.ba_hung.demo_activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;
    private EditText edtName, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) this.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        edtName = (EditText) this.findViewById(R.id.edt_name);
        edtPass = (EditText) this.findViewById(R.id.edt_pass);
    }

    @Override
    public void onClick(View v) {
        String name = edtName.getText().toString();
        String pass = edtPass.getText().toString();

        if (name.equals("tuanlq") && pass.equals("123")) {
            //login success
            Intent intent = new Intent();
            setResult(Activity.RESULT_OK, intent);
            finish();
        } else {
            //login fail

            Intent intent = new Intent();
            setResult(Activity.RESULT_CANCELED, intent);
            finish();
        }
    }
}
