package com.example.ba_hung.tuychinhtoastandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /// Tự tạo ra giao diện do chính mình thiết kế
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
    }


    public void displayToast(View view) {
        //Viet code bieeur thi caau thoong baos do minhf ddinhj nghiax
        // Buwows 2: Taoj ra mootj ddoois tuwownjg cos kieeur la Toast
        Toast t = new Toast(MainActivity.this);
        btn.setVisibility(View.INVISIBLE);
        // Thieets laapj thowif gian hieenr thij caau thoong baos
        t.setDuration(Toast.LENGTH_SHORT);

        //DDuwa toast hieenr thi taij trung taam manf hinhf
        t.setGravity(Gravity.CENTER,0,0);

        // Keets noois giao dieenj do minhf ddinhj nghiax truwowcs ddaayr vaof trong ddoois tuwowngj toast

        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        view = inflater.inflate(R.layout.toast_view, null);
        t.setView(view);

        //Hieenr thij Toast ra manf hinhf
        t.show();
    }
}
