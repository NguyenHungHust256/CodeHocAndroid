package com.example.ba_hung.boardcastreceivercoding;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txt = (TextView) findViewById(R.id.txt);

//        // Bước 1: Lọc ra những thông tin mà bạn muốn nghe
//        IntentFilter boLoc = new IntentFilter();
//        boLoc.addAction(Intent.ACTION_POWER_CONNECTED);
//        boLoc.addAction(Intent.ACTION_POWER_DISCONNECTED);
//
//        //Buoc 2: Cần tạo 1 đối tượng có kiểu là BroadCastReceiver
//        BroadcastReceiver mReciver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                // đáp trả hành động tương đương tương khi có hành động đến
//                if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
//                    txt.setText("dang sac");
//                } else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
//                    txt.setText("Khong dang sac");
//                }
//            }
//        };
//
//        // Buoc 3: đăngkí broadcastreceiver
//        registerReceiver(mReciver, boLoc);


//        Bước 1: Lọc ra những thông tin mà bạn muốn nghe
        IntentFilter boLoc = new IntentFilter();
        boLoc.addAction(Intent.ACTION_POWER_CONNECTED);
        boLoc.addAction(Intent.ACTION_POWER_DISCONNECTED);

//        Bước 2: Cần tạo 1 đối tượng có kiểu là BroadCastReceiver
        BroadcastReceiver mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
//                Đáp trả hành động tương đương khi có hành động đến
                if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
                    txt.setText("Đang Sạc");
                } else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
                    txt.setText("Không đang sạc");
                }
            }
        };
//        Bước 3: đăng kí broadCastReceiver
        registerReceiver(mReceiver, boLoc);

    }
}
