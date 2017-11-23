package com.example.ba_hung.sqlitecoding.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.ba_hung.sqlitecoding.R;
import com.example.ba_hung.sqlitecoding.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        themFragment(R.id.myLayout, new HomeFragment());
    }
    private void themFragment(int id, Fragment fragment){

        String name = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id,fragment);
        transaction.addToBackStack(name);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment  fragment = getSupportFragmentManager().findFragmentById(R.id.myLayout);
        if(fragment instanceof HomeFragment){
            super.onBackPressed();
            System.exit(0);
        }
        else {
            super.onBackPressed();
            System.exit(0);
        }
    }
}
