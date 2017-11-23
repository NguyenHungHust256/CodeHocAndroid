package com.example.ba_hung.giaotiepgiuacacfragment.model;

import java.io.Serializable;


public class QuocGiaModel implements Serializable {
    private String tenQuocGia;

    public QuocGiaModel(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }
}
