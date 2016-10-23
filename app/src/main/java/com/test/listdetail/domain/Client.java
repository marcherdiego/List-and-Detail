package com.test.listdetail.domain;

import android.support.annotation.DrawableRes;

import java.io.Serializable;

public class Client implements Serializable {
    private int id;
    private String name;
    private String company;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @DrawableRes
    public int getImage() {
        return image;
    }

    public void setImage(@DrawableRes int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
