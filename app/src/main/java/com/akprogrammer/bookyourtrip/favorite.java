package com.akprogrammer.bookyourtrip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class favorite extends AppCompatActivity {

    private Button home = findViewById(R.id.button_home);
    private Button location;
    private Button favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        location = findViewById(R.id.button_location);
        favorite = findViewById(R.id.button_favorite);

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if already on the Location activity
                if (!(favorite.this instanceof favorite)) {
                    Intent intent = new Intent(favorite.this, favorite.class);
                    startActivity(intent);
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(favorite.this, Home.class);
                startActivity(intent);

            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(favorite.this, location.class);
                startActivity(intent);
            }
        });
    }
}
