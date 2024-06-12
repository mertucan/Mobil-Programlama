package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    TextView txt1;
    EditText edt1;
    EditText edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);
        txt1 = findViewById((R.id.textView));
        edt1 = findViewById(R.id.editTextText);
        edt2 = findViewById(R.id.editTextText2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int sayi = Integer.parseInt(edt1.getText().toString());
                int ust = Integer.parseInt(String.valueOf(edt2.getText()));
                int sonuc = 1;

                for(int i=0; i<ust; i++)
                {
                    sonuc*=sayi;
                }

                txt1.setText(Integer.toString(sonuc));
            }
        });
    }
}