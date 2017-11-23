package com.example.ba_hung.bt_toast_custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    private Animation alpha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =(Button) findViewById(R.id.btn);
        alpha = AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha);


       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast t = new Toast(MainActivity.this);
               t.setGravity(Gravity.CENTER,0,0);
               t.setDuration(Toast.LENGTH_SHORT);

               LayoutInflater xeChoHang = LayoutInflater.from(MainActivity.this);

               v = xeChoHang.inflate(R.layout.custom_toast, null);
               t.setView(v);
               btn.startAnimation(alpha);
               t.show();



           }
       });

    }
}
