package com.example.wensttay.actualizemainthread_example;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by wensttay on 27/04/17.
 */

public class Tarefa extends AsyncTask<String, String, Bitmap> {

    private Context context;
    private TarefaInterface tarefaInterface;
    private ProgressDialog progressDialog;

    public Tarefa(Context context, TarefaInterface tarefaInterface) {
        this.context = context;
        this.tarefaInterface = tarefaInterface;
    }

    @Override
    protected void onPreExecute(){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Carregando imagem ...");
        progressDialog.show();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap imagem = null;
        publishProgress("Ainda carregando ...");
        try {
            URL url = new URL(params[0]);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.connect();
            InputStream inputStream = httpsURLConnection.getInputStream();
            imagem = BitmapFactory.decodeStream(inputStream);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        publishProgress("Imagem Carregada!");
        return imagem;
    }

    @Override
    protected void onProgressUpdate(String... params){
        progressDialog.setMessage(params[0]);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(Bitmap params){
        tarefaInterface.atualizarImagem(params);
        progressDialog.dismiss();
    }
}
