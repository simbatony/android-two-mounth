package com.example.simba.myapplication.sq.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class MySqlOpenHelper extends OrmLiteSqliteOpenHelper {
 
    private Dao<Person, Integer> mPersonDao;
 
    public MySqlOpenHelper(Context context) {
        super(context, "test", null, 1);
        // TODO Auto-generated constructor stub
    }
 
    @Override
    public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
        // TODO Auto-generated method stub
        try {
            //创建数据表
            TableUtils.createTableIfNotExists(arg1, Person.class);
        } catch (java.sql.SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
            int arg3) {
        // TODO Auto-generated method stub
 
    }
 
    public Dao<Person, Integer> getPersonDao() throws java.sql.SQLException {
        if (mPersonDao == null) {
            mPersonDao = getDao(Person.class);
        }
        return mPersonDao;
    }
 
}
//Dao是一个很重要的类， 这些Dao