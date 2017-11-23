package com.example.ba_hung.sqlitecoding.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ba_hung.sqlitecoding.model.SinhVienModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 13/09/2017.
 */

public class SinhVienDAO {
    private SinhVienDatabase sinhVienDatabase;
    private SQLiteDatabase db; //Thực thi câu truy vấn

    public SinhVienDAO(Context context) {
        sinhVienDatabase = new SinhVienDatabase(context);

    }

    public void open() {
        db = sinhVienDatabase.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public boolean themSinhVien(SinhVienModel sv) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SinhVienDatabase.NAME, sv.getTen());
        long kiemTra = db.insert(SinhVienDatabase.TABLE_NAME, null, contentValues);
        if (kiemTra != -1) {
            return true;
        }
        return false;
    }

    public ArrayList LayDuLieu() {
        String cautruyvan = "SELECT * FROM " + SinhVienDatabase.TABLE_NAME;
        ArrayList data = new ArrayList<>();
        Cursor conTro = db.rawQuery(cautruyvan, null);
        conTro.moveToFirst();
        while (!conTro.isAfterLast()) {
            int id = conTro.getInt(conTro.getColumnIndex(SinhVienDatabase.ID));
            String name = conTro.getString(conTro.getColumnIndex(SinhVienDatabase.NAME));
            data.add(new SinhVienModel(name, id));
            conTro.moveToNext();
        }
        conTro.close();
        return data;
    }

    public void xoaSinhVien(int idMuonXoa) {
        String cautruyvan = "DELETE FROM " + SinhVienDatabase.TABLE_NAME + " WHERE ID = " + idMuonXoa;
        db.execSQL(cautruyvan);
    }

    public void suaSinhVien(SinhVienModel svMoi) {
        String cautruyvan = "UPDATE " + SinhVienDatabase.TABLE_NAME + " SET " + SinhVienDatabase.NAME + " = '" + svMoi.getTen() + "' WHERE " + SinhVienDatabase.ID + " = " + svMoi.getId();
        db.execSQL(cautruyvan);
    }
}
