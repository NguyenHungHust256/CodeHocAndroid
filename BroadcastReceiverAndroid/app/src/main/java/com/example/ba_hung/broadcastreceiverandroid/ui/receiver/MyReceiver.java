package com.example.ba_hung.broadcastreceiverandroid.ui.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.ba_hung.broadcastreceiverandroid.ui.activity.MainActivity;

/**
 * Created by ba-hung on 11/09/2017.
 **/

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            intent = new Intent(context, MainActivity.class);
            Bundle bd = new Bundle();
            bd.putString("noidung","dang sac");
            intent.putExtras(bd);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

}
