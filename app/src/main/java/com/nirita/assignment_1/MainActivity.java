package com.nirita.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare variables
    EditText name, email;
    RadioGroup genderGroup;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        // Connect XML components with Java
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        genderGroup = findViewById(R.id.genderGroup);
        submit = findViewById(R.id.submit);

        // Submit button
        submit.setOnClickListener(v -> {

            String userName = name.getText().toString();
            String userEmail = email.getText().toString();

            // Get selected gender
            int selectedId = genderGroup.getCheckedRadioButtonId();

            // Check if fields are empty
            if (userName.isEmpty() || userEmail.isEmpty() || selectedId == -1) {

                Toast.makeText(
                        MainActivity.this,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Get selected RadioButton
            RadioButton selectedGender = findViewById(selectedId);

            String gender = selectedGender.getText().toString();

            // Create Intent
            Intent intent = new Intent(
                    MainActivity.this,
                    activity_details.class
            );

            // Send data to second screen
            intent.putExtra("name", userName);
            intent.putExtra("email", userEmail);
            intent.putExtra("gender", gender);

            // Open second screen
            startActivity(intent);
        });
    }
}