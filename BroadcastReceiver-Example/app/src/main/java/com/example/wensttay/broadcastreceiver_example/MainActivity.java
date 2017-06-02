package com.example.wensttay.broadcastreceiver_example;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter();
        filter.addAction("BROADCAST_RECEIVER_API");
        filter.addCategory(Intent.CATEGORY_DEFAULT);

        registerReceiver(new BroadcastReceiverAPI(), filter);
    }

    public void startBR(View view){
        Intent intent = new Intent(((Button) view).getText().toString());
        sendBroadcast(intent);
    }
}
