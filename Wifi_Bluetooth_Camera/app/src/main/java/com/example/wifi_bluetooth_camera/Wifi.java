package com.example.wifi_bluetooth_camera;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Wifi extends AppCompatActivity {
    WifiManager wifiManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        final ToggleButton btn = findViewById(R.id.toggleButton);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        btn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                wifiAc();
            } else {
                wifiKapat();
            }
        });
    }

    private void wifiKapat() {
        if (wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);
            Toast.makeText(Wifi.this, "WiFi Kapalı", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Wifi.this, "WiFi Zaten Kapalı", Toast.LENGTH_SHORT).show();
        }
    }

    private void wifiAc() {
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
            Toast.makeText(Wifi.this, "WiFi Açık", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Wifi.this, "WiFi Zaten Açık", Toast.LENGTH_SHORT).show();
        }
    }
}
