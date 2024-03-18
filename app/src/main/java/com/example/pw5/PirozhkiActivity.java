package com.example.pw5;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class PirozhkiActivity extends AppCompatActivity {

    private ListView pirozhkiListView;
    private ArrayAdapter<String> pirozhkiAdapter;
    private ArrayList<String> pirozhkiList;

    private EditText pirozhkiNewItemEditText;
    private Button pirozhkiAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pirozhki);

        pirozhkiListView = findViewById(R.id.pirozhkiListView);
        pirozhkiNewItemEditText = findViewById(R.id.pirozhkiNewItemEditText);
        pirozhkiAddButton = findViewById(R.id.pirozhkiAddButton);

        pirozhkiList = new ArrayList<>();
        pirozhkiList.add("Пирожки с капустой");
        pirozhkiList.add("Пирожки с мясом");
        pirozhkiList.add("Пирожки с картошкой");
        pirozhkiList.add("Пирожки с вишней");
        pirozhkiList.add("Пирожки с творогом");
        pirozhkiList.add("Пирожки с яблоками");
        pirozhkiList.add("Пирожки с лососем");

        pirozhkiAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pirozhkiList);
        pirozhkiListView.setAdapter(pirozhkiAdapter);

        pirozhkiAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = pirozhkiNewItemEditText.getText().toString();
                if (!newItem.isEmpty()) {
                    pirozhkiList.add(newItem);
                    pirozhkiAdapter.notifyDataSetChanged();
                    pirozhkiNewItemEditText.setText("");
                }
            }
        });
    }
}
