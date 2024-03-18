package com.example.pw5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView dishesListView;
    private ArrayAdapter<String> dishesAdapter;
    String[] dishesArray = {
            "Борщ",
            "Пельмени",
            "Шашлык",
            "Оливье",
            "Пирожки"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dishesListView = findViewById(R.id.dishesListView);
        dishesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishesArray);
        dishesListView.setAdapter(dishesAdapter);

        dishesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedDish = dishesArray[position];
                switch (selectedDish) {
                    case "Борщ":
                        startActivity(new Intent(MainActivity.this, BorschActivity.class));
                        break;
                    case "Пельмени":
                        startActivity(new Intent(MainActivity.this, PelmeniActivity.class));
                        break;
                    case "Шашлык":
                        startActivity(new Intent(MainActivity.this, ShashlikActivity.class));
                        break;
                    case "Оливье":
                        startActivity(new Intent(MainActivity.this, OlivierActivity.class));
                        break;
                    case "Пирожки":
                        startActivity(new Intent(MainActivity.this, PirozhkiActivity.class));
                        break;
                }
            }
        });
    }
}