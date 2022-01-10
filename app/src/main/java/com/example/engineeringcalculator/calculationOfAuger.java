package com.example.engineeringcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class calculationOfAuger extends AppCompatActivity implements View.OnClickListener {



    //объявляем элементы экрана
    EditText value_d;
    EditText value_D;
    EditText value_S;
    EditText value_h;

    Button calculateButton;

    TextView value_d1;
    TextView value_D1;
    TextView value_A;
    TextView value_m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_of_auger);
        setTitle("Расчёт витков шнека");
    }


    public void workpieceCalculation(View view) {

        double x;

        EditText el1 = (EditText)findViewById(R.id.value_d);
        EditText el2 = (EditText)findViewById(R.id.value_D);
        EditText el3 = (EditText)findViewById(R.id.value_S);
        EditText el4 = (EditText)findViewById(R.id.value_h);

        TextView d1resText = (TextView)findViewById(R.id.value_d1);
        TextView D1resText = (TextView)findViewById(R.id.value_D1);
        TextView AresText = (TextView)findViewById(R.id.value_A);
        TextView m_resText = (TextView)findViewById(R.id.value_m);



        int num1 = Integer.parseInt(el1.getText().toString());
        int num2 = Integer.parseInt(el2.getText().toString());
        int num3 = Integer.parseInt(el3.getText().toString());
        int num4 = Integer.parseInt(el4.getText().toString());



        double d1resSum = ((num2-num1)*Math.sqrt(Math.pow(num3,2)+Math.pow((3.14*num1),2))/(Math.sqrt(Math.pow (num3,2)+Math.pow((3.14*num2),2)) - Math.sqrt(Math.pow(num3,2)+Math.pow ((3.14*num1),2))));
        DecimalFormat d1resSum_decimalFormat=new DecimalFormat("#.#");
        String result_d1resSum =d1resSum_decimalFormat.format(d1resSum);
        d1resText.setText(""+result_d1resSum);


        double D1resSum = (d1resSum+num2-num1);
        DecimalFormat D1resSum_decimalFormat=new DecimalFormat("#.#");
        String result_D1resSum =D1resSum_decimalFormat.format(D1resSum);
        D1resText.setText(""+result_D1resSum);


        double AresSum = (360*(3.14*d1resSum-Math.sqrt(((Math.pow(num3,2)+(Math.pow (3.14*num1, 2)))))))/(3.14*d1resSum);
        DecimalFormat AresSum_decimalFormat=new DecimalFormat("#.#");
        String result_AresSum =AresSum_decimalFormat.format(AresSum);
        AresText.setText(""+result_AresSum);


        double m_resSum = ((3.14*Math.pow(D1resSum,2)/4)-(3.14*Math.pow(d1resSum,2)/4)-3.14*4/360*(Math.pow(D1resSum,2)-Math.pow(d1resSum,2)))*num4*0.0078/1000;
        DecimalFormat m_resSum_decimalFormat=new DecimalFormat("#.#");
        String result_m_resSum =m_resSum_decimalFormat.format(m_resSum);
         m_resText.setText(""+result_m_resSum);




        /** СТАРЫЙ КОД
         double d1resSum = Math.round( (num2-num1)*Math.sqrt(Math.pow(num3,2)+Math.pow((3.14*num1),2))/(Math.sqrt(Math.pow (num3,2)+Math.pow((3.14*num2),2)) - Math.sqrt(Math.pow(num3,2)+Math.pow ((3.14*num1),2))));
        d1resText.setText(Integer.toString((int) d1resSum));

        double D1resSum = Math.round (d1resSum+num2-num1);
        D1resText.setText(Integer.toString((int) D1resSum));

        double AresSum = (360*(3.14*d1resSum-Math.sqrt(((Math.pow(num3,2)+(Math.pow (3.14*num1, 2)))))))/(3.14*d1resSum);
        AresText.setText(""+result_AresSum);

        double m_resSum = ((3.14*Math.pow(D1resSum,2)/4)-(3.14*Math.pow(d1resSum,2)/4)-3.14*4/360*(Math.pow(D1resSum,2)-Math.pow(d1resSum,2)))*num4*0.0078/1000;
        m_resText.setText(""+m_resSum);*/


    }



    @Override
    public void onClick(View v) {

    }
}