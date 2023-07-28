package com.akprogrammer.bookyourtrip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class location extends AppCompatActivity {

    private Button home;
    private Button location;
    private Button favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        home = findViewById(R.id.button_home);
        location = findViewById(R.id.button_location);
        favorite = findViewById(R.id.button_favorite);

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if already on the Location activity
                if (!(location.this instanceof location)) {
                    Intent intent = new Intent(location.this, location.class);
                    startActivity(intent);
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(location.this, Home.class);
                    startActivity(intent);

            }
        });

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(location.this, favorite.class);
                startActivity(intent);
            }
        });
    }
}
