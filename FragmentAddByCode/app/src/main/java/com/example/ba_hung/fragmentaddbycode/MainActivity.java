package com.example.ba_hung.fragmentaddbycode;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void AddFragment(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        if(view.getId() == R.id.btnAddA){
            fragment = new FragmentA();
        }
        else if(view.getId() == R.id.btnAddB){
            fragment = new FragmentB();
        }
        fragmentTransaction.replace(R.id.FrameContent, fragment);
        fragmentTransaction.commit();
    }
}
