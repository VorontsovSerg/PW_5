package com.example.pw5;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;

public class BorschActivity extends AppCompatActivity {

    private ListView borschListView;
    private ArrayAdapter<String> borschAdapter;
    private ArrayList<String> borschList;

    private EditText borschNewItemEditText;
    private Button borschAddButton;
    private Button borschRemoveButton;

    // Массив разновидностей борща
    private String[] borschVarieties = {
            "Красный борщ",
            "Зелёный борщ",
            "Белый борщ",
            "Украинский борщ",
            "Польский борщ",
            "Литовский борщ",
            "Греческий борщ"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borsch);

        borschListView = findViewById(R.id.borschListView);
        borschNewItemEditText = findViewById(R.id.borschNewItemEditText);
        borschAddButton = findViewById(R.id.borschAddButton);
        borschRemoveButton = findViewById(R.id.borschRemoveButton);


        borschList = new ArrayList<>();
        Collections.addAll(borschList, borschVarieties);

        borschAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, borschList);
        borschListView.setAdapter(borschAdapter);
        borschListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        borschAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = borschNewItemEditText.getText().toString();
                if (!newItem.isEmpty()) {
                    borschList.add(newItem);
                    borschAdapter.notifyDataSetChanged();
                    borschNewItemEditText.setText("");
                }
            }
        });

        borschRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray checkedItemPositions = borschListView.getCheckedItemPositions();
                for (int i = checkedItemPositions.size() - 1; i >= 0; i--) {
                    int key = checkedItemPositions.keyAt(i);
                    boolean value = checkedItemPositions.get(key);
                    if (value) {
                        borschList.remove(key);
                    }
                }
                borschListView.clearChoices();
                borschAdapter.notifyDataSetChanged();
            }
        });
    }
}
