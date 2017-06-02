package com.example.wensttay.service_example;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wensttay on 29/04/17.
 */

public class ServiceExample extends Service {

    ResultReceiver resultReceiver;
    public List<Worker> workerList = new ArrayList<>();

    @Override
    public void onCreate(){
        super.onCreate();
        Log.i("SERVICE-EXAMPLE", "ServiceExample.onCreate()");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Worker worker = new Worker(startId);
        worker.start();
        workerList.add(worker);

        resultReceiver = intent.getParcelableExtra("rr");

        return super.onStartCommand(intent,flags, startId);
        // START_CONTINUATION_MASK
        // START_STICKY_COMPATIBILITY
        // START_STICKY
    }

    @Override
    public void onDestroy(){
        for (Worker worker : workerList){
            worker.ativo =false;
        }
    }

    class Worker extends Thread{

        public int id;
        public boolean ativo;
        private int count;

        public Worker(int id){
            super();
            this.id = id;
            this.ativo = true;
            this.count = 0;
        }

        @Override
        public void run(){
            Log.i("SERVICE-EXAMPLE", "Starting Worker " + id );

            while(ativo && count < 1000){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                Log.i("SERVICE-EXAMPLE", "Worker: "+ id + " | Count: " + count);

                Bundle bundle = new Bundle();
                bundle.putString("count", "Worker: "+ id + " | Count: " + count);
                resultReceiver.send(1, bundle);
            }
            stopSelfResult(id);
        }
    }
}
