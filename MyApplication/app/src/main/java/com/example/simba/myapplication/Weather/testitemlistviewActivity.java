package com.example.simba.myapplication.Weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.simba.myapplication.R;

import java.util.ArrayList;

public class testitemlistviewActivity extends AppCompatActivity {
/*ListView listView;
    ArrayList<Itemweather> mylist = new ArrayList<Itemweather>();
    @Override*/
    Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testitemlistview);
        button = (Button) findViewById(R.id.buttontest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(testitemlistviewActivity.this,weatherLoginActivity.class));
            }
        });
   /*     listView = (ListView)findViewById(R.id.listviewweather2);

        for (int i = 0; i < 20; i++) {
            // Create a new object for each list item
            Itemweather ld = new Itemweather();
            ld.setData2weather("2");
            ld.setData2weather("2");
            ld.setData2weather("2");
            ld.setData2weather("2");
            // Add this object into the ArrayList myList
            mylist.add(ld);
        }

        listView.setAdapter(new ItemweatherAdaper(testitemlistviewActivity.this,mylist));*/
    }

}
