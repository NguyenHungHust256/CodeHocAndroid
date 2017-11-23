package com.example.ba_hung.intentexercise.model;

import java.io.Serializable;

/**
 * Created by ba-hung on 09/08/2017.
 */

public class SinhVien implements Serializable {
    private String name;
    private int age;

    public SinhVien(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
