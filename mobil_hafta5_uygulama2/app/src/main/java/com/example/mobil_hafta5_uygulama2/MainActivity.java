package com.example.mobil_hafta5_uygulama2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.widget.Button;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public int oran1=0, oran2=0, oran3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text1 = (TextView) findViewById(R.id.textView1);
        TextView text2 = (TextView) findViewById(R.id.textView2);
        TextView text3 = (TextView) findViewById(R.id.textView3);

        SeekBar sb1 = (SeekBar) findViewById(R.id.seekBar1);
        SeekBar sb2 = (SeekBar) findViewById(R.id.seekBar2);
        SeekBar sb3 = (SeekBar) findViewById(R.id.seekBar3);

        ConstraintLayout arkaplan = (ConstraintLayout) findViewById(R.id.layout1);

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb1.setMax(255);
                int oran = android.graphics.Color.rgb(oran3,oran2,progress);
                arkaplan.setBackgroundColor(oran);
                text1.setText(String.valueOf(progress));
                oran1 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb2.setMax(255);
                int oran = android.graphics.Color.rgb(oran3,progress,oran1);
                arkaplan.setBackgroundColor(oran);
                text2.setText(String.valueOf(progress));
                oran2 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb3.setMax(255);
                int oran = android.graphics.Color.rgb(progress,oran2,oran1);
                arkaplan.setBackgroundColor(oran);
                text3.setText(String.valueOf(progress));
                oran3 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}