package com.example.passdatafromfragmenttohostingactivityusinginterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PassingDataFromFragment.passingDataInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PassingDataFromFragment fragment = new PassingDataFromFragment();
        fragment.setOnDataListener(MainActivity.this);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();

    }

    @Override
    public void onDataReceived(String data) {
        Toast.makeText(this, "" + data, Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.textView);
        textView.setText(data);
    }
}