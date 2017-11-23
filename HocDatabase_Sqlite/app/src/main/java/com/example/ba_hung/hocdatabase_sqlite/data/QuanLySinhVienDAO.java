package com.example.ba_hung.hocdatabase_sqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ba_hung.hocdatabase_sqlite.model.SinhVienModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 21/08/2017.
 **/

public class QuanLySinhVienDAO {
    private QuanLySinhVienDatabase quanLySinhVienDatabase;
    private SQLiteDatabase database;

    public QuanLySinhVienDAO(Context context) {
        quanLySinhVienDatabase = new QuanLySinhVienDatabase(context);
    }

    public void open(){
        database = quanLySinhVienDatabase.getWritableDatabase();
    }

    public boolean addSV(SinhVienModel sv){
        ContentValues bienTrungGian = new ContentValues();
        bienTrungGian.put("Ten",sv.getTen());
        bienTrungGian.put("Tuoi",sv.getTuoi());

        long kiemTra = database.insert("SinhVien",null, bienTrungGian);
        return kiemTra != -1;
    }

    public void DeleteSV(int id){
        String query = "DELETE FROM SINHVIEN WHERE ID = " + id;
        database.execSQL(query);
    }

    public void editSV(SinhVienModel sv){
        String query = "UPDATE SINHVIEN SET TEN = '" +sv.getTen()+"', TUOI = " + sv.getTuoi()+ " WHERE ID = "+sv.getId();
    }

    public ArrayList<SinhVienModel> getStudents(){
        ArrayList<SinhVienModel> result = new ArrayList<>();
        String query = "SELECT * FROM SINHVIEN";
        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            SinhVienModel sv = new SinhVienModel(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            result.add(sv);
            cursor.moveToNext();
        }
        return result;
    }
}
