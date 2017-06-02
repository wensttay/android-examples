package com.example.wensttay.intentfilter_example;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irParaAct1OuAct2(View view){
        Intent intent = new Intent("MINHA_ACTIVITY");
        startActivity(intent);
    }

    public void irParaAct2(View view){
        Intent intent = new Intent("MINHA_ACTIVITY");
        intent.addCategory("MINHA_ACTIVITY_2");
        startActivity(intent);
    }

    public void irParaGoogle(View view){
        Uri uri = Uri.parse("https://www.google.com.br/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
