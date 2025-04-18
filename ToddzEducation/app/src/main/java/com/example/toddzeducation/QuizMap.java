package com.example.toddzeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class QuizMap extends AppCompatActivity implements View.OnClickListener {

    ImageButton home;
    com.google.android.material.imageview.ShapeableImageView b;
    com.google.android.material.imageview.ShapeableImageView mb1;
    com.google.android.material.imageview.ShapeableImageView mb2;
    com.google.android.material.imageview.ShapeableImageView mb3;
    com.google.android.material.imageview.ShapeableImageView mb4;
    com.google.android.material.imageview.ShapeableImageView mb5;
    com.google.android.material.imageview.ShapeableImageView mb6;
    com.google.android.material.imageview.ShapeableImageView mb7;
    com.google.android.material.imageview.ShapeableImageView mb8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_map);

        b = findViewById(R.id.back);
        mb1 =findViewById(R.id.imageButton);
        mb2 = findViewById(R.id.imageButton2);
        mb3= findViewById(R.id.imageButton3);
        mb4 = findViewById(R.id.imageButton4);
        mb5 = findViewById(R.id.imageButton5);
        mb6 = findViewById(R.id.imageButton6);
        mb7 = findViewById(R.id.imageButton7);
        mb8 = findViewById(R.id.imageButton8);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mb1.setOnClickListener(this);
        mb2.setOnClickListener(this);
        mb3.setOnClickListener(this);
        mb4.setOnClickListener(this);
        mb5.setOnClickListener(this);
        mb6.setOnClickListener(this);
        mb7.setOnClickListener(this);
        mb8.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            default: {
                startActivity(new Intent(QuizMap.this, MainActivity.class));
                break;
            }
        }

    }

}