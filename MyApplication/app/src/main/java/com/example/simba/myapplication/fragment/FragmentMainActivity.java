package com.example.simba.myapplication.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.simba.myapplication.R;


public class FragmentMainActivity extends Activity {

    private Button button1;
    private Button button2;
    private Button button3;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    Fragmentmain fragment1 = new Fragmentmain();
    Fragmentmore fragment3 = new Fragmentmore();
    Fragmentmyaccount fragment2 = new Fragmentmyaccount();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display display = getWindowManager().getDefaultDisplay();
        init();

        getFragmentManager().beginTransaction().replace(R.id.fragment, fragment1).commit();


    }

    public void init(){
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        editText1 = (EditText)findViewById(R.id.edicttext1);
        editText2 = (EditText)findViewById(R.id.edicttext2);
        editText3 = (EditText)findViewById(R.id.edicttext3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

         /*       Fragment fragment = new Fragment();
                Bundle bundle = new Bundle();
                bundle.putInt("age", 15);
                fragment.setArguments(bundle);*/


                 getFragmentManager().beginTransaction().replace(R.id.fragment, fragment1).commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                getFragmentManager().beginTransaction().replace(R.id.fragment, fragment2).commit();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().replace(R.id.fragment, fragment3).commit();
            }
        });

    }

    }




