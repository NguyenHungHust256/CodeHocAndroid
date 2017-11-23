package com.example.ba_hung.openanotherapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTanGai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTanGai = (Button) findViewById(R.id.btnTanGai);
        btnTanGai.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnTanGai) {
            openAnotherApp(MainActivity.this, "vn.com.giavi.tangai");
        }
    }
// Kiểm tra app cài trên máy hay chưa
    private static boolean appInstalledOrNot(String uri, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void openAnotherApp(Context context, String pageNameApp) {
        boolean installed = appInstalledOrNot(pageNameApp, context);
        if (installed) {
            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(pageNameApp);
            context.startActivity(launchIntent);
        } else {
            Uri uri = Uri.parse("market://details?id=" + pageNameApp);
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            context.startActivity(goToMarket);
        }
    }
}
