package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edUserInput;
    Button btnCount;
    TextView tvMain;
    Spinner spSelectionOptions;
    TextCounter textCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edUserInput = findViewById(R.id.edUserInput);
        this.btnCount = findViewById(R.id.btnCount);
        this.tvMain = findViewById(R.id.tvMain);

        this.spSelectionOptions = (Spinner) findViewById(R.id.spSelectionOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.selection_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spSelectionOptions.setAdapter(adapter);

        textCounter = new TextCounter();
    }

    public void onBtnCountClick(View view) {
        String edUserInput = this.edUserInput.getText().toString().trim();
        if (edUserInput.isEmpty()) {
            Toast.makeText(this, "Please enter some text.", Toast.LENGTH_LONG).show();
        } else {
            String selectedItem = this.spSelectionOptions.getSelectedItem().toString();
            int result = 0;

            if (selectedItem.equalsIgnoreCase("Symbols")) {
                result = TextCounter.countSymbols(edUserInput);
            } else if (selectedItem.equalsIgnoreCase("Words")) {
                result = TextCounter.countWords(edUserInput);
            } else {
                Toast.makeText(this, "Not implemented", Toast.LENGTH_LONG).show();
            }

            Log.i("CountResult", String.valueOf(result));
            this.tvMain.setText(String.valueOf(result));
        }
    }
}
