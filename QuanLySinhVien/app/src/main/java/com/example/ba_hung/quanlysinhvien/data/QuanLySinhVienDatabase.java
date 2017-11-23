package com.example.ba_hung.quanlysinhvien.data;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class QuanLySinhVienDatabase extends SQLiteAssetHelper {
    public QuanLySinhVienDatabase(Context context) {
        super(context, "QuanLySinhVien.sqlite",null, 1);
        }
}
