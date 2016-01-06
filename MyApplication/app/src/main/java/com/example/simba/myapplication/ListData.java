package com.example.simba.myapplication;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

public class ListData   {
 
        String Description;
        String title;
        int imgResId;



        public String getDescription() {
                return Description;
        }
 
        public void setDescription(String description) {
                Description = description;
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

        @Override
        public String toString() {
                return "ListData{" +
                        "Description='" + Description + '\'' +
                        ", title='" + title + '\'' +
                        ", imgResId=" + imgResId +
                        '}';
        }


}