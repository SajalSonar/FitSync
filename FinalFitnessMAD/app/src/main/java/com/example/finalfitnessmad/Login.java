package com.example.finalfitnessmad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

public class Login extends AppCompatActivity {

    private static final String TAG = "LoginActivity"; // Tag for logging

    private FirebaseAuth mAuth;
    EditText getEmail, getPassword;
    Button login;
    TextView registerBtn;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getEmail = findViewById(R.id.email);
        getPassword = findViewById(R.id.password);
        login = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.loginNow);
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = getEmail.getText().toString();
                String password = getPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Login.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {  // Corrected to check password
                    Toast.makeText(Login.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this, "Authentication Success.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    String errorMessage = task.getException() != null ? task.getException().getMessage() : "Unknown error";
                                    Toast.makeText(Login.this, "Authentication failed: " + errorMessage, Toast.LENGTH_SHORT).show();
                                    Log.e(TAG, "Firebase Auth Error: " + errorMessage); // Log the error
                                }
                            }
                        });
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), register.class);
                startActivity(intent);
                finish();
            }
        });
    }
}