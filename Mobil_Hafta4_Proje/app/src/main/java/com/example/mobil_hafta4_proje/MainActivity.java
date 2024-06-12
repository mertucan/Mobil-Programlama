package com.example.mobil_hafta4_proje;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String[] cityImageNames = {"ist1", "ist2", "ist3", "ank1", "ank2", "ank3", "izm1", "izm2", "izm3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlertDialog.Builder pencere = new AlertDialog.Builder(MainActivity.this);
        pencere.setTitle("Mesaj Başlığı");
        final CharSequence[] items = {"İstanbul", "Ankara", "İzmir"};
        pencere.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Seçilen öğeye tıklandığında yapılacak işlemler
                Toast.makeText(getApplicationContext(), items[which], Toast.LENGTH_LONG).show();

                // Rastgele bir resim seç ve ImageView'a ata
                ImageView imageView = findViewById(R.id.myImageView);
                int randomIndex = new Random().nextInt(cityImageNames.length);
                int resID = getResources().getIdentifier(cityImageNames[randomIndex], "drawable", getPackageName());
                imageView.setImageResource(resID);

                // Seçilen öğeye göre farklı aktivitelere geçiş yapmak için Intent kullanılır
                if (items[which].equals("İstanbul")) {
                    Intent istanbulIntent = new Intent(MainActivity.this, ActivityIstanbul.class);
                    startActivity(istanbulIntent);
                } else if (items[which].equals("Ankara")) {
                    Intent ankaraIntent = new Intent(MainActivity.this, ActivityAnkara.class);
                    startActivity(ankaraIntent);
                } else if (items[which].equals("İzmir")) {
                    Intent izmirIntent = new Intent(MainActivity.this, ActivityIzmir.class);
                    startActivity(izmirIntent);
                }
            }
        });

        Button buton1 = findViewById(R.id.button);
        buton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pencere.show();
            }
        });
    }
}

