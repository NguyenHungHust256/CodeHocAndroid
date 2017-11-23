package com.example.ba_hung.gridview_animation.model;

/**
 * Created by ba-hung on 07/08/2017.
 */

public class ImageModel {
    private String name;
    private int imgID;

    public ImageModel(String name, int imgID) {
        this.name = name;
        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public int getImgID() {
        return imgID;
    }
}
