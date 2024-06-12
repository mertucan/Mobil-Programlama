package com.example.wifi_bluetooth_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;
import android.widget.MediaController;
import androidx.appcompat.app.AppCompatActivity;

public class Camera extends AppCompatActivity {

    private static final int IMAGE_ACTION_CODE = 1;
    private static final int VIDEO_ACTION_CODE = 2;

    private Button b5;
    private Button b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);

        b5.setOnClickListener(v -> {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePictureIntent, IMAGE_ACTION_CODE);
        });

        b6.setOnClickListener(v -> {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivityForResult(takePictureIntent, VIDEO_ACTION_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;
        switch (requestCode) {
            case VIDEO_ACTION_CODE:
                VideoView videoView = findViewById(R.id.videoView);
                videoView.setVideoURI(data.getData());
                videoView.setMediaController(new MediaController(this));
                videoView.requestFocus();
                videoView.start();
                break;
            case IMAGE_ACTION_CODE:
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageBitmap(imageBitmap);
                break;
            default:
                break;
        }
    }
}