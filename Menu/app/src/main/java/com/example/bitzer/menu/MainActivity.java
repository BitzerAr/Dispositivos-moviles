package com.example.bitzer.menu;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Alternativa 1
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment;
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_date:
                startActivity(new Intent(android.provider.Settings.ACTION_DATE_SETTINGS));
                break;
            case R.id.menu_location:
                startActivity(new Intent(android.provider.Settings.ACTION_LOCALE_SETTINGS));
                break;
            case R.id.menu_sleep:
                startActivity(new Intent(android.provider.Settings.ACTION_SOUND_SETTINGS));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

