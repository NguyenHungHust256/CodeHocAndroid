package com.example.ba_hung.volleyandroidother.model;

/**
 * Created by ba-hung on 30/08/2017.
 */

public class SanPhamModel {
    private int id_sanpham;
    private String ten_sanpham;
    private int id_sanhmuc;
    private int gia_sanpham;
    private String mota_sanpham;
    private int sanpham_noibat;
    private String anh_sanpham;

    public SanPhamModel(int id_sanpham, String ten_sanpham, int id_sanhmuc, int gia_sanpham, String mota_sanpham, int sanpham_noibat, String anh_sanpham) {
        this.id_sanpham = id_sanpham;
        this.ten_sanpham = ten_sanpham;
        this.id_sanhmuc = id_sanhmuc;
        this.gia_sanpham = gia_sanpham;
        this.mota_sanpham = mota_sanpham;
        this.sanpham_noibat = sanpham_noibat;
        this.anh_sanpham = anh_sanpham;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public String getTen_sanpham() {
        return ten_sanpham;
    }

    public int getId_sanhmuc() {
        return id_sanhmuc;
    }

    public int getGia_sanpham() {
        return gia_sanpham;
    }

    public String getMota_sanpham() {
        return mota_sanpham;
    }

    public int getSanpham_noibat() {
        return sanpham_noibat;
    }

    public String getAnh_sanpham() {
        return anh_sanpham;
    }
}
