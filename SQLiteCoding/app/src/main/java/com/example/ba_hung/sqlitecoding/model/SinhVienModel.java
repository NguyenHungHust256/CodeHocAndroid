package com.example.ba_hung.sqlitecoding.model;

/**
 * Created by ba-hung on 13/09/2017.
 */

public class SinhVienModel  {
    private String ten;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SinhVienModel(String ten, int id) {
        this.ten = ten;
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

}
