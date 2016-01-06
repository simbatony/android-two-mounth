package com.example.simba.myapplication.Weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.simba.myapplication.R;
import com.example.simba.myapplication.Weather.viewpagerintroductin.WeatherintroductionActivity;
import com.example.simba.myapplication.fragment.WeatherexitDialogFragment;

import java.util.ArrayList;

public class WeatheraboutusActivity extends AppCompatActivity {


    private ArrayList<Leftlistviewclass> mylistleft=new ArrayList<Leftlistviewclass>();
    ListView listViewleft;
    TextView textViewversion;
    Listviewleftdata Listviewleftdata=new Listviewleftdata();
    DrawerLayout drawerLayout;
    ImageView imageViewopenleftmenu;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatheraboutus);
        initleftmenu();
        initdrawerlayout();

        /*listView=(ListView)findViewById(R.id.left_drawerweatheraboutus);
        listView.setAdapter(new LeftlistviewBaeadaper(WeatheraboutusActivity.this, Listviewleftdata.getMylistleft()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(WeatheraboutusActivity.this, WeatherActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(WeatheraboutusActivity.this, WeatheraboutusActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(WeatheraboutusActivity.this, WeatherFeedbackActivity.class));


                        break;
                    case 3:
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        // Create and show the dialog.
                        WeatherexitDialogFragment FireMissilesDialogFragment = new WeatherexitDialogFragment();
                        FireMissilesDialogFragment.show(ft, "dialog");

                        break;


                }
            }
        });*/
        textViewversion=(TextView)findViewById(R.id.aboutusversion);
        textViewversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(WeatheraboutusActivity.class, WeatherintroductionActivity.class));
                // startActivity(new Intent(WeatheraboutusActivity.class, WeatherintroductionActivity.class));
               startActivity(new Intent(WeatheraboutusActivity.this, WeatherintroductionActivity.class));
            }
        });
    }
    public void initleftmenu(){
        listViewleft=(ListView)findViewById(R.id.left_drawerweather);

        listViewleft.setAdapter(new LeftlistviewBaeadaper(WeatheraboutusActivity.this, Listviewleftdata.getMylistleft()));
        listViewleft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(WeatheraboutusActivity.this, WeatherActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(WeatheraboutusActivity.this, WeatheraboutusActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(WeatheraboutusActivity.this, WeatherFeedbackActivity.class));
                        break;
                    case 3:
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        // Create and show the dialog.
                        WeatherexitDialogFragment FireMissilesDialogFragment = new WeatherexitDialogFragment();
                        FireMissilesDialogFragment.show(ft, "dialog");
                        break;
                }
            }
        });

        imageView=(ImageView)findViewById(R.id.imageicon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WeatheraboutusActivity.this, weatherLoginActivity.class));
            }
        });

    }
    public void initdrawerlayout(){

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layoutaboutus);
        imageViewopenleftmenu=(ImageView)findViewById(R.id.openleftmenuaboutus);
        imageViewopenleftmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });


    }


}
