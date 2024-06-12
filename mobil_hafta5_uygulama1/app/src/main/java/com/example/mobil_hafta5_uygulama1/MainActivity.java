package com.example.mobil_hafta5_uygulama1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressDialog progres= new ProgressDialog(MainActivity.this);
        progres.setCancelable(false);
        progres.setTitle("Mesajınızı girin");
        progres.setMessage("Biraz bekleyin!");

        Button buton1 = (Button)findViewById(R.id.button);

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progres.show();

                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(),
                        "İşlem gerçekleşti",Toast.LENGTH_LONG).show();

            }
        });
    }
}