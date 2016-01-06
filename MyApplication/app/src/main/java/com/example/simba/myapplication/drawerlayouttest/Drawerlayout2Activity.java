package com.example.simba.myapplication.drawerlayouttest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.simba.myapplication.ListData;
import com.example.simba.myapplication.MyBaseAdapter;
import com.example.simba.myapplication.R;

import java.util.ArrayList;

public class Drawerlayout2Activity extends AppCompatActivity {
    ListView listView;
    DrawerLayout drawerLayout;
    Button button;
    ArrayList<ListData> myList= new ArrayList<ListData>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout2);
        listView=(ListView)findViewById(R.id.left_drawer);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        button = (Button)findViewById(R.id.buttondrawerlayouttest);
        getDataInList();
        listView.setAdapter(new MyBaseAdapter(Drawerlayout2Activity.this, myList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // drawerLayout.openDrawer(Gravity.LEFT);
                drawerLayout.closeDrawer(Gravity.LEFT);
                System.out.println("clicked" + position);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

    }
    private void getDataInList() {
        for (int i = 0; i < 3; i++) {
            // Create a new object for each list item
            ListData ld = new ListData();
            ld.setTitle("title");
            ld.setDescription("desc   " + i);
            ld.setImgResId(R.drawable.images);
            // Add this object into the ArrayList myList
            myList.add(ld);
        }
    }

}
