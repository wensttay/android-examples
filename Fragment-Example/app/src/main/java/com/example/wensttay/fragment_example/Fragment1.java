package com.example.wensttay.fragment_example;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    @Override
    public void onAttach (Activity activity){
        super.onAttach(activity);
        printLogI("onAttach(Activity)");
    }

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        printLogI("onCreate(Bundle)");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        TextView textView = (TextView) view.findViewById(R.id.campoDeTexto);
        textView.setText("Fragmento 1");
        printLogI("onCreateView(LayoutInflater, ViewGroup, Bundle)");

        return view;
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        printLogI("onActivityCreated(Bundle)");
    }

    @Override
    public void onViewStateRestored(Bundle bundle){
        super.onViewStateRestored(bundle);
        printLogI("onViewStateRestored(Bundle)");
    }

    @Override
    public void onStart(){
        super.onStart();
        printLogI("onStart()");
    }

    @Override
    public void onResume(){
        super.onResume();
        printLogI("onResume()");
    }

    @Override
    public void onPause(){
        super.onPause();
        printLogI("onPause()");
    }

    @Override
    public void onStop(){
        super.onStop();
        printLogI("onStop()");
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        printLogI("onDestroyView()");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        printLogI("onDestroy()");
    }

    @Override
    public void onDetach(){
        super.onDetach();
        printLogI("onDetach()");
    }

    public void alterText(String text){
        TextView textView = (TextView) getView().findViewById(R.id.campoDeTexto);
        textView.setText(text);
    }

    public void printLogI(String s){
        Log.i("FRAGMENT", "-> " + s);
    }
}
