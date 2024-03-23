package com.example.mobil_hafta6_uygulama1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonGyroscope = findViewById(R.id.buttonGyroscope);
        Button buttonMagnetic = findViewById(R.id.buttonMagnetic);
        Button buttonOrientation = findViewById(R.id.buttonOrientation);
        Button buttonAccelerometer = findViewById(R.id.buttonAccelerometer);
        Button buttonLight = findViewById(R.id.buttonLight);
        Button buttonPressure = findViewById(R.id.buttonPressure);
        Button buttonTemperature = findViewById(R.id.buttonTemperature);
        Button buttonProximity = findViewById(R.id.buttonProximity);
        Button buttonHumidity = findViewById(R.id.buttonHumidity);

        buttonGyroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Gyroscope.class));
            }
        });

        buttonMagnetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Magnetic.class));
            }
        });

        buttonOrientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Orientation.class));
            }
        });

        buttonAccelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Accelerometer.class));
            }
        });

        buttonLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Light.class));
            }
        });

        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Pressure.class));
            }
        });

        buttonTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Temperature.class));
            }
        });

        buttonProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Proximity.class));
            }
        });

        buttonHumidity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Humidity.class));
            }
        });
    }
}
