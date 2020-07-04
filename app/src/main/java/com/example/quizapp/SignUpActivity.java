package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    EditText full_name, email_address, password, confirm_password;
    Button SignUp;
    FirebaseAuth mFirebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseAuth = FirebaseAuth.getInstance();
        full_name = findViewById(R.id.editTextName);
        email_address = findViewById(R.id.editTextEmailAddress);
        password = findViewById(R.id.editTextPassword);
        confirm_password = findViewById(R.id.editTextConfirmPassword);
        SignUp = findViewById(R.id.buttonCreateAccount);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = full_name.getText().toString();
                String email = email_address.getText().toString();
                String pwd = password.getText().toString();
                String confirm_pwd = confirm_password.getText().toString();

                if(name.isEmpty()){
                    full_name.setError("Please enter your Name");
                    full_name.requestFocus();
                }
                else if(email.isEmpty()){
                    email_address.setError("Please enter Email Address");
                    email_address.requestFocus();
                }
                else if(pwd.isEmpty()){
                    password.setError("Please enter your Password");
                    password.requestFocus();
                }
                else  if(!confirm_pwd.equals(pwd)){
                    confirm_password.setError("Passwords do not match");
                    confirm_password.requestFocus();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(SignUpActivity.this,"SignUp Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(SignUpActivity.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void Signin(View view){
        Intent signin = new Intent(this, SignInActivity.class);
        startActivity(signin);
    }
}
