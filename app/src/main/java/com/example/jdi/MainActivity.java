package com.example.jdi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    String[] test = {"A", "B", "C", "D", "E", "A", "B", "C", "D", "E", "A", "B", "C", "D", "E"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        TableRow tableRow;


        int i = 0;
        tableRow = new TableRow(this);
        tableLayout.addView(tableRow);
        while(i < test.length){
            if(i > 0 && i % 2 == 0){
                tableRow = new TableRow(this);
                tableLayout.addView(tableRow);
            }
            Button button = new Button(this);
            button.setText(test[i]);
            button.setId(i);

            tableRow.addView(button);
            ++i;

        }
    }


}