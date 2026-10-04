package com.nirita.assignment_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_details extends AppCompatActivity {

    TextView nameText, emailText, genderText;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        genderText = findViewById(R.id.genderText);
        backButton = findViewById(R.id.backButton);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String gender = getIntent().getStringExtra("gender");

        nameText.setText("Name: " + name);
        emailText.setText("Email: " + email);
        genderText.setText("Gender: " + gender);

        backButton.setOnClickListener(v -> {
            finish();
        });
    }
}