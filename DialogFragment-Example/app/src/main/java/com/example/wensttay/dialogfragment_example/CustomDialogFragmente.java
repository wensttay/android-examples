package com.example.wensttay.dialogfragment_example;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class CustomDialogFragmente extends DialogFragment {

    private int numStyle;
    private int numTheme;

    public CustomDialogFragmente(int numStyle, int numTheme){
        this.numStyle = numStyle;
        this.numTheme = numTheme;
    }

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);

        int style;
        int theme;

        switch (numStyle){
            case 1: style = DialogFragment.STYLE_NO_TITLE; break;
            case 2: style = DialogFragment.STYLE_NO_INPUT; break;
            case 3: style = DialogFragment.STYLE_NO_FRAME; break;
            default: style = DialogFragment.STYLE_NORMAL; break;
        }

        switch (numTheme){
            case 1: theme = android.R.style.Theme_Holo_Panel; break;
            case 2: theme = android.R.style.Theme_Holo_Dialog; break;
            default: theme = android.R.style.Theme_Holo_Light_DarkActionBar; break;
        }

        setStyle(style, theme);
        setCancelable(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle bundle){
        super.onCreateView(inflater,group, bundle);

        View view = inflater.inflate(R.layout.loading_fragmente, group);

        Button btExit = (Button) view.findViewById(R.id.btExit);
//        btExit.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
////                dismiss();
//                ((MainActivity) getActivity()).turnOffDialogFragment();
//              }
//        });


        return view;
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

//    @Override
//    public Dialog onCreateDialog(Bundle bundle){
//        super.onCreateDialog(bundle);
//
//        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity())
//                .setTitle("Tittle of DialogFragment")
//                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getActivity(), "Opa Funcionou!", Toast.LENGTH_LONG).show();
//                    }
//                })
//                .setNegativeButton("Sair", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dismiss();
//                    }
//                });
//
//        return alert.show() ;
//    }
}
