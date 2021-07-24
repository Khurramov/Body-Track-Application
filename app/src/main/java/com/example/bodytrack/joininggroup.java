package com.example.bodytrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class joininggroup extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joininggroup);

        button=(Button) findViewById(R.id.group1Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opengroup1();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.group2Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opengroup2();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.group3Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opengroup3();
            }
        });
    }

    public void opengroup1(){
        Intent intent = new Intent(this, group1.class);
        startActivity(intent);
    }
    //---------//
    public void opengroup2(){
        Intent intent = new Intent(this, group2.class);
        startActivity(intent);
    }
    //---------//
    public void opengroup3(){
        Intent intent = new Intent(this, group3.class);
        startActivity(intent);
    }
    //---------//

}