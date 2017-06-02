package com.example.wensttay.actualizemainthread_example;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements TarefaInterface{
//    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void baixarEAtualizar(View view){
        Tarefa tarefa = new Tarefa(this, this);
        tarefa.execute("https://kingofwallpapers.com/png/png-001.jpg");

//        new Thread(){
//            public void run(){
//                try {
//                    URL url = new URL("https://kingofwallpapers.com/png/png-001.jpg");
//                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
//                    httpsURLConnection.setDoInput(true);
//                    httpsURLConnection.connect();
//                    InputStream inputStream = httpsURLConnection.getInputStream();
//                    final Bitmap imagem = BitmapFactory.decodeStream(inputStream);
//
//                    Log.i("Script", "Imagem Baixada");
//                    final ImageView imageView = (ImageView) findViewById(R.id.imageView);
//
////                    handler.post(new Runnable() {
////                        @Override
////                        public void run() {
////                            imageView.setImageBitmap(imagem);
////                        }
////                    });
//
//                    runOnUiThread(new Runnable() {
//                        public void run() {
//                            imageView.setImageBitmap(imagem);
//                        }
//                    });
//
//                } catch (java.io.IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
    }

    @Override
    public void atualizarImagem(Bitmap bitmap) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);
    }
}
