package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("CurrentLocation", "onCreate() called");

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CurrentLocation butonuna tıklandığında CurrentLocationActivity'i başlat
                startActivity(new Intent(MainActivity.this, CurrentLocation.class));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SelectedLocation butonuna tıklandığında SelectedLocationActivity'i başlat
                startActivity(new Intent(MainActivity.this, SelectedLocation.class));
            }
        });
    }
}
