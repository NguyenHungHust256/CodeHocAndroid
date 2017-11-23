package com.example.ba_hung.on_sqlite.model;

/**
 * Created by ba-hung on 17/08/2017.
 **/

public class SinhVienModel {
    private int id;
    private String ten;

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    private int tuoi;

    public SinhVienModel(int id, String ten, int tuoi) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public SinhVienModel(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public int getTuoi() {
        return tuoi;

    }
}
