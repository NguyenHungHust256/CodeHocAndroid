package com.example.ba_hung.hocdatabase_sqlite.data;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by ba-hung on 21/08/2017.
 **/

public class QuanLySinhVienDatabase extends SQLiteAssetHelper {
    public QuanLySinhVienDatabase(Context context) {
        super(context,"QuanLySinhVien.sqlite", null, 1);
    }
}
