package com.example.ba_hung.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnJump;
    private EditText edtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJump = (Button) this.findViewById(R.id.btn_jump);
        btnJump.setOnClickListener(this);

        edtName = (EditText) this.findViewById(R.id.edt_name);

    }

    @Override
    public void onClick(View v) {
        String strName = edtName.getText().toString();
        Intent intent = new Intent(this, activity2.class);
        intent.putExtra("NAME",strName);

        startActivity(intent);


    }
}
