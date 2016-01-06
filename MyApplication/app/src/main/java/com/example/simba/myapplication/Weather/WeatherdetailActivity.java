package com.example.simba.myapplication.Weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simba.myapplication.R;

public class WeatherdetailActivity extends AppCompatActivity {

    TextView temperature;
    TextView weather;
    TextView wind;
    TextView week;
    ImageView imageView;

    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatherdetail);
        Intent intent = getIntent();
        String data = intent.getStringExtra("testIntent");
        init();
        temperature.setText(intent.getStringExtra("Temperature"));
        weather.setText(intent.getStringExtra("Weather"));
        wind.setText(intent.getStringExtra("Wind"));
        week.setText(intent.getStringExtra("week"));
        System.out.println(data);

        }
    public void init(){

        temperature =(TextView)findViewById(R.id.temperaturetext2);
        weather =(TextView)findViewById(R.id.weathertext2);
        wind =(TextView)findViewById(R.id.windtext2);
        week =(TextView)findViewById(R.id.weektext2);
        imageView=(ImageView)findViewById(R.id.backweatherdatail);
       // imageView =(ImageView) findViewById(R.id.backweather);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WeatherdetailActivity.this,WeatherActivity.class));
            }
        });
    }

}
