package com.example.wensttay.actionbar_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.app.ActionBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        boolean result = super.onCreateOptionsMenu(menu);

        int itemMenuId = 1;
        int menuPosition = 1;

        MenuItem menuItem1 = menu.add(0, itemMenuId++, menuPosition++, "Item 1");
        menuItem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        MenuItem menuItem2 = menu.add(0, itemMenuId++, menuPosition++, "Item 2");
        menuItem2.setIcon(R.mipmap.ic_launcher);
        menuItem2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        MenuItem menuItem3 = menu.add(0, itemMenuId++, menuPosition++, "Item 3");
        menuItem3.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

        MenuItem menuItem4 = menu.add(0, itemMenuId++, menuPosition++, "Item 4");
        menuItem4.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

        MenuItem menuItem5 = menu.add(0, itemMenuId++, menuPosition++, "Item 5");
        menuItem5.setShowAsAction(MenuItem.SHOW_AS_ACTION_WITH_TEXT);

        return result;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        boolean result = super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case android.R.id.home:
                Toast.makeText(this, "Botão Home", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "Item 4", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(this, "Item 5", Toast.LENGTH_SHORT).show();
                break;
        }
        return result;
    }
}
