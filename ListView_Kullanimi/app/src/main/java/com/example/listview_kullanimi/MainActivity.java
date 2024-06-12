package com.example.listview_kullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.myListView);
        final String[] sehirler = {"İstanbul", "Ankara", "İzmir"};
        final ArrayAdapter<String> verilistesi = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, sehirler);

        listView.setAdapter(verilistesi);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, verilistesi.getItem(position),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}