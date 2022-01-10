package com.example.engineeringcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculationOfCylinderEfforts extends AppCompatActivity implements View.OnClickListener {


    EditText value_Dhc;
    EditText value_dhc;
    EditText value_Phc;

    Button calculateButton;

    TextView value_F1;
    TextView value_F2;
    TextView value_F1_ton;
    TextView value_F2_ton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_of_cylinder_efforts);
        setTitle("Расчёт усилий гидроцилиндра");
    }


    public void calculationForceCylinder(View view) {

        EditText el1 = (EditText)findViewById(R.id.value_Dhc);
        EditText el2 = (EditText)findViewById(R.id.value_dhc);
        EditText el3 = (EditText)findViewById(R.id.value_Phc);

        TextView F1resText = (TextView)findViewById(R.id.value_F1);
        TextView F2resText = (TextView)findViewById(R.id.value_F2);

        TextView F1resTonText = (TextView)findViewById(R.id.value_F1_ton);
        TextView F2resTonText = (TextView)findViewById(R.id.value_F2_ton);

        int num1 = Integer.parseInt(el1.getText().toString());
        int num2 = Integer.parseInt(el2.getText().toString());
        int num3 = Integer.parseInt(el3.getText().toString());



        double F1resSum = Math.round (num3*1000000*(Math.pow(num1,2)*3.14/4/1000/1000)/1000/10);
        F1resText.setText(Integer.toString((int) F1resSum));
        double F2resSum = Math.round (num3*1000000*(((Math.pow(num1,2)*3.14/4)-(Math.pow(num2,2)*3.14/4))/1000/1000)/1000/10);
        F2resText.setText(Integer.toString((int) F2resSum));



        double F1resTonSum = Math.round (num3*1000000*(Math.pow(num1,2)*3.14/4/1000/1000)/1000/10/10);
        F1resTonText.setText(Integer.toString((int) F1resTonSum));
        double F2resTonSum = Math.round (num3*1000000*(((Math.pow(num1,2)*3.14/4)-(Math.pow(num2,2)*3.14/4))/1000/1000)/1000/10/10);
        F2resTonText.setText(Integer.toString((int) F2resTonSum));


    }

    @Override
    public void onClick(View v) {

    }
}