package com.example.finalfitnessmad;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tracker extends AppCompatActivity {

    Button track;
    ImageView toProfile, toHome;
    TextView greeting;
    private final List<Exercise> exerciseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        track = findViewById(R.id.track);
        toHome = findViewById(R.id.home1);
        toProfile = findViewById(R.id.profile);
        greeting = findViewById(R.id.header);


        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tracker.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ExerciseAdapter exerciseAdapter = new ExerciseAdapter(exerciseList);
        recyclerView.setAdapter(exerciseAdapter);

        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(exerciseAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExerciseInputDialog();
            }
        });
    }

    private void showExerciseInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.tracker_dialog, null);
        builder.setView(dialogView);

        final Spinner getBodyPart = dialogView.findViewById(R.id.bodyPartSpinner);
        final Spinner getExercise = dialogView.findViewById(R.id.exerciseSpinner);
        final EditText getSets = dialogView.findViewById(R.id.setSets);
        final EditText getReps = dialogView.findViewById(R.id.setReps);

        String[] bodyPartsArray = getResources().getStringArray(R.array.body_parts_array);
        final Map<String, String[]> exercisesMap = new HashMap<>();
        exercisesMap.put("Legs", getResources().getStringArray(R.array.leg_exercises_array));
        exercisesMap.put("Arms", getResources().getStringArray(R.array.arm_exercises_array));
        exercisesMap.put("Chest", getResources().getStringArray(R.array.chest_exercises_array));
        exercisesMap.put("Back", getResources().getStringArray(R.array.back_exercises_array));

        ArrayAdapter<String> bodyPartAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bodyPartsArray);
        bodyPartAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getBodyPart.setAdapter(bodyPartAdapter);

        final ArrayAdapter<String> exerciseAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new ArrayList<String>());
        exerciseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getExercise.setAdapter(exerciseAdapter);

        getBodyPart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedBodyPart = (String) parentView.getSelectedItem();
                String[] selectedExercises = exercisesMap.get(selectedBodyPart);
                if (selectedExercises != null) {
                    exerciseAdapter.clear();
                    exerciseAdapter.addAll(Arrays.asList(selectedExercises));
                    exerciseAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing if nothing is selected
            }
        });

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Here you can handle the submission of exercise data
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String strDate = formatter.format(date);
                String get_Date = strDate.toString();
                String bodyPart = getBodyPart.getSelectedItem() != null ? getBodyPart.getSelectedItem().toString() : "";
                String exercise = getExercise.getSelectedItem() != null ? getExercise.getSelectedItem().toString() : "";
                String sets = getSets.getText().toString();
                String reps = getReps.getText().toString();

                Exercise newExercise = new Exercise();
                newExercise.setDate(get_Date);
                newExercise.setBodyPart(bodyPart);
                newExercise.setExercise(exercise);
                newExercise.setSets(sets);
                newExercise.setReps(reps);

                exerciseList.add(newExercise);

                exerciseAdapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}