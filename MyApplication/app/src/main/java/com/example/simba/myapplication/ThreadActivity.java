package com.example.simba.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.logging.LogRecord;

public class ThreadActivity extends AppCompatActivity {


    TextView textView;
    Button button;
    int c=10;
    int i=1;
    final Handler myHandler = new Handler(){
        public void handleMessage(Message msg){


            switch (msg.what){

                case 10:

                    String string = (String) msg.obj;
                    //  textView.setText("xiaoming"+string);
                    c++;
                    textView.setText("haha"+c);
                    break;
            }
            super.handleMessage(msg);
        }
    };
    boolean b=true;
    Thread t =new Thread() {
        public void run() {


         /*   Message message = myHandler.obtainMessage();*/
                while (true) {
                    while (b) {

                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            // myHandler.obtainMessage(10).sendToTarget();

                            Message message = new Message();
                            message.what = 10;
                            message.obj = "ffhg";
                            myHandler.sendMessageDelayed(message, 0);

                    }
                }
          //  myHandler.sendMessageDelayed(message, 0);

        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        textView = (TextView)findViewById(R.id.threadtextview);
        button = (Button)findViewById(R.id.button_thread);



        button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
        /*        Message message = new Message();

                message.what =10;
                message.obj = "ffhg";

                myHandler.sendMessageDelayed(message,0);*/
          //      t.start();
                /*obtainmessage方式发送*/
             /*   Message message = myHandler.obtainMessage();
                myHandler.obtainMessage(10).sendToTarget();*/
                if (i==1){
                    t.start();
                    i=0;
                }
                else {

                   if (b==true){
                       b=false;
                   }
                    else {
                       b=true;
                   }

                }

            }
        });









                //  doStuff();         // 执行耗时操作
//                Message msg = myHandler.obtainMessage();
//                Bundle b = new Bundle();
//                b.putString("key", "value");
//                m.setData(b);    // 向消息中添加数据
//                myhandler.sendMessage(m);    // 向Handler发送消息，更新UI



    }

 /*   private void refreshui(){

        textView.setText(c++);
    }*/


/*    class Task implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 20; i++) {
                final int value = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
          *//*      handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(value);
                    }
                });*//*
            }
        }
    }*/


}
