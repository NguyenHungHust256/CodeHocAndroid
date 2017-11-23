package com.example.ba_hung.on_sqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ba_hung.on_sqlite.model.SinhVienModel;

import java.util.ArrayList;

//Created by ba-hung on 17/08/2017.

public class QuanLySinhVienDao {
    //DUng de mo CSDL
    private QuanLySinhVienDatabase quanLySinhVienDatabase;
    private SQLiteDatabase database;

    public QuanLySinhVienDao(Context context) {
        quanLySinhVienDatabase = new QuanLySinhVienDatabase(context);
    }

    public void open() {
        database = quanLySinhVienDatabase.getWritableDatabase();
    }

    public boolean addData(SinhVienModel sv) {
        // Biến trung gian giúp chúng ta đưa dữ liệu vào database
        ContentValues bienTrungGian = new ContentValues();

        bienTrungGian.put("Ten", sv.getTen());
        bienTrungGian.put("Tuoi", sv.getTuoi());

        long check = database.insert("SinhVien", null, bienTrungGian);

        return check != -1;
    }

    // Kết thúc chức năng thêm Sinh Viên

    //Chức năng lấy thông tin sinh viên từ database

    //Hàm trả về một ArayList có kiểu là SinhVienModel, từ đó dùng để hiển thị trên ListView

    public ArrayList<SinhVienModel> getStudents() {
        ArrayList<SinhVienModel> result = new ArrayList<>();

        String query = "SELECT * FROM " + "SinhVien";
        Cursor conTro = database.rawQuery(query, null);

//        Con trỏ đang đứng ở hàng đầu tiên
        conTro.moveToFirst();

        while (!conTro.isAfterLast()) {
//            đọc đến hết dữ liệu trong bảng
//            Lấy giá trị của từng hàng thông qia chỉ số cột
            int id = conTro.getInt(0);
            String ten = conTro.getString(1);
            int tuoi = conTro.getInt(2);

            SinhVienModel sv = new SinhVienModel(id, ten, tuoi);
            result.add(sv);
            conTro.moveToNext();// COn trỏ chuyển sang hàng tiếp theo
        }
        return result;
    }

//    Kêt thúc chức năng lấy thông tin sinh viên từ database

    //    Viết chức năng xóa dữ liệu
    public void deleteSV(int id) {
        String query = "DELETE FROM SINHVIEN WHERE ID = " + id;
        database.execSQL(query);
    }

    // Kết thúc chức năng xóa
//    Viết chức năng cho hàm sửa
    public void editSV(SinhVienModel sv) {
        String query = "UPDATE SINHVIEN SET TEN = '" + sv.getTen() + "',TUOI = " + sv.getTuoi() + " WHERE ID = " + sv.getId();
        database.execSQL(query);
    }


}
