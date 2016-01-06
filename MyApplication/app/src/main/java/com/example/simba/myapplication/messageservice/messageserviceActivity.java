package com.example.simba.myapplication.messageservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.simba.myapplication.R;
import com.example.simba.myapplication.service.LocalService;

public class messageserviceActivity extends AppCompatActivity implements View.OnClickListener {

    Button startservice_button;
    Button stopservice_button;
    private com.example.simba.myapplication.messageservice.LocalService mBoundService;
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            // This is called when the connection with the service has been
            // established, giving us the service object we can use to
            // interact with the service.  Because we have bound to a explicit
            // service that we know is running in our own process, we can
            // cast its IBinder to a concrete class and directly access it.
            mBoundService = ((com.example.simba.myapplication.messageservice.LocalService.LocalBinder)service).getService();


        }

        public void onServiceDisconnected(ComponentName className) {
            // This is called when the connection with the service has been
            // unexpectedly disconnected -- that is, its process crashed.
            // Because it is running in our same process, we should never
            // see this happen.
            mBoundService = null;
          /*  Toast.makeText(Binding.this, R.string.local_service_disconnected,
                    Toast.LENGTH_SHORT).show();*/
        }
    };

/*    void doBindService() {
        // Establish a connection with the service.  We use an explicit
        // class name because we want a specific service implementation that
        // we know will be running in our own process (and thus won't be
        // supporting component replacement by other applications).
        bindService(new Intent(Binding.this,
                LocalService.class), mConnection, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService() {
        if (mIsBound) {
            // Detach our existing connection.
            unbindService(mConnection);
            mIsBound = false;
        }
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // doUnbindService();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        init();
        startservice_button.setOnClickListener(this);
        stopservice_button.setOnClickListener(this);
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
                bindService(new Intent(messageserviceActivity.this, com.example.simba.myapplication.service.LocalService.class),mConnection, Context.BIND_AUTO_CREATE);
               // isBind = true;
                System.out.println("servicestart");
                break;
            case R.id.stopservice:
                stopService(new Intent(this, LocalService.class));
                System.out.println("servicestop");
                break;

        }

    }
}
