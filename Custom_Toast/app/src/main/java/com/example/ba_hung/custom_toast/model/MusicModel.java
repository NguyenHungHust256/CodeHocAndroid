package com.example.ba_hung.custom_toast.model;

/**
 * Created by ba-hung on 03/08/2017.
 */

public class MusicModel {
    private String tenBaiHat;
    private String tenCaSy;

    public MusicModel(String tenBaiHat, String tenCaSy) {
        this.tenBaiHat = tenBaiHat;
        this.tenCaSy = tenCaSy;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public String getTenCaSy() {
        return tenCaSy;
    }
}
