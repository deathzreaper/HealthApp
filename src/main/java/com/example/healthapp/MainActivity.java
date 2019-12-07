package com.example.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button buttonCalculate, buttonLogout;
    EditText inputKg, inputM;
    TextView showResult, showBMI, showImpBMI;
    private double kg, m;
    private DecimalFormat TWO_DECIMAL_PLACES = new DecimalFormat(".##");
    MetricFormula metricFormula; ImperialFormula imperialFormula;
    BMICategory bmiCategory = new BMICategory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home );

        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonLogout = findViewById(R.id.buttonlogout);
        inputKg = findViewById(R.id.inputKg);
        inputM = findViewById(R.id.inputM);
        showResult = findViewById(R.id.showResult);
        showBMI = findViewById(R.id.showBMI);
        showImpBMI = findViewById(R.id.showImpBMI);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kg = Double.parseDouble(inputKg.getText().toString());
                m = Double.parseDouble(inputM.getText().toString());

                metricFormula = new MetricFormula(kg, m);
                imperialFormula = new ImperialFormula(kg, m);

                showBMI.setText("BMI = " + String.valueOf(TWO_DECIMAL_PLACES.format(metricFormula.computeBMI(metricFormula.getInputKg(),metricFormula.getInputM()))));
                showImpBMI.setText("In imperial formula: " + String.valueOf(TWO_DECIMAL_PLACES.format(imperialFormula.computeBMI(imperialFormula.getInputKg(), imperialFormula.getInputM()))));
                showResult.setText(bmiCategory.getCategory(metricFormula.computeBMI(metricFormula.getInputKg(),metricFormula.getInputM())));

            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent exit = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(exit);
            }
        });

    }
}
