package com.example.finalfitnessmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_deadlift extends AppCompatActivity {

    ImageView dis1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadlift);

        dis1 = findViewById(R.id.dis1);
        t1 = findViewById(R.id.dl);


        dis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_deadlift.this, activity_back.class);
                startActivity(intent);
                finish();
            }
        });
        t1.setClickable(true);
        final String youtubeUrl = "https://youtube.com/shorts/vfKwjT5-86k?si=4dx_3-zAd0mC6d5I";

        t1.setText(youtubeUrl);
        t1.setClickable(true);
        t1.setOnClickListener(v -> {
            // Open the URL in a browser when clicked
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl));
            startActivity(intent);


        });


    }
}