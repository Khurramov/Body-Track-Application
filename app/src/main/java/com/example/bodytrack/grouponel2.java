package com.example.bodytrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class grouponel2 extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grouponel2);

        //Moving to reminder page//
        button=(Button) findViewById(R.id.grouponel3BtnG1L2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opengrouponel3();
            }
        });
        button=(Button) findViewById(R.id.dailyBtnG1L2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opendailyexercises();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.diettipsBtnG1L2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opendiettips();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.weeklyweightBtnG1L2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openweeklyweight();
            }
        });


    }
    public void opengrouponel3(){
        Intent intent = new Intent(this, grouponel3.class);
        startActivity(intent);
    }
    //--------//
    public void opendailyexercises(){
        Intent intent = new Intent(this, dailyexercises2.class);
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