package com.example.ba_hung.fragment_quocgia.model;

import java.io.Serializable;

/**
 * Created by ba-hung on 06/09/2017.
 */

public class QuocGiaModel implements Serializable {
    private String tenQuocGia;

    public QuocGiaModel(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }
}
