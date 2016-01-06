package com.example.simba.myapplication.DrawerLayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.simba.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DrawerLayoutActivity extends AppCompatActivity {





        private DrawerLayout drawer_layout;
        private ListView list_left_drawer;
        private ArrayList<Item> menuLists;
      //  private List<Item> myAdapter = null;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_drawer_layout);

            drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
            list_left_drawer = (ListView) findViewById(R.id.list_left_drawer);

            menuLists = new ArrayList<Item>();
            menuLists.add(new Item(R.drawable.images,"实时信息"));
            menuLists.add(new Item(R.drawable.images,"提醒通知"));
            menuLists.add(new Item(R.drawable.images,"活动路线"));
            menuLists.add(new Item(R.drawable.images,"相关设置"));
            MyBaseAdapterDrawer myAdapter = new MyBaseAdapterDrawer(DrawerLayoutActivity.this,menuLists);
            list_left_drawer.setAdapter(myAdapter);
           // list_left_drawer.setOnItemClickListener(this);
        }


  /*      @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ContentFragment contentFragment = new ContentFragment();
            Bundle args = new Bundle();
            args.putString("text", menuLists.get(position).getIconName());
            contentFragment.setArguments(args);
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.ly_content,contentFragment).commit();
            drawer_layout.closeDrawer(list_left_drawer);
        }*/

}
