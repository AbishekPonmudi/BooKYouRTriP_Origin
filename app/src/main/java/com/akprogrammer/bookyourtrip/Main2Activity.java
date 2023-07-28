package com.akprogrammer.bookyourtrip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Main2Activity extends AppCompatActivity {

    CardView cardView;
    String fromCity, toCity;

    public static final String FROM = "from";
    public static final String TO = "to";
    private TextView fromText, toText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Get the "fromCity" and "toCity" values from the intent
        fromCity = getIntent().getStringExtra("fromCity");
        toCity = getIntent().getStringExtra("toCity");

        cardView = findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);

                // Pass the "fromCity" and "toCity" values to the next activity
                intent.putExtra("fromCity", fromCity);
                intent.putExtra("toCity", toCity);

                startActivity(intent);
            }
        });

        fromText = findViewById(R.id.from);
        toText = findViewById(R.id.to);

        fromText.setText(fromCity);
        toText.setText(toCity);
    }
}
