package com.example.ba_hung.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {
    private TextView lblName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        Bundle extraData = getIntent().getExtras();
        String name = extraData.getString("NAME","GUEST");

        lblName = (TextView) this.findViewById(R.id.lbl_Name);
        lblName.setText(name);
    }
}
