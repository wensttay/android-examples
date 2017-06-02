package com.example.wensttay.service_example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by wensttay on 29/04/17.
 */

public class BroadcastReceiverReload extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("SERVICE-EXAMPLE", "BroadcastReceiverReload.onReceive()");
        Intent it = new Intent("START_SERVICE");
        context.startActivity(it);
    }
}
