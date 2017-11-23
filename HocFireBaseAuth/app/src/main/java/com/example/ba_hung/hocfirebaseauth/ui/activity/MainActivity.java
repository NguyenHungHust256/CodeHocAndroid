package com.example.ba_hung.hocfirebaseauth.ui.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.ba_hung.hocfirebaseauth.R;
import com.example.ba_hung.hocfirebaseauth.ui.fragment.FragmentForgotPass;
import com.example.ba_hung.hocfirebaseauth.ui.fragment.FragmentLogin;
import com.example.ba_hung.hocfirebaseauth.ui.fragment.FragmentLoginGoogle;
import com.example.ba_hung.hocfirebaseauth.ui.fragment.FragmentLoginWithEmail;
import com.example.ba_hung.hocfirebaseauth.ui.fragment.FragmentLoginWithPhoneNumber;
import com.example.ba_hung.hocfirebaseauth.ui.fragment.FragmentProfile;
import com.example.ba_hung.hocfirebaseauth.ui.fragment.FragmentRegister;

public class MainActivity extends AppCompatActivity {
    //
//    public static final int NETWORK_TYPE_EHRPD=14; // Level 11
//    public static final int NETWORK_TYPE_EVDO_B=12; // Level 9
//    public static final int NETWORK_TYPE_HSPAP=15; // Level 13
//    public static final int NETWORK_TYPE_IDEN=11; // Level 8
//    public static final int NETWORK_TYPE_LTE=13; // Level 11
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xacDinhKetNoiMangHayChua();
        themFragment(R.id.myLayout, new FragmentLogin());
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    //    public void isConnectedFast(Context context) {
//        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo info = cm.getActiveNetworkInfo();
//        return (info != null && info.isConnected() && MainActivity.isConnectionFast(info.getType(), info.getSubtype()));
//    }
//
//    public static boolean isConnectionFast(int type, int subType){
//        if(type==ConnectivityManager.TYPE_WIFI){
//            System.out.println("CONNECTED VIA WIFI");
//            return true;
//        }else if(type==ConnectivityManager.TYPE_MOBILE){
//            switch(subType){
//                case TelephonyManager.NETWORK_TYPE_1xRTT:
//                    return false; // ~ 50-100 kbps
//                case TelephonyManager.NETWORK_TYPE_CDMA:
//                    return false; // ~ 14-64 kbps
//                case TelephonyManager.NETWORK_TYPE_EDGE:
//                    return false; // ~ 50-100 kbps
//                case TelephonyManager.NETWORK_TYPE_EVDO_0:
//                    return true; // ~ 400-1000 kbps
//                case TelephonyManager.NETWORK_TYPE_EVDO_A:
//                    return true; // ~ 600-1400 kbps
//                case TelephonyManager.NETWORK_TYPE_GPRS:
//                    return false; // ~ 100 kbps
//                case TelephonyManager.NETWORK_TYPE_HSDPA:
//                    return true; // ~ 2-14 Mbps
//                case TelephonyManager.NETWORK_TYPE_HSPA:
//                    return true; // ~ 700-1700 kbps
//                case TelephonyManager.NETWORK_TYPE_HSUPA:
//                    return true; // ~ 1-23 Mbps
//                case TelephonyManager.NETWORK_TYPE_UMTS:
//                    return true; // ~ 400-7000 kbps
//                // NOT AVAILABLE YET IN API LEVEL 7
//                case MainActivity.NETWORK_TYPE_EHRPD:
//                    return true; // ~ 1-2 Mbps
//                case MainActivity.NETWORK_TYPE_EVDO_B:
//                    return true; // ~ 5 Mbps
//                case MainActivity.NETWORK_TYPE_HSPAP:
//                    return true; // ~ 10-20 Mbps
//                case MainActivity.NETWORK_TYPE_IDEN:
//                    return false; // ~25 kbps
//                case MainActivity.NETWORK_TYPE_LTE:
//                    return true; // ~ 10+ Mbps
//                // Unknown
//                case TelephonyManager.NETWORK_TYPE_UNKNOWN:
//                    return false;
//                default:
//                    return false;
//            }
//        }else{
//            return false;
//        }
//    }
    public void xacDinhKetNoiMangHayChua() {
        ConnectivityManager cm =
                (ConnectivityManager) (MainActivity.this).getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (!isConnected) {
            Toast.makeText(this, "Bạn chưa kết nối mạng.", Toast.LENGTH_SHORT).show();
        }
    }

    public void huyVaThemFragment(Fragment fragmentA, int id, Fragment fragmentB) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragmentA);
        transaction.replace(id, fragmentB);
        transaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        transaction.commit();
    }

    public void themFragment(int id, Fragment fragment) {
        String name = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        transaction.addToBackStack(name);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        try {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.myLayout);
            if (fragment instanceof FragmentLogin) {
                super.onBackPressed();//nếu là A thì thoát bình thường
                System.exit(0);
            } else if (fragment instanceof FragmentLoginWithPhoneNumber) {
                String name = fragment.getClass().getName();
                getSupportFragmentManager().popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            } else if (fragment instanceof FragmentLoginWithEmail) {
                String name = fragment.getClass().getName();
                getSupportFragmentManager().popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            } else if (fragment instanceof FragmentRegister) {
                String name = fragment.getClass().getName();
                getSupportFragmentManager().popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            } else if (fragment instanceof FragmentForgotPass) {
                String name = fragment.getClass().getName();
                getSupportFragmentManager().popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            } else if (fragment instanceof FragmentProfile) {
                String name = fragment.getClass().getName();
                getSupportFragmentManager().popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            } else if (fragment instanceof FragmentLoginGoogle) {
                String name = fragment.getClass().getName();
                getSupportFragmentManager().popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            } else {
                super.onBackPressed();
                System.exit(0);
            }
        } catch (Exception e) {
            super.onBackPressed();
            System.exit(0);
        }
    }



}
