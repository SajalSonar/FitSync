package com.example.finalfitnessmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profile extends AppCompatActivity {

    Button b1, b2;
    TextView t1;
    FirebaseAuth auth;
    FirebaseUser fu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        b1 = findViewById(R.id.backHome);
        t1 = findViewById(R.id.textView2);
        auth = FirebaseAuth.getInstance();
        fu1 = auth.getCurrentUser();

        b2 = findViewById(R.id.SignOut);

        if (fu1 == null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }else{
            t1.setText(fu1.getEmail());
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
