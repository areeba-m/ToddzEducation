package com.example.toddzeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class SignUp extends AppCompatActivity {

    EditText memail, mpassword, mconfirmpassword;
    Button msignupBtn;
    TextView mloginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        memail = findViewById(R.id.email);
        mpassword = findViewById(R.id.password);
        mconfirmpassword = findViewById(R.id.confirmpassword);
        mloginBtn = findViewById(R.id.existingaccount);
        msignupBtn = findViewById(R.id.button);

        mloginBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, LogIn.class));
            }
        }));

        msignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();
                String confirm = mconfirmpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    memail.setError("Field can not be empty!");
                    return;
                } else if (TextUtils.isEmpty(password)) {
                    mpassword.setError("Field can not be empty!");
                    return;
                } else if (password.length() < 8) {
                    mpassword.setError("Password must be atleast 8 characters!");
                    return;
                } else if (!password.equals(confirm)) {
                    mconfirmpassword.setError("Passwords do not match!");
                } else {
                    startActivity(new Intent(SignUp.this, Welcome.class));
                }
            }
        });
    }
}