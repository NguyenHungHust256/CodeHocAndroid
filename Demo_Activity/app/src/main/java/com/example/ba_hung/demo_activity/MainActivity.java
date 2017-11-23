package com.example.ba_hung.demo_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;
    private TextView lblWelcome;
    public static final int LOGIN_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
        lblWelcome = (TextView) findViewById(R.id.lbl_welcome);
    }

    @Override
    public void onClick(View v) {
        Intent intent  = new Intent(this, ActivityLogin.class);
        startActivityForResult(intent,LOGIN_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==LOGIN_REQUEST_CODE){
            if(resultCode==RESULT_OK){
                //Display Success
                lblWelcome.setText("LOGIN SUCCESS!");
                btnLogin.setVisibility(View.INVISIBLE);
            }
            else
            {
                //Display Fail
                lblWelcome.setText("LOGIN FAIL!");

            }
        }
    }
}
