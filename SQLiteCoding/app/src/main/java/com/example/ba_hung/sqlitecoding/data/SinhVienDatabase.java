package com.example.ba_hung.sqlitecoding.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ba-hung on 13/09/2017.
 **/

public class SinhVienDatabase extends SQLiteOpenHelper{
    public static final String DATABASE_NAME ="QUANLYSINHVIEN";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "SINHVIEN";
    public static final String ID = "ID";
    public static final String NAME = "NAME";

    public SinhVienDatabase(Context context) {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String cauTruyVan="CREATE TABLE "+TABLE_NAME+" ( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" TEXT);";
        db.execSQL(cauTruyVan);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion!=newVersion){
            String cauTruyVan = "DROP TABLE "+ TABLE_NAME + " IF EXISTS";
            db.execSQL(cauTruyVan);
        }

    }
}
