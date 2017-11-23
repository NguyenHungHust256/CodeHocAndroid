package com.example.ba_hung.broadcastreceiverandroid.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ba_hung.broadcastreceiverandroid.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = (TextView) findViewById(R.id.txt);

        Bundle layDuLieu = getIntent().getExtras();
        if(layDuLieu != null){
            String noidung = layDuLieu.getString("noidung","");
            txt.setText(noidung);
        }

    }


}
