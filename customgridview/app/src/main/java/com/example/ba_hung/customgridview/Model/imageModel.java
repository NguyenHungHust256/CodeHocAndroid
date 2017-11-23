package com.example.ba_hung.customgridview.Model;

/**
 * Created by ba-hung on 04/08/2017.
 **/

public class imageModel {
    private int imageId;
    private String name;

    public imageModel(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
