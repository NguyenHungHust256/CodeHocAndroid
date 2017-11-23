package com.example.ba_hung.filebasetraining.model;

/**
 * Created by ba-hung on 24/08/2017.
 */

public class SinhVienModel{
    private String key;
    private String tenSV;
    private String ngaySinh;

    public SinhVienModel( String key, String tenSV, String ngaySinh) {
        this.key = key;
        this.tenSV = tenSV;
        this.ngaySinh = ngaySinh;
    }

    public SinhVienModel(String tenSV, String ngaySinh){
        this.tenSV = tenSV;
        this.ngaySinh = ngaySinh;
    }

    public String getKey() {
        return key;
    }

    public String getTenSV() {
        return tenSV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }
}
