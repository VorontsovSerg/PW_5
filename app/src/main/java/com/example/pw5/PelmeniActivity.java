package com.example.pw5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PelmeniActivity extends AppCompatActivity {

    private RecyclerView pelmeniRecyclerView;
    private PelmeniAdapter pelmeniAdapter;

    // Массив с видами пельменей
    private String[] pelmeniVarieties = {
            "Пельмени с мясом",
            "Пельмени с курицей",
            "Пельмени с лососем",
            "Пельмени с говядиной",
            "Пельмени с свининой"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelmeni);

        pelmeniRecyclerView = findViewById(R.id.pelmeniRecyclerView);
        pelmeniRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> pelmeniList = Arrays.asList(pelmeniVarieties);
        pelmeniAdapter = new PelmeniAdapter(pelmeniList, this);
        pelmeniRecyclerView.setAdapter(pelmeniAdapter);
    }
}
