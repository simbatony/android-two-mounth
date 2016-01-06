package com.example.simba.myapplication.Weather;

import com.example.simba.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Simba on 2015/12/04.
 */
public class Listviewleftdata {

    private ArrayList<Leftlistviewclass> mylistleft=new ArrayList<Leftlistviewclass>();

    public ArrayList<Leftlistviewclass> getMylistleft() {
        Leftlistviewclass Leftlistviewclass1= new Leftlistviewclass();
        Leftlistviewclass1.setImage(R.drawable.images);
        Leftlistviewclass1.setTitle("主页");
        mylistleft.add(Leftlistviewclass1);

        Leftlistviewclass Leftlistviewclass2= new Leftlistviewclass();
        Leftlistviewclass2.setImage(R.drawable.images);
        Leftlistviewclass2.setTitle("关于我们");
        mylistleft.add(Leftlistviewclass2);

        Leftlistviewclass Leftlistviewclass4= new Leftlistviewclass();
        Leftlistviewclass4.setImage(R.drawable.images);
        Leftlistviewclass4.setTitle("意见反馈");
        mylistleft.add(Leftlistviewclass4);

        Leftlistviewclass Leftlistviewclass3= new Leftlistviewclass();
        Leftlistviewclass3.setImage(R.drawable.images);
        Leftlistviewclass3.setTitle("退出");
        mylistleft.add(Leftlistviewclass3);



        return mylistleft;
    }



}
