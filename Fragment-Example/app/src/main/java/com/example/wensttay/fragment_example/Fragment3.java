package com.example.wensttay.fragment_example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);
        TextView textView = (TextView) view.findViewById(R.id.campoDeTexto);
        textView.setText("Fragmento 3");
        return view;
    }

    public void alterText(String text){
        TextView textView = (TextView) getView().findViewById(R.id.campoDeTexto);
        textView.setText(text);
    }



}
