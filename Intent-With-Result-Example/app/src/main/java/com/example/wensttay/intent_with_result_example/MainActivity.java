package com.example.wensttay.intent_with_result_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static int ACTIVITY_1_CODE = 1;
    private static int ACTIVITY_2_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendToActivity1(View view){
        EditText nameInput = (EditText) findViewById(R.id.nameInput);
        EditText passwordInput = (EditText) findViewById(R.id.passwordInput);
        Intent intent = new Intent(this, Activity1.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", nameInput.getText().toString());
        bundle.putString("password", passwordInput.getText().toString());
        intent.putExtras(bundle);
        startActivityForResult(intent, ACTIVITY_1_CODE);
    }

    public void sendToActivity2(View view){
        EditText nameInput = (EditText) findViewById(R.id.nameInput);
        EditText passwordInput = (EditText) findViewById(R.id.passwordInput);
        Intent intent = new Intent(this, Activity2.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", nameInput.getText().toString());
        bundle.putString("password", passwordInput.getText().toString());
        intent.putExtras(bundle);
        startActivityForResult(intent, ACTIVITY_2_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast.makeText(this,
                "Mensagem por: Activity " + requestCode
                        + "\nResposta: Codigo " + resultCode
                        + "\nMensagem: " + data.getExtras().getString("msg") , Toast.LENGTH_LONG).show();
    }

}
