package com.example.bodytrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        EditText edWeg,edHei;
        TextView txtRes,txtEnter;
        Button btnRes,btnReset;

        edWeg=(EditText) findViewById(R.id.edweg);
        edHei=(EditText) findViewById(R.id.edhei);

        txtEnter=(TextView) findViewById(R.id.txtenter);
        txtRes=(TextView) findViewById(R.id.txtres);

        btnRes=(Button) findViewById(R.id.btnres);
        btnReset=(Button) findViewById(R.id.btnreset);

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strweg=edWeg.getText().toString();
                String strhei=edHei.getText().toString();

                if (strweg.equals("")){
                    edWeg.setError("Please Enter Your Weight ");
                    edWeg.requestFocus();
                    return;
                }
                    if (strhei.equals("")){
                        edHei.setError("Please Enter Your Height ");
                        edHei.requestFocus();
                        return;
                    }

                    float weight = Float.parseFloat(strweg);
                    float height = Float.parseFloat(strhei)/100;

                    float bmiValue = BMICalculate(weight,height);

                    txtEnter.setText(interpreteBMI(bmiValue));
                    txtRes.setText("BMI= "+bmiValue);


            }
        });
        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                edHei.setText("");
                edWeg.setText("");
                txtEnter.setText("");
                txtRes.setText("");

            }
        });

    }
    public float BMICalculate(float weight,float height){
        return weight / (height*height);
    }
    public String interpreteBMI(float bmiValue){
        if(bmiValue<16){
            return "Servely Underweight";
        }
        else if (bmiValue<18.5){
            return "Underweight";
        }
        else if (bmiValue<25){
            return "Overweight";
        }
        else
            return "Obese";
    }
}