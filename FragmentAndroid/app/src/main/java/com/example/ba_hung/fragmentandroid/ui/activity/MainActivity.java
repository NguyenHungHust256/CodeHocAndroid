package com.example.ba_hung.fragmentandroid.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.ba_hung.fragmentandroid.R;
import com.example.ba_hung.fragmentandroid.ui.fragment.FragmentChinh;

public class MainActivity extends AppCompatActivity {

//    Fragment: Tai sử dụng giao diện,
//    hỗ trợ máy tính bảng
//  Fragment cũng bao gồm 2 file xml để làm giao diện cho mảnh ghép
//    Java để làm chức năng
//    Bước 1: Chuột phải vào fragment
//    Fragmnet muốn dùng đc phải để bên trong activity
//    ==> Activity (controller) chỉ dùng để hứa va dùng để điều hướng
//    ==> giao diện , chức nawnglogics, events (fragment)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        themFragment(R.id.myLayout, new FragmentChinh());

    }

    public void themFragment(int id, Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
//        Thực hiện các giao dịch thì dùng Fragment Transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }
}
