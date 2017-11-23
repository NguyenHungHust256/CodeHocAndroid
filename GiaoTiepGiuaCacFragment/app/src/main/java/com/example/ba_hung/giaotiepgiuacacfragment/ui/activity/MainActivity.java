package com.example.ba_hung.giaotiepgiuacacfragment.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.ba_hung.giaotiepgiuacacfragment.R;
import com.example.ba_hung.giaotiepgiuacacfragment.model.QuocGiaModel;
import com.example.ba_hung.giaotiepgiuacacfragment.ui.fragment.FragmentA;
import com.example.ba_hung.giaotiepgiuacacfragment.ui.fragment.FragmentB;

public class MainActivity extends AppCompatActivity implements FragmentA.CallBacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        themFragment(R.id.myLayout, new FragmentA());
    }

//    public void themFragment(int id, Fragment fragment){
//        String name = fragment.getClass().getName();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(id,fragment);
//        transaction.addToBackStack(name);
//        transaction.commit();
//    }
//

    public void themFragment(int id, Fragment fragment){
        String name = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.addToBackStack(name);
        transaction.commit();

    }

    @Override
    public void doiThongTin(QuocGiaModel quocGia) {
//        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragmentB);
//        fragmentB.thayDoiChuoi(quocGia);
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragmentB);
        fragmentB.thayDoiChuoi(quocGia);
    }
}
