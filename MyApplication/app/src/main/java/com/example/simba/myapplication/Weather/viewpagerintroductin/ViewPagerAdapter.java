package com.example.simba.myapplication.Weather.viewpagerintroductin;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private List<View> views;
    private Context context;

    public  ViewPagerAdapter(List<View> views,Context context){
        this.views = views;
        this.context = context;

    }
    @Override
    public int getCount() {
        return views.size();
/*        return 500;*/
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager)container).addView(views.get(position));
        return  views.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
