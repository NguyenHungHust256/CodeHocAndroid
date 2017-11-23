package com.example.ba_hung.quanlysinhvien.model;

/**
 * Created by ba-hung on 16/08/2017.
 */

public class SinhVienModel {
    private int id;
    private String ten;
    private int tuoi;

    public SinhVienModel( String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
