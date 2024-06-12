package com.example.mobil_hafta4;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mesaj Başlığı");
        builder.setMessage("Türk müsün?");
        builder.setCancelable(false);

        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast1();
            }
        });

        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast2();
            }
        });

        final AlertDialog alertDialog = builder.create();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });
    }

    private void showToast1() {
        Toast.makeText(MainActivity.this, "Türksün", Toast.LENGTH_SHORT).show();
    }

    private void showToast2() {
        Toast.makeText(MainActivity.this, "Türk değilsin", Toast.LENGTH_SHORT).show();
    }
}
