package com.example.wifi_bluetooth_camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnBluetooth, btnCamera, btnWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Butonları tanımla
        btnBluetooth = findViewById(R.id.btnBluetooth);
        btnCamera = findViewById(R.id.btnCamera);
        btnWifi = findViewById(R.id.btnWiFi);

        // Bluetooth butonuna tıklanma olayı ekle
        btnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Bluetooth aktivitesine yönlendir
                Intent intent = new Intent(MainActivity.this, Bluetooth.class);
                startActivity(intent);
            }
        });

        // Kamera butonuna tıklanma olayı ekle
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kamera aktivitesine yönlendir
                Intent intent = new Intent(MainActivity.this, Camera.class);
                startActivity(intent);
            }
        });

        // WiFi butonuna tıklanma olayı ekle
        btnWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // WiFi aktivitesine yönlendir
                Intent intent = new Intent(MainActivity.this, Wifi.class);
                startActivity(intent);
            }
        });
    }
}
