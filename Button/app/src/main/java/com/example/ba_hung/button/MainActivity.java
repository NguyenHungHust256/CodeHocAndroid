package com.example.ba_hung.button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomeThing(View view) {
        Toast.makeText(this, "Hello Hung", Toast.LENGTH_SHORT).show();
    }
}
