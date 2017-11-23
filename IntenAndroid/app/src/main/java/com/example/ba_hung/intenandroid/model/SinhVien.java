package com.example.ba_hung.intenandroid.model;

import java.io.Serializable;

/**
 * Created by ba-hung on 09/08/2017.
 */

public class SinhVien implements Serializable{
    private String tenSinhVien;

    public SinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }
}
