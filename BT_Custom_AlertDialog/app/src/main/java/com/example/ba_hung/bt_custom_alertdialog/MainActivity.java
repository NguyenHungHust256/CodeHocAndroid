package com.example.ba_hung.bt_custom_alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hienThiDialog(View view) {
        if (view.getId() == R.id.btn1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Chúc Mừng");
            builder.setMessage("Bạn đã kết hôn");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "ahihi, đồ ngu, anh chưa có gấu", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "đẹp trai mới nhanh lấy vợ", Toast.LENGTH_SHORT).show();
                }
            });
            builder.create().show();
        }
        else if(view.getId()==R.id.btn2){
            
        }
    }
}
