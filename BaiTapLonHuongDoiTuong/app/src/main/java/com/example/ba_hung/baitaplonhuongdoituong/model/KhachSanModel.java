package com.example.ba_hung.baitaplonhuongdoituong.model;

/**
 * Created by ba-hung on 28/09/2017.
 **/

public class KhachSanModel {
    private String address;
    private String description;
    private String imageUrl;
    private String name;
    private int numberStar;
    private String phoneNumber;
    private String latitude;
    private String longitude;

    public KhachSanModel(String address, String description, String imageUrl, String name, int numberStar, String phoneNumber, String latitude, String longitude) {
        this.address = address;
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
        this.numberStar = numberStar;
        this.phoneNumber = phoneNumber;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getNumberStar() {
        return numberStar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
