package com.example.toddzeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomescreenActivity extends AppCompatActivity {

    ImageButton profile;
    Button leaderboardbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

         profile = findViewById(R.id.profileButton);
         profile.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                startActivity(new Intent(HomescreenActivity.this,ProfilePageActivity.class));
            }
        });
        leaderboardbtn = findViewById(R.id.leaderboard_button);
        leaderboardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomescreenActivity.this, LeaderBoardPageActivity.class));
            }
        });
    }
    public void openQuizQ(View view){
        startActivity(new Intent(this,QuizMap.class));
    }


}