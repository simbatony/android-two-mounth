package com.example.simba.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.cengalabs.flatui.FlatUI;
import com.cengalabs.flatui.views.FlatButton;
import com.cengalabs.flatui.views.FlatCheckBox;
import com.cengalabs.flatui.views.FlatEditText;
import com.cengalabs.flatui.views.FlatRadioButton;
import com.cengalabs.flatui.views.FlatSeekBar;
import com.cengalabs.flatui.views.FlatTextView;
import com.cengalabs.flatui.views.FlatToggleButton;

import java.sql.Date;
import java.util.ArrayList;

public class Main2Activity extends Activity {

        EditText editText;

    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0,0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutmain2);
        editText = (EditText)findViewById(R.id.text2);
        /*Intent intent = getIntent();
        String name = intent.getStringExtra("name");


        editText.setText(intent.getStringExtra("name")+intent.getIntExtra("age",10)+intent.getStringExtra("address"));
   */

        Intent intent = getIntent();
        User user = intent.getParcelableExtra("user");//得到一个对象
        System.out.println(user.toString());


        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        String restoredText = prefs.getString("name", null);
         if (restoredText != null) {
            String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
            int idName = prefs.getInt("idName", 0); //0 is the default value.
            System.out.println(name+idName+"!!!!!!!!!!!!!有数据了");
         }

      //  textView.setText(user.toString());
    }
}
