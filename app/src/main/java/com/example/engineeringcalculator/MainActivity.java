package com.example.engineeringcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Engineering calculations");
        createSpinner();
    }

    void createSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("Russian");
        spinnerArrayList.add("English");
        spinnerArrayList.add("Spanish");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }


    public void calculationOfAuger(View view) {
        calculationOfAuger CalculationOfAuger = new calculationOfAuger();
        Intent calculationOfAugerIntent = new Intent(MainActivity.this, calculationOfAuger.class);
        startActivity(calculationOfAugerIntent);
    }

    public void calculateThermalGap(View view) {
        calculateThermalGap CalculateThermalGap = new calculateThermalGap();
        Intent calculateThermalGapIntent = new Intent(MainActivity.this, calculateThermalGap.class);
        startActivity(calculateThermalGapIntent);
    }

    public void calculationOfCylinderEfforts(View view) {
        calculationOfCylinderEfforts CalculationOfCylinderEfforts = new calculationOfCylinderEfforts();
        Intent calculationOfCylinderEffortsIntent = new Intent(MainActivity.this, calculationOfCylinderEfforts.class);
        startActivity(calculationOfCylinderEffortsIntent);
    }

    public void pressFitCalculation(View view) {
        pressFitCalculation PressFitCalculation = new pressFitCalculation();
        Intent pressFitCalculationIntent = new Intent(MainActivity.this, pressFitCalculation.class);
        startActivity(pressFitCalculationIntent); }

    public void massCalculation(View view) {
        massCalculation massCalculation = new massCalculation();
        Intent massCalculationIntent = new Intent(MainActivity.this, massCalculation.class);
        startActivity(massCalculationIntent); }

    public void weldingCalculation(View view) {
        weldingCalculation weldingCalculation = new weldingCalculation();
        Intent weldingCalculationIntent = new Intent(MainActivity.this, weldingCalculation.class);
        startActivity(weldingCalculationIntent);
    }

    public void threadCalculation(View view) {
        threadCalculation threadCalculation = new threadCalculation();
        Intent threadCalculationIntent = new Intent(MainActivity.this, threadCalculation.class);
        startActivity(threadCalculationIntent);
    }

    public void gost(View view) {
        gost gost = new gost();
        Intent gostIntent = new Intent(MainActivity.this, gost.class);
        startActivity(gostIntent); }






    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}