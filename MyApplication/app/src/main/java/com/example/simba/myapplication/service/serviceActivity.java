package com.example.simba.myapplication.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.simba.myapplication.R;

public class serviceActivity extends AppCompatActivity implements View.OnClickListener {

    Button startservice_button;
    Button stopservice_button;
    private final static String TAG = "SERVICE_TEST";
    private ServiceConnection sc;
    private boolean isBind;
    private LocalService sBinder=new LocalService();
    private LocalService mBoundService;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        init();
        startservice_button.setOnClickListener(this);
        stopservice_button.setOnClickListener( this);


        sc = new ServiceConnection() {

            @Override
            public void onServiceDisconnected(ComponentName name) {
            }
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
             /*   LocalService.SimpleBinder sBinder = (LocalService.SimpleBinder)service;
                System.out.println("3 + 5 = " + sBinder.add(3, 5));
                System.out.println(sBinder.getService().toString());*/
               // sBinder = ((LocalService.SimpleBinder) service).getService();
             //  System.out.println(   service.toString());

               // mBoundService = ((LocalService.SimpleBinder)service).getService();

            }
        };
    }
    private void init(){
        startservice_button = (Button)findViewById(R.id.startservice);
        stopservice_button = (Button)findViewById(R.id.stopservice);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startservice:
             /*   startService(new Intent(this, LocalService.class));
                System.out.println("servicestart");*/
                bindService(new Intent(serviceActivity.this, LocalService.class),sc, Context.BIND_AUTO_CREATE);
                isBind = true;
                System.out.println("servicestart");
                break;
            case R.id.stopservice:
                stopService(new Intent(this, LocalService.class));
                System.out.println("servicestop");
                break;

        }

    }
}
