package com.example.sehir_listesi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView resultTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resultTextView = findViewById(R.id.resultTextView);
        backButton = findViewById(R.id.button);

        Intent intent = getIntent();
        if (intent != null) {
            String resultText = intent.getStringExtra("RESULT_TEXT");
            if (resultText != null) {
                resultTextView.setText(resultText);
            } else {
                resultTextView.setText("Veri alınamadı");
            }
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "Geri Dön" butonuna tıklanınca yapılacak işlemi buraya ekleyin
                finish(); // Bu, SecondActivity'yi kapatır ve MainActivity'e geri döner
            }
        });
    }
}
