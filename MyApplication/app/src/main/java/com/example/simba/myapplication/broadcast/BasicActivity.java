package com.example.simba.myapplication.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.simba.myapplication.R;

public class BasicActivity extends Activity {
    Button btnBasicSendNormal, btnBasicSendOrdered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        btnBasicSendNormal = (Button) findViewById(R.id.stopservice);
        btnBasicSendNormal.setText("这是一个普通广播");
        btnBasicSendOrdered = (Button) findViewById(R.id.startservice);
        btnBasicSendOrdered.setText(" 这是一个有序广播");

        btnBasicSendNormal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent broadcast=new Intent();
                broadcast.setAction("com.example.simba.myapplication.broadcast.BasicBroadcast");
                broadcast.putExtra("msg", "这是一个普通广播");
                sendBroadcast(broadcast);
            }
        });

        btnBasicSendOrdered.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent broadcast=new Intent();
                broadcast.setAction("com.example.simba.myapplication.broadcast.BasicBroadcast");
                broadcast.putExtra("msg", "这是一个有序广播");
                sendOrderedBroadcast(broadcast, null);
            }
        });
    }
}