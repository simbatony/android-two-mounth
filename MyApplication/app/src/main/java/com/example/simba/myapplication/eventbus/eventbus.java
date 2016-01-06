package com.example.simba.myapplication.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import de.greenrobot.event.EventBus;

/**
 * Created by Simba on 2016/01/03.
 */
public class eventbus extends AppCompatActivity {



    private EventBus bus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus.register(this);
        bus.post(new MessageEvent("xiaoming"));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }

  /*  public void onEvent(MessageEvent event){
        Toast.makeText(getApplicationContext(), event.message, Toast.LENGTH_SHORT).show();
        Log.d("!!!!!!!!!! !!!!!!!!", "!!!! !!!!!!!11");
    }
    public void onEventBackgroundThread(MessageEvent event){
       // saveToDisk(event.message);
        Log.d("!!!!!!!!!! !!!!!!!!", "!!!!12321321321321");
    }*/
    public void onEventAsync(MessageEvent event){
       // backend.send(event.message);
        Log.d("!!!!!!!!!! !!!!!!!!", "!!!!000000000000");
    }

}
