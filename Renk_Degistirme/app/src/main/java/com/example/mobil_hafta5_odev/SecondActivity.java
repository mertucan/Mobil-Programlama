package com.example.mobil_hafta5_odev;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private int randomNumber;
    private LinearLayout mainLayout;
    private Handler handler;
    private int sayac = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        randomNumber = getIntent().getIntExtra("randomNumber", 0);

        mainLayout = findViewById(R.id.mainLayout);
        handler = new Handler(Looper.getMainLooper());

        changeBackgroundColor();
    }

    private void changeBackgroundColor() {
        int color = getRandomColor();

        mainLayout.setBackgroundColor(color);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sayac < randomNumber) {
                    changeBackgroundColor();
                    sayac++;
                } else {
                    // Eğer sayac, randomNumber'a eşitse Toast mesajını göster
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(SecondActivity.this, "Bitti!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }, 2000);
    }


    private int getRandomColor() {
        Random random = new Random();
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
