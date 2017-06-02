package com.example.wensttay.service_example;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by wensttay on 29/04/17.
 */

public class ServiceBinderExample extends Service implements ContadorInterface{

    private int count = 0;
    private boolean ativo = true;
    private Controller controller = new Controller();

    public class Controller extends Binder{
        public ContadorInterface getContador(){
            return ServiceBinderExample.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("SERVICE-EXAMPLE", "onBind()");
        startCountThread();
        return this.controller;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startCountThread();
        Log.i("SERVICE-EXAMPLE", "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public int getCount() {
        return count;
    }

    private void startCountThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(ativo && count < 1000){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    Log.i("SERVICE-EXAMPLE", "Count: " + count);
                }
            }
        }).start();
    }

    @Override
    public void onDestroy(){
        ativo = false;
    }
}
