package com.example.lesson2android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ThreeActivity extends AppCompatActivity {

    TextView tvValue;
    ImageView imImageGallery;
    Uri images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        initialization();
        setupListener();

    }

    private void setupListener() {
        Intent intent = getIntent();
        if (intent != null) {
            String text = intent.getStringExtra("key");
            tvValue.setText(text);

            images = intent.getData();
            imImageGallery.setImageURI(Uri.parse(images.toString()));
        }
    }

    private void initialization() {
        tvValue = findViewById(R.id.tv_value);
        imImageGallery = findViewById(R.id.im_images_gallery);

    }
}