package com.example.toddzeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
public class ProfilePageActivity extends AppCompatActivity {

    Button logout;
    ImageButton home;
   // ImageButton leaderboardbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        home = findViewById(R.id.backButton);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                startActivity(new Intent(ProfilePageActivity.this, HomescreenActivity.class));
            }
        });
        logout = findViewById(R.id.logoutbtn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfilePageActivity.this,  SignUp.class));
            }
        });

    }

}