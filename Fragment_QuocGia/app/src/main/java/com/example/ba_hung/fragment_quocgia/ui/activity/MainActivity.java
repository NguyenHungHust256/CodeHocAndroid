package com.example.ba_hung.fragment_quocgia.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.ba_hung.fragment_quocgia.R;
import com.example.ba_hung.fragment_quocgia.ui.fragment.FragmentTenQG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTenQG quocgia = new FragmentTenQG();
        themFragment(R.id.myLayout, quocgia);
    }
    public void themFragment(int id, Fragment fragment){
        String name = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.addToBackStack(name);
        transaction.commit();
    }
}
