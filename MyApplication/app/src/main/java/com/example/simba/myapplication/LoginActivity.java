package com.example.simba.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;

import com.example.simba.myapplication.edicttext.otheredicttext;
import com.victor.loading.newton.NewtonCradleLoading;

import java.util.logging.Handler;


public class LoginActivity extends Activity {


    final android.os.Handler handler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            textviewcustomedicttext.setText(otheredicttext.gettext());
            super.handleMessage(msg);
        }
    };

    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.what = 3;
               // msg.obj = "ffhg";
                handler.sendMessage(msg);
            }

        }
    });


    otheredicttext otheredicttext;
    TextView textviewcustomedicttext;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutloading);
        otheredicttext=(otheredicttext)findViewById(R.id.otheredicttext);
        textviewcustomedicttext = (TextView)findViewById(R.id.textviewcustomedicttext);
        otheredicttext.setnum(5);
        t.start();
       // System.out.println(otheredicttext.gettext());

  /*      NewtonCradleLoading one= (NewtonCradleLoading)findViewById(R.id.newton_cradle_loading) ;
        one.start();;*/
    }




}


