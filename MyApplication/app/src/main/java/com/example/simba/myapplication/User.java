package com.example.simba.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable//对象必须实现Parcelable接口才可以putExtra(或者序列化)
{
    String name;
    String psw;
    public User(String name, String psw)
    {
        super();
        this.name = name;
        this.psw = psw;
    }


    @Override
    public String toString()
    {
        return "User [name=" + name + ", psw=" + psw + "]";
    }
    @Override
    public int describeContents()
    {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags)//将属性写入Parcel对象
    {
        dest.writeString(name);
        dest.writeString(psw);
    }
                                  
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>()
    {
        public User createFromParcel(Parcel in)
        {
            return new User(in);//创建一个有参构造函数
        }
                                      
        public User[] newArray(int size)
        {
            return new User[size];
        }
    };
                                  
    public User(Parcel in)//根据写入的顺序依次读取
    {
        name = in.readString();
        psw = in.readString();
    }
}