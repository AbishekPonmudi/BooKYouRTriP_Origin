package com.akprogrammer.bookyourtrip;

import static com.akprogrammer.bookyourtrip.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    private ImageButton bus;
    private Button home;
    private Button location;
    private Button favorite;
    private Button search;
    private ImageButton Flight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home);

        bus = findViewById(id.Bus);
        home = findViewById(id.button_home);
        location = findViewById(id.button_location);
        favorite = findViewById(id.button_favorite);
        search = findViewById(id.button_search);
        Flight = findViewById(id.Flight);

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if already on the Home activity
                if (!(Home.this instanceof Home)) {
                    Intent intent = new Intent(Home.this, Home.class);
                    startActivity(intent);
                }
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,location.class);
                startActivity(intent);
            }
        });


        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,com.akprogrammer.bookyourtrip.favorite.class);
                startActivity(intent);
            }
        });
    }
}
