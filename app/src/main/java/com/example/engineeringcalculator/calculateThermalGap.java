package com.example.engineeringcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class calculateThermalGap extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap metalMap;
    String metalName;
    double value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_thermal_gap);
        setTitle("Расчёт теплового зазора");

        spinner = findViewById(R.id.spinnerMetal);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("Сталь, 12.0");
        spinnerArrayList.add("Чугун, 10.0");
        spinnerArrayList.add("Медь, 17.2");
        spinnerArrayList.add("Алюминий, 24.3");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        metalMap = new HashMap();
        metalMap.put("Сталь, 12.0", 12.0);
        metalMap.put("Чугун, 10.0", 10.0);
        metalMap.put("Медь, 17.2", 17.2);
        metalMap.put("Алюминий, 24.3", 24.3);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        metalName = spinner.getSelectedItem().toString();
        value = (double)metalMap.get(metalName);
        TextView value_thermalExpansion = findViewById(R.id.value_thermalExpansion);
        value_thermalExpansion.setText(""+value);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void calculateThermalGap(View view) {

        EditText el1 = (EditText)findViewById(R.id.value_t1);
        EditText el2 = (EditText)findViewById(R.id.value_t2);
        EditText el3 = (EditText)findViewById(R.id.value_L);

        TextView L1_resText = (TextView)findViewById(R.id.value_L1);
        TextView L2_resText = (TextView)findViewById(R.id.value_L2);

        double num1 = Integer.parseInt(el1.getText().toString());
        double num2 = Integer.parseInt(el2.getText().toString());
        double num3 = Integer.parseInt(el3.getText().toString());


        double L2_resSum = ((num3*value*(num2-num1)/1000000)*0.9);
        DecimalFormat L2_resSum_decimalFormat=new DecimalFormat("#.###");
        String result_L2_resSum =L2_resSum_decimalFormat.format(L2_resSum);
        L2_resText.setText(""+result_L2_resSum);


        double L1_resSum = (L2_resSum + num3);
        DecimalFormat L1_resSum_decimalFormat=new DecimalFormat("#.###");
        String result_L1_resSum =L1_resSum_decimalFormat.format(L1_resSum);
        L1_resText.setText(""+result_L1_resSum);


      /** СТАРЫЙ КОД
         double L2_resSum = ((num3*value*(num2-num1)/1000000)*0.9);
        L2_resText.setText(""+L2_resSum);

        double L1_resSum = (L2_resSum + num3);
        L1_resText.setText(""+L1_resSum);*/

    }
}