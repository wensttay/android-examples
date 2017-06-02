package com.example.wensttay.service_example;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ServiceConnection{

    private ServiceConnection connection;
    private ContadorInterface contador;
    private ResultReceiverExample rr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connection = this;

        bindService(new Intent("START_SERVICE_INTENT"), connection, Context.BIND_AUTO_CREATE);
    }

    public void startService(View view){
        rr = null;
        rr = new ResultReceiverExample(new Handler());

//        startService(new Intent("START_SERVICE").putExtra("rr", rr));

//        bindService(new Intent("START_SERVICE_BINDER"), connection, Context.BIND_AUTO_CREATE);
//        startService(new Intent("START_SERVICE_BINDER"));
        startService(new Intent(("START_SERVICE_INTENT")).putExtra("rr", rr));
    }

    public void stopService(View view){

//        stopService(new Intent("START_SERVICE"));

//        unbindService(connection);
//        stopService(new Intent("START_SERVICE_BINDER"));

        stopService(new Intent(("START_SERVICE_INTENT")));
    }

    public void showCount(View view){
        Toast.makeText(this, "Contador: " + contador.getCount(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.i("SERVICE-EXAMPLE", "onServiceConnected()");
//        ServiceBinderExample.Controller controller = (ServiceBinderExample.Controller) service;
        ServiceIntentExample.Controller controller = (ServiceIntentExample.Controller) service;
        contador = controller.getContador();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    public class ResultReceiverExample extends ResultReceiver {

        public ResultReceiverExample(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle bundle){
            if(resultCode == 1){
                final String count = bundle.getString("count");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, count, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }

    }
}
