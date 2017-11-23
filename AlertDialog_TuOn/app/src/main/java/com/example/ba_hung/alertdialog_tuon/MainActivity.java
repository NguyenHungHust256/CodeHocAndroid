package com.example.ba_hung.alertdialog_tuon;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomeThing(View view) {
        if(view.getId()==R.id.btn1){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Bình Tĩnh");
            builder.setMessage("Cuộc đời mà bạn");
            builder.setPositiveButton("Chuẩn", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Đúng rồi", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Chưa đủ chất", Toast.LENGTH_SHORT).show();
                }
            });
            builder.create().show();
        }
        else if(view.getId()==R.id.btn2){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Nguyen Hung");
            final String[] keTau = new String[]{
                "Machine Learning",
                "Deep Learning",
                "Big Data",
                "Data Mining",
                "Natural Language"};
            builder.setItems(keTau, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, keTau[which], Toast.LENGTH_SHORT).show();
                }
            });
            builder.create().show();
        }
        else if(view.getId() == R.id.btn3){
            View v;
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            v = inflater.inflate(R.layout.interface_alert_dialog, null);

            Dialog dialog = new Dialog(MainActivity.this,R.style.theme_dialog);

            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(v);
            dialog.show();
        }
    }
}
