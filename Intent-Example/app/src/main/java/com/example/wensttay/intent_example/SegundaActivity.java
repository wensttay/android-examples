package com.example.wensttay.intent_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                String nome = bundle.getString("nome");
                String senha = bundle.getString("senha");
                TextView nomeOutPut = (TextView) findViewById(R.id.nomeOutPut);
                TextView senhaOutPut = (TextView) findViewById(R.id.senhaOutPut);
                nomeOutPut.setText(nome);
                senhaOutPut.setText(senha);
            }
        }
    }

    public void voltar(View view){
        finish();
    }
}
