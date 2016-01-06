package com.example.simba.myapplication.sq;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.simba.myapplication.R;

public class sqActivity extends AppCompatActivity {

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq);
        setTitle("xiaoming");

        db();

    }
    public  void db(){
        // 获取处理SQLiteOpenHelper的子类的SQLite的实例，如果只读，可以采用getReadableDatabase()，
        // 这个例子我们奖通过SQLiteDatabase实例的操作，来进行对数据进行增删改查询，采用可写的方式。
        db = new DBHelper(getApplicationContext(),"mydb",null,1).getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", "JackLi");
        cv.put("address", "QingYuan");
        //插入
        db.insert("user",null,cv);
        Log.v("mytab","-->have insert");
        //更新
        ContentValues cv2 = new ContentValues();
        cv2.put("name","HaiXin");
        db.update("user",cv2,"name=?",new String[]{"JackLi"});
        Log.v("mytab","-->have updated");

        //查询
        String[] columns = {"name", "address"};
        Cursor cursor = db.query("user",columns,"name = ?", new String[] {"HaiXin"},null,null,null);
        while (cursor.moveToNext())
        {
            String myname = cursor.getString(cursor.getColumnIndex("name"));
            Log.v("mytab","---->"+myname);
        }

        //删除
        db.delete("user","name = ?",new String[]{"HaiXin"});
        Log.v("mytab", "-->have delete");
    }

}
