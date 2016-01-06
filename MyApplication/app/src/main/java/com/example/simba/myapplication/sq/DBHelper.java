package com.example.simba.myapplication.sq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 可以通过SQLiteOpenHelper的以下两个方法来或得SQLiteDatabase的对象：
 * getReadableDatabase() 创建或者打开一个查询数据库
 * getWritableDatabase() 创建或者打开一个可写数据库 
 */
public class DBHelper extends SQLiteOpenHelper {

    /**
     * 构造函数，必须实现
     * @param context 上下文路径
     * @param name 数据库名称
     * @param factory 可选游标工厂，通常为NULL
     * @param version 当前数据库版本号
     */

    private SQLiteDatabase mDataBase = null;
    private static final String USER_TABLE = "user";

    public DBHelper(Context context, String name, CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
        mDataBase = this.getWritableDatabase();
    }


    //数据库第一次创建时会调用，一般在其中创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        //使用execSQL()方法执行SQL语句，如果没有异常，这个方法没有返回值
        db.execSQL("create table user(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name varchar(20), address TEXT)");
        Log.v("mytab","-->onCreate");
    }

    //当数据库需要修改的时候，Android系统会主动的调用这个方法。
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    //打开数据库时的回调函数，一般不会用
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.v("mytab","-->onOpen");
    }

    @Override
    public synchronized void close() {
        super.close();
    }

}