package com.example.ba_hung.giaotieptrongfragment.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.ba_hung.giaotieptrongfragment.R;
import com.example.ba_hung.giaotieptrongfragment.ui.fragment.FragmentA;
import com.example.ba_hung.giaotieptrongfragment.ui.fragment.FragmentB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        themFragment(R.id.myLayout, new FragmentA());
    }

    public void themFragment(int id, Fragment fragment){
//        Thay vu tu tao ten thi lay ra ten cua fragment bang cach sau:
        FragmentManager fragmentManager = getSupportFragmentManager();
        String name = fragmentManager.getClass().getName();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.addToBackStack(name); // Đưa vào Stack
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.myLayout);
        if(fragment instanceof FragmentA){
            super.onBackPressed(); // Nếu là A thì thoát bình thường
            System.exit(0);
        } else if (fragment instanceof FragmentB){
//            super.onBackPressed();
            String name = fragment.getClass().getName();
            getSupportFragmentManager().popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        else {
            super.onBackPressed();
            System.exit(0);
        }

    }
}
