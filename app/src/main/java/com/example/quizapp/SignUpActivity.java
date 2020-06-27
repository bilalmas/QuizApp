package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    //private Button startBtn;
    private TextView signintextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //startBtn = findViewById(R.id.start_btn);
        signintextview = findViewById(R.id.textViewSignin);

    }

    public void Signin(View view){
        Intent signin = new Intent(this, SignInActivity.class);
        startActivity(signin);
    }
}
