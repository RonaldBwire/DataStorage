package com.example.datastorage; // Replace with your actual package name

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextEmailSettings;
    private Button buttonSaveSettings;

    // Constants for SharedPreferences
    private static final String SHARED_PREFS_NAME = "MyUserSettings";
    private static final String KEY_USERNAME = "username_key";
    private static final String KEY_EMAIL = "email_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings); // Assuming you have an activity_settings.xml layout

        // Initialize UI components
        initViews();

        // Load saved settings when the activity is created
        loadSettings();

        // Set up click listener for the save button
        buttonSaveSettings.setOnClickListener(v -> saveSettings());
    }

    /**
     * Initializes the UI components by finding their respective views in the layout.
     */
    private void initViews() {
        editTextUsername = findViewById(R.id.editTextUsername); // Replace with your actual ID
        editTextEmailSettings = findViewById(R.id.editTextEmailSettings); // Replace with your actual ID
        buttonSaveSettings = findViewById(R.id.buttonSaveSettings); // Replace with your actual ID
    }

    /**
     * Loads user settings from SharedPreferences and populates the EditText fields.
     */
    private void loadSettings() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        String username = prefs.getString(KEY_USERNAME, "");
        String email = prefs.getString(KEY_EMAIL, "");

        editTextUsername.setText(username);
        editTextEmailSettings.setText(email);
    }

    /**
     * Saves user settings from the EditText fields to SharedPreferences.
     * Validates input before saving and displays a Toast message.
     */
    private void saveSettings() {
        String username = editTextUsername.getText().toString().trim();
        String email = editTextEmailSettings.getText().toString().trim();

        if (username.isEmpty() || email.isEmpty()) {
            showToast("Please fill in all fields");
            return;
        }

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMAIL, email);
        editor.apply(); // Asynchronously save changes

        showToast("Settings saved!");
    }

    /**
     * Helper method to display a Toast message.
     * @param message The message to display in the Toast.
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
