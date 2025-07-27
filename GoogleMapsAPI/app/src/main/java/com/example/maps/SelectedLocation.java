package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SelectedLocation extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_location);

        // Harita fragmentini bul
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.google_map);

        // Harita fragmenti hazır olduğunda onMapReady metodunu çağır
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Galata Kulesi'nin koordinatları
        LatLng galataKulesi = new LatLng(41.025413, 28.974289);

        // Harita üzerinde Galata Kulesi'ni işaretle
        googleMap.addMarker(new MarkerOptions().position(galataKulesi).title("Galata Kulesi"));

        // Kamerayı Galata Kulesi'nin konumuna odakla
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(galataKulesi, 15));
    }
}
