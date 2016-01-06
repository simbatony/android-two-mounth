package com.example.simba.myapplication.getactivitylist;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.simba.myapplication.R;

import java.util.ArrayList;

public class getactivityActivity extends AppCompatActivity {


    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getactivity);
        list=getActivities(getApplicationContext());
        System.out.println("activity列表为");
        for (int i=list.size();i>0;i--){
            System.out.println(list.get(i-1));
        }
    }
    public  ArrayList<String> getActivities(Context ctx) {
        ArrayList<String> result = new ArrayList<String>();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.setPackage(ctx.getPackageName());
        for (ResolveInfo info : ctx.getPackageManager().queryIntentActivities(intent, 0)) {
            result.add(info.activityInfo.name);
          //  System.out.println(info.activityInfo.name);
        }
        return result;
    }

}
