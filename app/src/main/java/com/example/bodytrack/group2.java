package com.example.bodytrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class group2 extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group2);

        button=(Button) findViewById(R.id.daily2Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opendailyexercises2();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.diettips2Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opendiettips2();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.weeklyweight2Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openweeklyweight2();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.grouptwo2Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opengrouptwo2();
            }
        });
    }

    public void opendailyexercises2(){
        Intent intent = new Intent(this, dailyexercises2.class);
        startActivity(intent);
    }
    //--------//
    public void opendiettips2(){
        Intent intent = new Intent(this, diettips2.class);
        startActivity(intent);
    }
    //-----//
    public void openweeklyweight2(){
        Intent intent = new Intent(this, weeklyweight2.class);
        startActivity(intent);
    }
    //---------//
    public void opengrouptwo2(){
        Intent intent = new Intent(this, grouptwo2.class);
        startActivity(intent);
    }
    //---------//
}