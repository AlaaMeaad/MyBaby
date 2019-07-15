package com.rqeeqa.mybaby.models;

import java.io.Serializable;

/**
 * Created by melde on 8/21/2017.
 */

public class AricleModel implements Serializable{
    String title ,desc;
    int image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
