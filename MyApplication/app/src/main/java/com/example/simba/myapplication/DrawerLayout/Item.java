package com.example.simba.myapplication.DrawerLayout;

import android.widget.ImageView;

/**
 * Created by Simba on 2015/12/03.
 */
public class Item {

    private String title;
    private int imgResId;

    public Item(int images, String title) {
    this.title =  title;
        this.imgResId = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }
}
