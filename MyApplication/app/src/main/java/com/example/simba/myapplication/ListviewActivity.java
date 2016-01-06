package com.example.simba.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListviewActivity extends Activity {

    ListView lvDetail;
    Context context = ListviewActivity.this;
    ArrayList<ListData> myList = new ArrayList<ListData>();

    String[] title = new String[]{
            "Title 1", "Title 2", "Title 3", "Title 4",
            "Title 5", "Title 6", "Title 7", "Title 8"
    };
    String[] desc = new String[]{
            "Desc 1", "Desc 2", "Desc 3", "Desc 4",
            "Desc 5", "Desc 6", "Desc 7", "Desc 8"
    };
    int[] img = new int[]{
            R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images,
            R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_listview);

        lvDetail = (ListView) findViewById(R.id.listviewtest);
        // insert data into the list before setting the adapter
        // otherwise it will generate NullPointerException  - Obviously
        getDataInList();
        MyBaseAdapter adapter = new MyBaseAdapter(context, myList);
        lvDetail.setAdapter(adapter);
        lvDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Toast.makeText(getApplicationContext(),"您点击了"+position,Toast.LENGTH_LONG).show();

                System.out.println("点击了" + position);
            }
        });
    }

    private void getDataInList() {
        for (int i = 0; i < 30; i++) {
            // Create a new object for each list item
            ListData ld = new ListData();
            ld.setTitle(title[1]);
            ld.setDescription("desc   " + i);
            ld.setImgResId(img[1]);
            // Add this object into the ArrayList myList
            myList.add(ld);
        }
    }


}
