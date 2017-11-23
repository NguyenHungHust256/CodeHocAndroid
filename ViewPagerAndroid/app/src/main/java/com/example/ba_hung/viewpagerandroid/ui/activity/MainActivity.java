package com.example.ba_hung.viewpagerandroid.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.ba_hung.viewpagerandroid.R;
import com.example.ba_hung.viewpagerandroid.ui.fragment.FragmentHome;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(R.id.myLayout, new FragmentHome());
    }

//    public void nextFragment(int id, Fragment fragment) {
//        String name = fragment.getClass().getName();
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction ft = manager.beginTransaction();
//        ft.replace(id, fragment);
//        ft.addToBackStack(name);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        ft.commit();
//    }
//
//    @Override
//    public void onBackPressed() {
//        try {
//            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.myLayout);
//            if (fragment instanceof FragmentHome) {
//                super.onBackPressed();
//                System.exit(0);
//            } else {
//                super.onBackPressed();
//                System.exit(0);
//            }
//        } catch (Exception e) {
//            super.onBackPressed();
//            System.exit(0);
//        }
//    }
    public void nextFragment (int id, Fragment fragment){
        String name = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(id, fragment);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
