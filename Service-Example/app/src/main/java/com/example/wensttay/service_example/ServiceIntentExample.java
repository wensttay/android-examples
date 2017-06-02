package com.example.wensttay.service_example;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

/**
 * Created by wensttay on 29/04/17.
 */

public class ServiceIntentExample extends IntentService implements ContadorInterface{

    private int count;
    private boolean ativo;
    private boolean stopAll;
    private Controller controller = new Controller();
    private ResultReceiver resultReceiver;

    public class Controller extends Binder {
        public ContadorInterface getContador(){
            return ServiceIntentExample.this;
        }
    }

    public ServiceIntentExample(){
        super("ServiceIntentExample");
        resetVariables();
        this.stopAll = false;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    private void resetVariables(){
        this.count = 0;
        this.ativo = true;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("SERVICE-EXAMPLE", "onBind()");

        return this.controller;
    }

    @Override
    public void onStart(Intent intent, int startId){
        super.onStart(intent, startId);
        Log.i("SERVICE-EXAMPLE", "onStart()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("SERVICE-EXAMPLE", "onStartCommand()");

        if(intent != null){
            Bundle extras = intent.getExtras();
            if(extras != null) {
                this.stopAll = extras.getBoolean("stopAll");
                resultReceiver = intent.getParcelableExtra("rr");
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("SERVICE-EXAMPLE", "onHandleIntent()");

        while(!stopAll && ativo && count < 5){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            Log.i("SERVICE-EXAMPLE", "Count: " + count);
            Bundle bundle = new Bundle();
            bundle.putString("count", "Count: " + count);
            resultReceiver.send(1, bundle);
        }

        resetVariables();
    }

    @Override
    public void onDestroy(){
        ativo = false;
    }
}
