package com.example.ba_hung.logindangnhap25697.model;

/**
 * Created by ba-hung on 14/09/2017.
 */

public class UserModel {
    private String email;
    private String userName;
    private String passWord;

    public UserModel(String email, String userName, String passWord) {
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
