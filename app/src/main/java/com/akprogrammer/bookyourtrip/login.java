package com.akprogrammer.bookyourtrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.akprogrammer.bookyourtrip.R;

public class login extends AppCompatActivity {

    private Button letsStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the activity to full-screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        // Find the "Let's Start" button
        letsStartButton = findViewById(R.id.login);

        // Set OnClickListener to the button
        letsStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ProfileSetupActivity
                Intent intent = new Intent(login.this, Profile_setup.class);
                startActivity(intent);
            }
        });
    }
}
