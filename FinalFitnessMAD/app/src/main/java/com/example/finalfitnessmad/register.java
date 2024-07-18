package com.example.finalfitnessmad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalfitnessmad.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    Button register;
    EditText getEmail, getPassword, userName, age, sap;
    TextView back_to_login;
    FirebaseAuth mAuth;
    ActivityRegisterBinding binding;
    FirebaseDatabase fDatabase;
    DatabaseReference rDatabase;
    String userNameText, ageText, sapText;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        register = binding.register;
        getEmail = binding.email;
        getPassword = binding.password;
        userName = binding.username;
        age = binding.age;
        sap = binding.sap;
        back_to_login = binding.loginNow;
        progressBar = binding.progress;

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNameText = userName.getText().toString();
                ageText = age.getText().toString();
                sapText = sap.getText().toString();
                String email = getEmail.getText().toString();
                String password = getPassword.getText().toString();

                if (!userNameText.isEmpty() && !ageText.isEmpty() && !sapText.isEmpty()) {
                    progressBar.setVisibility(View.VISIBLE);

                    Users users = new Users(userNameText, ageText, sapText);
                    fDatabase = FirebaseDatabase.getInstance();
                    rDatabase = fDatabase.getReference("Users");

                    rDatabase.child(userNameText).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                mAuth.createUserWithEmailAndPassword(email, password)
                                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                progressBar.setVisibility(View.GONE);
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                    startActivity(intent);
                                                    finish();
                                                } else {
                                                    Toast.makeText(getApplicationContext(), "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                            } else {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), "Failed to upload user data", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}