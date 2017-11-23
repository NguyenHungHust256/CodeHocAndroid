package com.example.ba_hung.intentseviceandroid.services;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.example.ba_hung.intentseviceandroid.bean.PlayNhac;


public class MyService extends IntentService {
    private PlayNhac playNhac = null;
    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("STOP")) {

   }

        }
    };


    public MyService() {
        super("MyService");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        playNhac = new PlayNhac(getBaseContext());
        IntentFilter filter = new IntentFilter();
        filter.addAction("STOP");
        registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
//       Công việc thực thi sẽ viết trong hàm này
        if(playNhac!=null){
            playNhac.play();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}
