package com.example.simba.myapplication;

import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Main1Activity extends AppCompatActivity {

    Button activityone;
    EditText editText1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        activityone =(Button)findViewById(R.id.activityone);
        editText1 = (EditText)findViewById(R.id.text1);
        activityone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText1.length()!=0){
                    System.out.println("editText1不是空的");
                }
                if (editText1.length()==0){
                    System.out.println("editText1是空的");
                }
                User user = new User("xiaoming", "xiaohong");
                Intent intent = new Intent(Main1Activity.this, Main2Activity.class);
                intent.putExtra("user", user);//传入对象,对象类必须实现Parcelable或者序列化
                startActivity(intent);

                SharedPreferences.Editor editor = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();
                editor.putString("name", "Elena");
                editor.putInt("idName", 12);
                editor.commit();


             /*   bundle.putString("name", "Ben");
                bundle.putInt("age", 28);
                bundle.putString("address", "China");
                intent.putExtras(bundle);
               // intent.putExtra("name", editText1.getText().toString());

                startActivity(intent);*/
            }
        });
    }

}
