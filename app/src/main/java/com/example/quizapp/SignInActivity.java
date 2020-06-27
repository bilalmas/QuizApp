package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    private TextView signuptextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signuptextview = findViewById(R.id.textViewSignUp2);
    }


    public void Signup(View view) {
        Intent signup = new Intent(this, SignUpActivity.class);
        startActivity(signup);
    }
}