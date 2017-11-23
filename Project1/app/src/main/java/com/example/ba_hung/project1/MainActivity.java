package com.example.ba_hung.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // Tu tao ra tin hieu cua rieng minh , tin hieu ma chi co 2 app
    // Project 1 va 2 moi hieu
    public  static final String MY_ACTION = "PROJECT1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txt = (EditText) findViewById(R.id.txt);
        Button btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MY_ACTION);
                String noidung = txt.getText().toString();
                Bundle bd =new Bundle();
                bd.putString("noidung",noidung);
                intent.putExtras(bd);
                sendBroadcast(intent);
            }
        });
    }
}
