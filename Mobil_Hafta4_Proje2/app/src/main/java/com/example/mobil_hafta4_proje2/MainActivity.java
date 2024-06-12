package com.example.mobil_hafta4_proje2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AlertDialog.Builder pencere= new AlertDialog.Builder(MainActivity.this);
        pencere.setTitle("mesaj başlığı");
        pencere.setIcon(R.drawable.a0643138127_65);
        CharSequence[] items = {"Beşiktaş","Galatasaray","Fenerbahçe", "Trabzonspor"};
        pencere.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),items[which],Toast.LENGTH_LONG).show();
            }
        });

        Button buton1 = (Button) findViewById(R.id.button);
        buton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                pencere.show();
            }
        });

    }

}
