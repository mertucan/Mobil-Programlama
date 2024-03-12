package com.example.mobil_hafta5_odev;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar1, seekBar2;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar1 = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        seekBar1.setMax(10);
        seekBar2.setMax(10);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Random sayı oluştur
                int min = Math.min(seekBar1.getProgress(), seekBar2.getProgress());
                int max = Math.max(seekBar1.getProgress(), seekBar2.getProgress());
                int randomValue = getRandomNumber(min, max);

                // TextView'e yazdır
                textView.setText(""+ randomValue);

                // ProgressDialog göster
                new GenerateNumberTask().execute(randomValue);
            }
        });
    }

    // Belirli bir aralıkta random sayı üretme
    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    // ProgressDialog'i göstermek için AsyncTask
    // ProgressDialog'i göstermek için AsyncTask
    private class GenerateNumberTask extends AsyncTask<Integer, Void, Void> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(MainActivity.this, "Please wait", "Generating Number...");

            // Thread kullanarak ProgressDialog'in süresini geciktir (3 saniye)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        if (progressDialog != null && progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        @Override
        protected Void doInBackground(Integer... params) {
            // İkinci aktiviteye geçiş ve veriyi iletim
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("randomNumber", params[0]);
            startActivity(intent);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

}
