package com.example.simba.myapplication.xutildata;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.simba.myapplication.xutildata.userxutil;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.DbException;

import java.util.List;

/**
 * Created by Simba on 2016/01/05.
 */
public class xutildata extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DbUtils db = DbUtils.create(this);
        Long t;
        try {
           // db.deleteAll(userxutil.class);
            db.dropTable(userxutil.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        Log.d("", "onCreate: " + System.currentTimeMillis());
        t = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {

            userxutil userxutil = new userxutil(); //这里需要注意的是User对象必须有id属性，或者有通过@ID注解的属性
            userxutil.setAddress("wyouflf@qq.com" +i);
            userxutil.setName("wyouflf" +i);
            userxutil.setAge(i + 10);
          //  userxutil.setId(1);
            try {
                db.save(userxutil);
            } catch (DbException e) {
                e.printStackTrace();
            }

        }
        long c=  System.currentTimeMillis() - t ;
        Log.d("", "onCreate: "+c);

        try {
            userxutil entity = db.findById(userxutil.class, 1);
            List<userxutil> list = db.findAll(userxutil.class);//通过类型查找
            for (int d=0;d<list.size();d++){
                Log.d("!!!!!!!!!!!!!!!!!!!!!!!", "onCreate: " + list.get(d).toString());
            }
           // Log.d("!!!!!!!!!!!!!!!!!!!!!!!", "onCreate: " + list.toString());
            userxutil Parent = db.findFirst(Selector.from(userxutil.class).where("name", "=", "wyouflf"));
        } catch (DbException e) {
            e.printStackTrace();
        }

    }

}
