package com.example.datastorage; // Replace with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure you have an activity_main.xml layout file

        // Initialize buttons by finding them in the layout
        Button buttonOpenSettings = findViewById(R.id.button_open_settings); // Replace with your button ID
        Button buttonOpenUserRegistration = findViewById(R.id.button_open_user_registration); // Replace with your button ID

        // Set up click listeners
        buttonOpenSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        buttonOpenUserRegistration.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UserRegistrationActivity.class);
            startActivity(intent);
        });
    }
}
