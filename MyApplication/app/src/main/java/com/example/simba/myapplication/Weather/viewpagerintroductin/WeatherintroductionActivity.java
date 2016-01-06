package com.example.simba.myapplication.Weather.viewpagerintroductin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.simba.myapplication.R;
import com.example.simba.myapplication.Weather.WeatherActivity;

import java.util.ArrayList;
import java.util.List;

public class WeatherintroductionActivity extends AppCompatActivity {
    private List<View> views;
    private ViewPager vp;
    private ViewPagerAdapter vpAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatherintroduction);
        initView();




    }
    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.weatherviewpagerthree, null));
        views.add(inflater.inflate(R.layout.weatherviewpagertwo, null));
        views.add(inflater.inflate(R.layout.weatherviewpangeont, null));



        vpAdapter = new ViewPagerAdapter(views, this);
        vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(vpAdapter);



    }
    public void imgageOnclicked(View view){

        startActivity(new Intent(WeatherintroductionActivity.this, WeatherActivity.class));
    }

}
