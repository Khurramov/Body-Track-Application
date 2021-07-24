package com.example.bodytrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class group3 extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group3);

        button=(Button) findViewById(R.id.daily3Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opendailyexercises3();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.diettips3Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opendiettips3();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.weeklyweight3Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openweeklyweight3();
            }
        });
        button=(Button) findViewById(R.id.groupthree2Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opengroupthree2();
            }
        });
    }

    public void opendailyexercises3(){
        Intent intent = new Intent(this, dailyexercises3.class);
        startActivity(intent);
    }
    //--------//
    public void opendiettips3(){
        Intent intent = new Intent(this, diettips3.class);
        startActivity(intent);
    }
    //-----//
    public void openweeklyweight3(){
        Intent intent = new Intent(this, weeklyweight3.class);
        startActivity(intent);
    }
    //---------//
    public void opengroupthree2(){
        Intent intent = new Intent(this, groupthree2.class);
        startActivity(intent);
    }
    //---------//
}
