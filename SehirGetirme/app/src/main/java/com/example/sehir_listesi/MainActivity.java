package com.example.sehir_listesi;// MainActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView leftListView;
    private ListView rightListView;

    private ArrayList<String> leftData;
    private String[] rightData = {"Ankara", "İstanbul", "İzmir", "Adana", "Bursa", "Antalya", "Eskişehir", "Gaziantep", "Konya", "Trabzon"};
    private String[] plateCodes = {"06", "34", "35", "01", "16", "07", "26", "27", "42", "61"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftListView = findViewById(R.id.leftListView);
        rightListView = findViewById(R.id.rightListView);

        generateRandomNumbers();

        ArrayAdapter<String> leftAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, leftData);
        ArrayAdapter<String> rightAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rightData);

        leftListView.setAdapter(leftAdapter);
        rightListView.setAdapter(rightAdapter);

        rightListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                checkCity(rightData[position]);
            }
        });
    }

    private void generateRandomNumbers() {
        leftData = new ArrayList<>();
        Random random = new Random();

        while (leftData.size() < 10) {
            int randomNumber = random.nextInt(81) + 1;
            if (!leftData.contains(String.valueOf(randomNumber))) {
                leftData.add(String.valueOf(randomNumber));
            }
        }

        // Sıralama işlemi (isteğe bağlı)
        Collections.sort(leftData);
    }

    private void checkCity(String selectedCity) {
        for (int i = 0; i < rightData.length; i++) {
            if (rightData[i].equals(selectedCity)) {
                String plateCode = plateCodes[i];
                checkPlateCode(plateCode);
                return;
            }
        }
        showResult(selectedCity + " için plaka kodu bulunamadı.");
    }

    private void checkPlateCode(String selectedPlateCode) {
        for (String plateCode : leftData) {
            if (plateCode.equals(selectedPlateCode)) {
                showResult("İl var");
                return;
            }
        }
        showResult("İl yok");
    }

    private void showResult(String resultText) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("RESULT_TEXT", resultText);
        startActivity(intent);
    }
}
