package com.rqeeqa.mybaby.models;

import java.io.Serializable;

/**
 * Created by melde on 8/21/2017.
 */

public class CatModel implements Serializable{
    String name;
    int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
