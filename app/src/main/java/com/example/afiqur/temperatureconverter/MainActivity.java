package com.example.afiqur.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputET;
    private RadioButton celRB, farRB;
    private Button convertBtn;
    private TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputET = findViewById(R.id.inputET);
        celRB = findViewById(R.id.celRB);
        farRB = findViewById(R.id.farRB);
        convertBtn = findViewById(R.id.convertBtn);
        resultTV = findViewById(R.id.resultTV);


        convertBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        try {
            Double value = Double.parseDouble(inputET.getText().toString());

            if (celRB.isChecked()) {
                value = (5.0 / 9.0) * (value - 32);
                resultTV.setText(String.valueOf(value));
            } else if (farRB.isChecked()) {
                value = (9.0 / 5.0) * (value + 32);
                resultTV.setText(String.valueOf(value));
            }

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Error occured", Toast.LENGTH_SHORT).show();
        }


    }
}
