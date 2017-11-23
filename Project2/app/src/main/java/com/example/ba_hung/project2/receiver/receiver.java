package com.example.ba_hung.project2.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.ba_hung.project2.MainActivity;

/**
 * Created by ba-hung on 11/09/2017.
 **/

public class receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("PROJECT1")) {
//            Bundle bd = intent.getExtras();
//            String noiDung = bd.getString("noidung","");
//
//            intent = new Intent(context, MainActivity.class);
//            bd = new Bundle();
//            bd.putString("noidung",noiDung);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent);
            Bundle bd = intent.getExtras();
            String noiDung = bd.getString("noidung", "");
            intent = new Intent(context, MainActivity.class);
            bd = new Bundle();
            bd.putString("noidung", noiDung);
            intent.putExtras(bd);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }
}
