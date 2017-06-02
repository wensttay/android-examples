package com.example.wensttay.intent_example;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irParaSegundaActivity(View view){
        Intent intent = new Intent(this, SegundaActivity.class);
        Bundle bundle = new Bundle();
        EditText nomeInput = (EditText) findViewById(R.id.nomeInput);
        EditText senhaInput = (EditText) findViewById(R.id.senhaInput);
        bundle.putString("nome" , nomeInput.getText().toString());
        bundle.putString("senha" , senhaInput.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void irParaNavegador(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.google.com.br/"));
        startActivity(intent);
    }
}
