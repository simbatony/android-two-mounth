package com.example.simba.myapplication.layoutinflactor;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Switch;

import com.example.simba.myapplication.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;


/**
 * Created by Simba on 2015/12/30.
 */
public class layoutinflactor extends AppCompatActivity {

    Radiobutton radiobutton;

    @ViewInject(R.id.radiobuttonone)
    private Button buttonone;
    @ViewInject(R.id.radiobuttontwo)
    private Button buttontwo;
    @ViewInject(R.id.radiobuttonthree)
    private Button buttonthree;

    Button button;

    FrameLayout framelayout;

    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutinflactor);

        ViewUtils.inject(this);
        framelayout =(FrameLayout) findViewById(R.id.framelayout);
        view = LayoutInflater.from(layoutinflactor.this).inflate(R.layout.layoutmain2,null);

        button =(Button) view.findViewById(R.id.activityone);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"有效果了",Snackbar.LENGTH_SHORT).setAction(null,null).show();
            }
        });

        buttonone.setOnClickListener(listener);
        buttontwo.setOnClickListener(listener);
        buttonthree.setOnClickListener(listener);


    }


    Button.OnClickListener listener =new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.radiobuttonone:
                    Snackbar.make(v,"有效果了 1",Snackbar.LENGTH_SHORT).setAction(null,null).show();
                    framelayout.removeAllViews();
                    framelayout.addView(view);
                    break;

                case R.id.radiobuttontwo:
                    Snackbar.make(v,"有效果了2",Snackbar.LENGTH_SHORT).setAction(null,null).show();
                    framelayout.removeAllViews();
                    break;

                case R.id.radiobuttonthree:
                    Snackbar.make(v,"有效果了3",Snackbar.LENGTH_SHORT).setAction(null,null).show();
                    framelayout.removeAllViews();
                    break;


            }
        }
    };

}
