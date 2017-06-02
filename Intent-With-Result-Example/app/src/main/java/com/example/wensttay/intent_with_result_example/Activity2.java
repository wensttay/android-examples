package com.example.wensttay.intent_with_result_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Intent intent = getIntent();
        if(intent != null){
            Bundle extras = intent.getExtras();
            if(extras != null){
                String name = extras.getString("name");
                String password = extras.getString("password");
                TextView nameView = (TextView) findViewById(R.id.nameView);
                TextView passwordView = (TextView) findViewById(R.id.passwordView);
                nameView.setText("Nome: " + name);
                passwordView.setText("Senha: " + password);
            }
        }
    }

    public void accept(View view){
        Intent intent = new Intent();
        intent.putExtra("msg", "Requisição Aceita");
        setResult(1, intent);
        finish();
    }

    public void refuse(View view){
        Intent intent = new Intent();
        intent.putExtra("msg", "Requisição Negada");
        setResult(2, intent);
        finish();
    }
}
