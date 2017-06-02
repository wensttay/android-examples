package com.example.wensttay.broadcastreceiveraux_example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by wensttay on 29/04/17.
 */

public class BroadcastReceiverOutroProjeto extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("BROADCAST", "BroadcastReceiverOutroProjeto iniciado");
//        Intent i = new Intent(context, MainActivity.class);
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(i);
    }
}
