package com.example.finalfitnessmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class activity_back extends AppCompatActivity {

    ImageView backIV1, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        backIV1 = findViewById(R.id.back1);

        home = findViewById(R.id.home2);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_back.this, activity_discover.class);
                startActivity(intent);
            }
        });

        backIV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_back.this, activity_deadlift.class);
                startActivity(intent);
            }
        });
    }
}