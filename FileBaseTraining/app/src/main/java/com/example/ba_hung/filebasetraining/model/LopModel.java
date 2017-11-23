package com.example.ba_hung.filebasetraining.model;

/**
 * Created by ba-hung on 23/08/2017.
 */

public class LopModel {
    private String maLop;
    private String tenLop;
    private String key;
    public LopModel(){

    }

    public String getKey() {
        return key;
    }

    public LopModel(String maLop, String tenLop, String key) {

        this.maLop = maLop;
        this.tenLop = tenLop;
        this.key = key;
    }

    public LopModel(String maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    public String getMaLop() {
        return maLop;
    }

    public String getTenLop() {
        return tenLop;
    }
}
