package com.example.ba_hung.baitaprenluyensotaynhahang.Model;

import java.io.Serializable;

/**
 * Created by ba-hung on 28/08/2017.
 */

public class NhaHangModel implements Serializable {
    private String ten;
    private int hinh;
    private float viDo;
    private float kinhDo;

    public NhaHangModel(String ten, int hinh, float viDo, float kinhDo) {
        this.ten = ten;
        this.hinh = hinh;
        this.viDo = viDo;
        this.kinhDo = kinhDo;
    }

    public NhaHangModel() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public float getViDo() {
        return viDo;
    }

    public void setViDo(float viDo) {
        this.viDo = viDo;
    }

    public float getKinhDo() {
        return kinhDo;
    }

    public void setKinhDo(float kinhDo) {
        this.kinhDo = kinhDo;
    }
}
