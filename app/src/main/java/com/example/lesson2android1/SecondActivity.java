package com.example.lesson2android1;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    Button btnOpenActivity, btnWeb, btnNumber;
    EditText inputText;
    final int MIN_TEXT_LENGTH = 4;
    final String EMPTY_STRING = "";
    ImageView imageView;
    Uri image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialization();
        setupListner();
    }

    private void initialization() {
        btnOpenActivity = findViewById(R.id.btn_open_activity_main);
        btnWeb = findViewById(R.id.btn_web);
        btnNumber = findViewById(R.id.btn_number);
        inputText = findViewById(R.id.btn_input_text);
        imageView = findViewById(R.id.im_gallery);
    }

    private void setupListner() {
        btnOpenActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webIntent = Uri.parse("https://www.youtube.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webIntent);
                startActivity(intent);
            }
        });
        btnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String saveText = inputText.getText().toString().trim();
                Intent intent = new Intent(SecondActivity.this, ThreeActivity.class);
                if (inputText.getText().toString().isEmpty()) {
                    inputText.setError("Введите Текст!");
                } else {
                    intent.putExtra("key", saveText);
                    intent.setData(image);
                    startActivity(intent);
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fromGallery.launch("image/*");
            }
        });
    }

    ActivityResultLauncher<String> fromGallery = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    image = result;
                    imageView.setImageURI(image);
                }
            });
}