package com.example.simba.myapplication.layoutinflactor;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.simba.myapplication.R;


/**
 * Created by Simba on 2015/12/30.
 */
public class Radiobutton extends Activity {

    android.widget.RadioButton radiobutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton);
        radiobutton = (android.widget.RadioButton)findViewById(R.id.radiobuttononeone);
        radiobutton.setChecked(true);

    }
}
