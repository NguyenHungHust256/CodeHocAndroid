package com.example.ba_hung.on_sqlite.data;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

//Created by ba-hung on 17/08/2017.
// Dùng để kết nối database , đóng và mở CSDL

public class QuanLySinhVienDatabase extends SQLiteAssetHelper{
    public QuanLySinhVienDatabase(Context context) {
        super(context,"QuanLySinhVien.sqlite", null ,1);
    }
}
