package com.example.toddzeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.os.Bundle;

public class Welcome extends AppCompatActivity {
    Button nextBtn;
    RadioGroup radio;
    RadioButton radiobutton;
    boolean check, check2;
    int val;
    String type = "";
    RadioButton b1;
    RadioButton b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        radio = findViewById(R.id.radioGroup);
        nextBtn = findViewById(R.id.button2);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1 = findViewById(R.id.radioButton);
                b2 = findViewById(R.id.radioButton2);
                int ID = radio.getCheckedRadioButtonId();
                radiobutton = findViewById(ID);
                check = radiobutton.isChecked();
                if(b1 == radiobutton)
                    startActivity(new Intent(Welcome.this, HomescreenActivity.class));
                else if(b2 == radiobutton)
                    startActivity(new Intent(Welcome.this, UploadActivity.class));
                else
                    radiobutton.setError("Field cannot be unchecked");

            }
        });


    }
}