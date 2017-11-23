package com.example.ba_hung.bttn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    private Button btn1, btn2;
    private int a = 0;

    int[] image = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5, R.drawable.image_6, R.drawable.image_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        img.setImageResource(image[0]);
    }

    public void doSomeThing(View view) {

        if (view.getId() == R.id.btn1) {
            if (a == 0) {
                Toast.makeText(this, "Đây chỉ mới là ảnh đầu tiên", Toast.LENGTH_SHORT).show();
            }
            if (a > 0){
                //                img.setImageResource(image[--a]);
                Glide.with(MainActivity.this)
                        .load(image[--a])
                        .into(img);
            }


        } else if (view.getId() == R.id.btn2) {
            if (a >= image.length - 1)
                Toast.makeText(this, "Hết ảnh rồi", Toast.LENGTH_SHORT).show();
            else if (a < image.length)
//                img.setImageResource(image[++a]);
                Glide.with(MainActivity.this)
                        .load(image[--a])
                        .into(img);
        }
    }
}
