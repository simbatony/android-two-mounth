package com.example.simba.myapplication.leftui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Simba on 2015/12/30.
 */
public class ui extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        final LinearLayout layout2=new LinearLayout(this);
        layout2.setOrientation(LinearLayout.VERTICAL);
        Button btn1=new Button(this);
       // setContentView(layout2);
        Button btn2=new Button(this);
        btn1.setText("Button1");
        btn2.setText("Button2");
        layout2.addView(btn1);
        layout2.addView(btn2);


        setContentView(layout2);
    }
}
