package com.example.wensttay.broadcastreceiver_example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by wensttay on 29/04/17.
 */

public class BroadcastReceiverXML extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("BROADCAST", "BroadcastReceiverXML iniciado");
    }
}
