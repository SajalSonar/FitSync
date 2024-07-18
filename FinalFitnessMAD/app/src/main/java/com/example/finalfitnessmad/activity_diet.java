package com.example.finalfitnessmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class activity_diet extends AppCompatActivity {
    EditText weightET;
    ImageView home3;
    TextView result, caloriesConsumed1, waterConsumed1;
    Button calculateCals, addCals, addWater;
    Integer calories = 0, water = 0;
    ProgressBar progressBar, pb2;
    int BMR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        home3 = findViewById(R.id.home2);
        weightET = findViewById(R.id.weightEditText);
        result = findViewById(R.id.resultTextView);
        caloriesConsumed1 = findViewById(R.id.caloriesConsumedTextView);
        waterConsumed1 = findViewById(R.id.waterConsumedTextView);
        progressBar = findViewById(R.id.t_progressbar1);
        pb2 = findViewById(R.id.t_progressbar2);

        calculateCals = findViewById(R.id.calculateButton);
        addCals = findViewById(R.id.addCaloriesButton);
        addWater = findViewById(R.id.addWaterButton);

        calculateCals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer weight1 = Integer.valueOf(weightET.getText().toString());
                BMR = 1000 + (10 * weight1);
                result.setText("Consume Avergae Calories : " + BMR);
                progressBar.setMax(BMR);
            }
        });

        addCals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calories += 100; // Assuming 100 calories added
                caloriesConsumed1.setText("Calories Consumed: " + calories);
                updateProgressBar();
            }
        });

        addWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                water += 250; // Assuming 250 ml added
                waterConsumed1.setText("Water Consumed: " + water + " ml / 3500 ml");
                updateProgressBar2();
            }
        });

        home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public  void updateProgressBar2(){
        pb2.setProgress(water);
    }

    private void updateProgressBar() {
        progressBar.setProgress(calories);
    }
}