package com.example.simba.myapplication.Weather;


import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.example.simba.myapplication.R;


/**
 * A login screen that offers login via email/password.
 */
public class weatherLoginActivity extends Activity{

    ImageView imageView;

    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_login);
        imageView =(ImageView) findViewById(R.id.backweather);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(weatherLoginActivity.this,WeatherActivity.class));
            }
             });

            }

}

