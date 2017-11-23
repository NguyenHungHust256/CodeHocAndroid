package com.example.ba_hung.intentseviceandroid.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.ba_hung.intentseviceandroid.bean.PlayNhac;

public class MyService1 extends Service {
    private PlayNhac playNhac = null;

    public MyService1() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (playNhac != null) {
            playNhac.play();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");


    }

    @Override
    public void onCreate() {
        super.onCreate();
        playNhac = new PlayNhac(getBaseContext());

    }

    @Override
    public void onDestroy() {
        if(playNhac!=null){
            playNhac.stop();
        }
        super.onDestroy();
    }
}
