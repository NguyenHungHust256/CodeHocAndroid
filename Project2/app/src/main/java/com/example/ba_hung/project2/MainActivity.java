package com.example.ba_hung.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = (TextView) findViewById(R.id.txt);

        Bundle bd = getIntent().getExtras();
        if(bd != null){
            String noidung = bd.getString("noidung","");
            txt.setText(noidung);
        }
    }
}
