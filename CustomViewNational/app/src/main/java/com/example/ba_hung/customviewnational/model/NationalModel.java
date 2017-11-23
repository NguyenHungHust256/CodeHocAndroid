package com.example.ba_hung.customviewnational.model;


public class NationalModel {
    private String name;
    private int image;
    private String dNghia;

    public NationalModel(String name, int image, String dNghia) {
        this.name = name;
        this.image = image;
        this.dNghia = dNghia;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getdNghia() {
        return dNghia;
    }
}
