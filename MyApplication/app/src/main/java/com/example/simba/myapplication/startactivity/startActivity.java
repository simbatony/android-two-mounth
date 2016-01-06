package com.example.simba.myapplication.startactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.simba.myapplication.R;
import com.example.simba.myapplication.eventbus.eventbus;
import com.example.simba.myapplication.mpchart.mpcharactivity;
import com.example.simba.myapplication.dialog.quickdialogActivity;
import com.example.simba.myapplication.sq.ormlite.litedata;
import com.example.simba.myapplication.xutildata.xutildata;

public class startActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_start);
        startActivity(new Intent(startActivity.this,eventbus.class));
    }
}
