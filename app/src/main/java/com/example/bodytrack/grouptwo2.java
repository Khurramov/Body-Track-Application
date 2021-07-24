package com.example.bodytrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class grouptwo2 extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupetwo2);

        button=(Button) findViewById(R.id.grouptwo3Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opengrouptwo3();
            }
        });

        button=(Button) findViewById(R.id.dailyBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opendailyexercises();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.diettipsBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opendiettips();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.weeklyweightBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openweeklyweight();
            }
        });
    }

    public void opengrouptwo3(){
        Intent intent = new Intent(this, grouptwo3.class);
        startActivity(intent);
    }
    //---------//
    public void opendailyexercises(){
        Intent intent = new Intent(this, dailyexercises.class);
        startActivity(intent);
    }
    //--------//
    public void opendiettips(){
        Intent intent = new Intent(this, diettips.class);
        startActivity(intent);
    }
    //-----//
    public void openweeklyweight(){
        Intent intent = new Intent(this, weeklyweight.class);
        startActivity(intent);
    }
    //---------//
}