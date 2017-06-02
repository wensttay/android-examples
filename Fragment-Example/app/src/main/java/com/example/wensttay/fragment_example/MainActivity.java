package com.example.wensttay.fragment_example;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity{

    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment1 fragment1 = new Fragment1();
    Fragment2 fragment2 = new Fragment2();
    Fragment3 fragment3 = new Fragment3();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.layout_direito, fragment1, "frag1");
            fragmentTransaction.commit();
        }

        ListView list = (ListView) findViewById(R.id.lisViewActions);
        String[] listNames = new String[] {"Fragment 1", "Alterar Texto Fragment 1", "Fragment 2", "Fragment 3"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listNames);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.layout_direito, fragment1, "frag1");
                    fragmentTransaction.addToBackStack("pilha");
                    fragmentTransaction.commit();
                }else if(position == 1){
                    Fragment1 frag1 = (Fragment1) fragmentManager.findFragmentByTag("frag1");
                    if(frag1 != null && frag1.isAdded()) {
                        frag1.alterText("TEXTO ALTERADO COM SUCESSO !");
                    }
                }else if(position == 2){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.layout_direito, fragment2, "frag2");
                    fragmentTransaction.addToBackStack("pilha");
                    fragmentTransaction.commit();
                }else if(position == 3){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.layout_direito, fragment3, "frag3");
                    fragmentTransaction.addToBackStack("pilha");
                    fragmentTransaction.commit();
                }
            }
        });
        printLogI("onCreate(Bundle)");
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
    public void onDestroy(){
        super.onDestroy();
        printLogI("onDestroy()");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        printLogI("onRestart()");
    }

    public void printLogI(String s){
        Log.i("FRAGMENT", s);
    }
}
