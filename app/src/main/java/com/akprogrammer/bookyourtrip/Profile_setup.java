package com.akprogrammer.bookyourtrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile_setup extends AppCompatActivity {

    private Button signingButton;
    private TextView signUpButton;
    private EditText editEmail;
    private EditText editPassword;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_setup);

        mAuth = FirebaseAuth.getInstance();
        signingButton = findViewById(R.id.signin_button);
        signUpButton = findViewById(R.id.SignUp);
        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);

        progressBar = findViewById(R.id.progressBar); // Initialize progressBar

        signingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Profile_setup.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Profile_setup.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Show the loading animation when the button is clicked
                progressBar.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // Hide the loading animation when the task is complete
                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()) {
                                    Toast.makeText(Profile_setup.this, "Login Successfully",
                                            Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(Profile_setup.this, Home.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(Profile_setup.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_setup.this, Register_setup.class);
                startActivity(intent);
            }
        });

        // Check if the user is already signed in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // User is already signed in, redirect to Home activity
            Intent intent = new Intent(Profile_setup.this, Home.class);
            startActivity(intent);
            finish(); // Optional: Close the current activity
        }
    }
}
