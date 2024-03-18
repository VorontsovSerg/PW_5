package com.example.pw5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ShashlikActivity extends AppCompatActivity {

    private Spinner shashlikSpinner;
    private ArrayAdapter<String> shashlikAdapter;
    private String[] shashlikTypes = {"Свинина", "Курица", "Говядина", "Баранина", "Утка", "Кролик", "Морской окунь"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shashlik);

        shashlikSpinner = findViewById(R.id.shashlikSpinner);

        shashlikAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, shashlikTypes);
        shashlikAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shashlikSpinner.setAdapter(shashlikAdapter);
    }
}
