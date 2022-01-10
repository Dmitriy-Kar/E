package com.example.engineeringcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class massCalculation extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //спинер материалов
    Spinner spinner1;
    ArrayList spinnerArrayList1;
    ArrayAdapter spinnerAdapter1;

    HashMap metalMap1;
    String metalName1;
    double value1;


    //спинер профиля
    Spinner spinner2;
    ArrayList spinnerArrayList2;
    ArrayAdapter spinnerAdapter2;

    HashMap metalMap2;
    String profileName2;
    double value2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass_calculation);
        setTitle("Расчёт массы");


        spinner1 = findViewById(R.id.spinnerPartMaterial);
        spinner1.setOnItemSelectedListener(this);
        spinnerArrayList1 = new ArrayList();

        spinnerArrayList1.add("Сталь, 7.85 г/см3");
        spinnerArrayList1.add("Чугун, 7.0 г/см3");
        spinnerArrayList1.add("Медь, 8.96 г/см3");
        spinnerArrayList1.add("Алюминий, 2.7 г/см3");

        spinnerAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList1);
        spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(spinnerAdapter1);

        metalMap1 = new HashMap();
        metalMap1.put("Сталь, 7.85 г/см3", 7.85);
        metalMap1.put("Чугун, 7.0 г/см3", 7.0);
        metalMap1.put("Медь, 8.96 г/см3", 8.96);
        metalMap1.put("Алюминий, 2.7 г/см3", 2.69);


        //спинер профиля
        spinner2 = findViewById(R.id.spinnerPartProfile);
        spinner2.setOnItemSelectedListener(this);
        spinnerArrayList2 = new ArrayList();

        spinnerArrayList2.add("Круг");
        spinnerArrayList2.add("Труба");
        spinnerArrayList2.add("Квадрат");
        spinnerArrayList2.add("Труба профильная");

        spinnerAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList2);
        spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(spinnerAdapter2);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        metalName1 = spinner1.getSelectedItem().toString();
        value1 = (double) metalMap1.get(metalName1);


        profileName2 = spinner2.getSelectedItem().toString();


        ImageView ProfileImageView = findViewById(R.id.imageProfile);

        if (profileName2.equals("Круг")) {
            ProfileImageView.setImageResource(R.drawable.circle_1);
        } else if (profileName2.equals("Труба")) {
            ProfileImageView.setImageResource(R.drawable.tube_1);
        } else if (profileName2.equals("Квадрат")) {
            ProfileImageView.setImageResource(R.drawable.square_1);
        } else if (profileName2.equals("Труба профильная")) {
            ProfileImageView.setImageResource(R.drawable.profiletube_1);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    public void calculateMass(View view) {


        EditText el1 = (EditText) findViewById(R.id.valueL);
        EditText el2 = (EditText) findViewById(R.id.valueh);
        EditText el3 = (EditText) findViewById(R.id.valueb);
        EditText el4 = (EditText) findViewById(R.id.values);
        EditText el5 = (EditText) findViewById(R.id.valued);


        TextView L1_resText = (TextView) findViewById(R.id.valuem);


        double num1 = Integer.parseInt(el1.getText().toString());
        double num2 = Integer.parseInt(el2.getText().toString());
        double num3 = Integer.parseInt(el3.getText().toString());
        double num4 = Integer.parseInt(el4.getText().toString());
        double num5 = Integer.parseInt(el5.getText().toString());


        if (profileName2.equals("Круг")) {
            double L1_resSum = ((3.14 * Math.pow(num5, 2) / 4)) * num1 * value1 / 1000000;
            DecimalFormat L1_resSum_decimalFormat=new DecimalFormat("#.#");
            String result_L1_resSum =L1_resSum_decimalFormat.format(L1_resSum);
            L1_resText.setText("" + result_L1_resSum);
        } else if (profileName2.equals("Труба")) {
            double L1_resSum = (((3.14 * Math.pow(num5, 2) / 4) - (3.14 * Math.pow((num5 - num4 - num4), 2) / 4)) * num1 * value1 / 1000000);
            DecimalFormat L1_resSum_decimalFormat=new DecimalFormat("#.#");
            String result_L1_resSum =L1_resSum_decimalFormat.format(L1_resSum);
            L1_resText.setText(result_L1_resSum);
        } else if (profileName2.equals("Квадрат")) {
            double L1_resSum = num2 * num3 * num1 * value1 / 1000000;
            DecimalFormat L1_resSum_decimalFormat=new DecimalFormat("#.#");
            String result_L1_resSum =L1_resSum_decimalFormat.format(L1_resSum);
            L1_resText.setText(result_L1_resSum);
        } else if (profileName2.equals("Труба профильная")) {
            double L1_resSum = ((num2 * num3) - ((num2 - num4 - num4) * (num3 - num4 - num4))) * num1 * value1 / 1000000;
            DecimalFormat L1_resSum_decimalFormat=new DecimalFormat("#.#");
            String result_L1_resSum =L1_resSum_decimalFormat.format(L1_resSum);
            L1_resText.setText(result_L1_resSum);}

            /** СТАРЫЙ КОД
             if (profileName2.equals("Круг"))
             {double L1_resSum = ((3.14*Math.pow(num5,2)/4))*num1*value1/1000000;
             L1_resText.setText(""+L1_resSum);}

             else if (profileName2.equals("Труба"))
             {double L1_resSum = (((3.14*Math.pow(num5,2)/4)-(3.14*Math.pow((num5-num4-num4),2)/4))*num1*value1/1000000);
             L1_resText.setText(""+L1_resSum);}

             else if (profileName2.equals("Квадрат"))
             {double L1_resSum = num2*num3*num1*value1/1000000;
             L1_resText.setText(""+L1_resSum);}

             else if (profileName2.equals("Труба профильная"))
             {double L1_resSum = ((num2*num3)-((num2-num4-num4)*(num3-num4-num4)))*num1*value1/1000000;
             L1_resText.setText(""+L1_resSum);}*/

        }
    }


