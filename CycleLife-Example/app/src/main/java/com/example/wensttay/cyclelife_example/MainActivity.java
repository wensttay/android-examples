package com.example.wensttay.cyclelife_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String CATEGORIA = "Script";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(CATEGORIA, getLocalClassName() + ".onCreate();");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i(CATEGORIA, getLocalClassName() + ".onStart();");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(CATEGORIA, getLocalClassName() + ".onResume();");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.i(CATEGORIA, getLocalClassName() + ".onRestart();");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(CATEGORIA, getLocalClassName() + ".onPause();");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i(CATEGORIA, getLocalClassName() + ".onStop();");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(CATEGORIA, getLocalClassName() + ".onDestroy();");
    }

    public void acessarAtividade2(View view){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
