package com.example.ba_hung.customtoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                v = inflater.inflate(R.layout.customtoast,null);
                Toast t = new Toast(MainActivity.this);
                t.setView(v);
                t.setDuration(Toast.LENGTH_SHORT);
                t.setGravity(1,1,1);
                t.show();
            }
        });
    }
}
