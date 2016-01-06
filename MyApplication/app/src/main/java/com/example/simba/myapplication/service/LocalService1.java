package com.example.simba.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LocalService1 extends Service {
 
    /**
     * onBind 是 Service 的虚方法，因此我们不得不实现它。
     * 返回 null，表示客服端不能建立到此服务的连接。
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
     
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate() executed");
    }
     
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        System.out.println("onstart() executed");
    }
     
    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("ondestroy() executed");
    }
 
}