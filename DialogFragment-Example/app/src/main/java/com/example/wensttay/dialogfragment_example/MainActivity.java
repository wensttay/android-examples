package com.example.wensttay.dialogfragment_example;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDialogFragment(View view){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        CustomDialogFragmente customDialogFragmente = new CustomDialogFragmente(3, 2);
        customDialogFragmente.show(transaction, "dialog");
    }
    public void turnOffDialogFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        CustomDialogFragmente customDialogFragmente = (CustomDialogFragmente) getSupportFragmentManager()
                .findFragmentByTag("dialog");

        if(customDialogFragmente != null){
            customDialogFragmente.dismiss();
            transaction.remove(customDialogFragmente);
        }
    }
}
