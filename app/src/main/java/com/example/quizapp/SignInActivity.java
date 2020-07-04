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
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {

    EditText full_name, email_address, password, confirm_password;
    Button SignIn;
    TextView ForgotPassword;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mFirebaseAuth = FirebaseAuth.getInstance();
        email_address = findViewById(R.id.editTextEmailAddress);
        password = findViewById(R.id.editTextPassword);
        SignIn = findViewById(R.id.buttonCreateAccount);
        ForgotPassword = findViewById(R.id.textForgotPassword);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if( mFirebaseUser != null ){
                    Toast.makeText(SignInActivity.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignInActivity.this, CategoriesActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(SignInActivity.this,"Please Login",Toast.LENGTH_SHORT).show();
                }
            }
        };

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_address.getText().toString();
                String pwd = password.getText().toString();

                if(email.isEmpty()){
                    email_address.setError("Please enter your Email Address");
                    email_address.requestFocus();
                }
                else if(pwd.isEmpty()){
                    password.setError("Please enter your Password");
                    password.requestFocus();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(SignInActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                            else {
                                startActivity(new Intent(SignInActivity.this,CategoriesActivity.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(SignInActivity.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                }
            }
        });

        ForgotPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String email = email_address.getText().toString();

                if(email.isEmpty()){
                    email_address.setError("Please enter your Email Address to reset your password");
                    email_address.requestFocus();
                }

                else  if(!email.isEmpty()){
                    mFirebaseAuth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignInActivity.this, "An email has been sent to " + email, Toast.LENGTH_SHORT).show();
                                        finish();
                                    } else {
                                        Toast.makeText(SignInActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });
    }


    public void Signup(View view) {
        Intent signup = new Intent(this, SignUpActivity.class);
        startActivity(signup);
    }

}