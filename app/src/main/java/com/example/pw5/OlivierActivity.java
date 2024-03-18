package com.example.pw5;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class OlivierActivity extends AppCompatActivity {

    private ListView olivierListView;
    private ArrayAdapter<String> olivierAdapter;
    private ArrayList<String> olivierList;

    private EditText olivierNewItemEditText;
    private Button olivierAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olivier);

        olivierListView = findViewById(R.id.olivieListView);
        olivierNewItemEditText = findViewById(R.id.olivieNewItemEditText);
        olivierAddButton = findViewById(R.id.olivieAddButton);

        olivierList = new ArrayList<>();
        olivierList.add("Классический оливье");
        olivierList.add("Оливье с курицей");
        olivierList.add("Оливье с говядиной");
        olivierList.add("Оливье с колбасой");
        olivierList.add("Оливье с морепродуктами");
        olivierList.add("Оливье с крабовыми палочками");
        olivierList.add("Оливье с грибами");

        olivierAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, olivierList);
        olivierListView.setAdapter(olivierAdapter);

        olivierAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = olivierNewItemEditText.getText().toString();
                if (!newItem.isEmpty()) {
                    olivierList.add(newItem);
                    olivierAdapter.notifyDataSetChanged();
                    olivierNewItemEditText.setText("");
                }
            }
        });
    }
}
