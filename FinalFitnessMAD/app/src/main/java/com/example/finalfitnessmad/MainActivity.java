package com.example.finalfitnessmad;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private TextView t1;
    private CardView cv1, cv2, cv3, cv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the content view first

        // Initialize views
        t1 = findViewById(R.id.title1);

        cv1 = findViewById(R.id.cv1);
        cv2 = findViewById(R.id.cv2);
        cv3 = findViewById(R.id.cv3);
        cv4 = findViewById(R.id.cv4);
        // Enable edge-to-edge display
        EdgeToEdge.enable(this);

        // Set padding to handle system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Read data from Firebase database
        mDatabase = FirebaseDatabase.getInstance().getReference();
        readDataFromDatabase();

        // Set OnClickListener for cv1
        if (cv1 != null) {
            cv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, tracker.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

        if (cv2 != null) {
            cv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, activity_discover.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

        if (cv3 != null) {
            cv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, activity_diet.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

        if (cv4 != null) {
            cv4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, profile.class);
                    startActivity(intent);
                    finish();
                }
            });
        }



    }

    private void readDataFromDatabase() {
        // Get the current user's username
        String currentUserName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();

        DatabaseReference currentUserRef = mDatabase.child("Users").child(currentUserName);
        currentUserRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String userName = dataSnapshot.child("userName").getValue(String.class);
                    if (userName != null) {
                        t1.setText("Welcome " + userName);
                        Log.d("MainActivity", "Username retrieved: " + userName); // Log the retrieved username
                    } else {
                        t1.setText("Welcome");
                        Log.w("MainActivity", "Username is null"); // Log a warning if username is null
                    }
                } else {
                    t1.setText("Welcome");
                    Log.w("MainActivity", "User node does not exist"); // Log a warning if user node does not exist
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                Log.e("MainActivity", "Failed to read username", databaseError.toException()); // Log any database read errors
            }
        });
    }

}
