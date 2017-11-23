package com.example.ba_hung.giaotieptrongfragment.model;

/**
 * Created by ba-hung on 01/09/2017.
 */

public class CauHoiModel {
    private String tenCauHoi;

    public CauHoiModel(String tenCauHoi, boolean dapAnDung) {
        this.tenCauHoi = tenCauHoi;
        this.dapAnDung = dapAnDung;
    }

    private boolean dapAnDung;

    public String getTenCauHoi() {
        return tenCauHoi;
    }

    public boolean isDapAnDung() {
        return dapAnDung;
    }
}
