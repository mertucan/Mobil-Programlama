package com.example.hafta3_sonuygulama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // İlk aktiviteden gelen veriyi alma
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // İlk aktiviteden gelen veriyi al
            String cityName = extras.getString("cityName");
            int cityNumber = extras.getInt("cityNumber");

            // İlk aktiviteden gelen veriyi değerlendirme
            checkMatchingCity(cityName, cityNumber);
        }

        // Geri butonu ekle
        Button backButton = findViewById(R.id.button2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MainActivity'e geri dön
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkMatchingCity(String cityName, int cityNumber) {
        // Burada gelen veriyi kullanarak istediğiniz işlemleri yapabilirsiniz
        // Örneğin, bir Toast mesajı gösterebilirsiniz
        showToast("City Name: " + cityName + "\nCity Number: " + cityNumber);
    }

    private void showToast(String message) {
        // Toast mesajı gösterme fonksiyonu
    }
}
