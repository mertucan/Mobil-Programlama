package com.example.hafta3_sonuygulama;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ListView listView2;

    private ArrayList<City> cityList;
    private ArrayList<Integer> randomNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listView2 = findViewById(R.id.listView2);

        cityList = new ArrayList<>();
        randomNumbers = new ArrayList<>();

        final String[] sehirler = {"İstanbul 34", "Ankara 6", "İzmir 35", "Bursa", "Erzincan", "Edirne", "Tekirdağ", "Sivas", "Ordu", "Trabzon"};

        for (String sehir : sehirler) {
            cityList.add(new City(sehir));
        }

        ArrayAdapter<String> verilistesi = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sehirler);
        listView.setAdapter(verilistesi);

        Button generateButton = findViewById(R.id.button);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumbers();
                updateListView2();
                checkMatchingCities();
            }
        });
    }

    private void generateRandomNumbers() {
        randomNumbers.clear();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int randomNumber = rand.nextInt(81) + 1;
            randomNumbers.add(randomNumber);
        }
    }

    private void updateListView2() {
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, randomNumbers);
        listView2.setAdapter(adapter);
    }

    private void checkMatchingCities() {
        for (City city : cityList) {
            for (Integer number : randomNumbers) {
                if (city.getNumber() == number) {
                    showToast("Var: " + city.getName());
                    return;
                }
            }
        }

        showToast("Yok");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Model sınıfı
    public class City {
        private String name;
        private int number;

        public City(String info) {
            String[] parts = info.split(" ");
            this.name = parts[0];
            if (parts.length > 1) {
                try {
                    this.number = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    this.number = 0;
                }
            }
        }

        public String getName() {
            return name;
        }

        public int getNumber() {
            return number;
        }
    }
}
