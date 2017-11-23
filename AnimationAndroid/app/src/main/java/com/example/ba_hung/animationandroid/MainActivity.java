package com.example.ba_hung.animationandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // Cac buoc  tạo hiệu ứng.
    // BƯỚC 1: Chuột phải vào thư mục res tạo mới đặt tên là anim
    // Bước 2: Chuột phải vào thư mục anim chọn new và chọ Animation Resource File
    // (để tạo 1 file hiệu ứng
    //BƯỚC 3: ĐỔi SET thành hiệu ứng mình cần làm việc

    private Button btnAlpha, btnScale;
    private Animation alpha,scale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAlpha = (Button) findViewById(R.id.btnAlpha);
        btnScale = (Button) findViewById(R.id.btnScale);
        alpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
        scale = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
    }



    public void startAnimn(View view) {
        if (view.getId() == R.id.btnAlpha) {
            btnAlpha.startAnimation(alpha);
        } else if (view.getId() == R.id.btnScale) {
            btnScale.startAnimation(scale);

        } else if (view.getId() == R.id.btnTranslate) {

        } else if (view.getId() == R.id.btnRotate) {

        } else if (view.getId() == R.id.btnSet) {

        }
    }
}
