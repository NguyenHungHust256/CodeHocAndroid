package com.example.ba_hung.edittextandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtUserName;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUserName =(EditText) findViewById(R.id.txtUserName);
        txt = (TextView) findViewById(R.id.txt);
    }

    public void getData(View view) {
        String userName = txtUserName.getText().toString();
        txt.setText(userName);
    }
}
