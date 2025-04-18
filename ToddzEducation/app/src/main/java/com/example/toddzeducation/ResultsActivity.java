package com.example.toddzeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ResultsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button solution;
    ImageButton home;
    ImageButton retake;
    ImageButton profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mediaPlayer = MediaPlayer.create(this, R.raw.yaaay);
        mediaPlayer.start();

        home = findViewById(R.id.btnHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultsActivity.this,HomescreenActivity.class));
            }
        });
        retake = findViewById(R.id.btnRetake);
        retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultsActivity.this,MainActivity.class));
            }
        });
        profile = findViewById(R.id.imagebtnProfile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultsActivity.this,ProfilePageActivity.class));
            }
        });
        solution = findViewById(R.id.btnSolution);
        solution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultsActivity.this,SolutionActivity.class));
            }
        });
    }
}