package com.example.ba_hung.quanlysinhvien.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ba_hung.quanlysinhvien.model.SinhVienModel;

/**
 * Created by ba-hung on 16/08/2017.
 **/

public class QuanLySinhVienDao {
    private QuanLySinhVienDatabase quanLySinhVienDatabase;

    private SQLiteDatabase database;

    public QuanLySinhVienDao(Context context){
        quanLySinhVienDatabase= new QuanLySinhVienDatabase(context);
    }

    // Dung de mo csdl

    public void open(){
        database = quanLySinhVienDatabase.getWritableDatabase();
    }

    // DOng co so du lieu
    public void close(){
        database.close();
    }

    // Them du lieu
    public boolean ThemDuLieu(SinhVienModel svMoi){
        //Bien trung gian giúp chung ta đưa dữ liệu vào bên trong dâtbase
        ContentValues bienTrungGian = new ContentValues();
        bienTrungGian.put("Ten", svMoi.getTen());
        bienTrungGian.put("Tuoi", svMoi.getTuoi());
        long kiemTra = database.insert("SinhVien", null, bienTrungGian);
        if(kiemTra!=0)return  true;
        return  false;
    }
}
