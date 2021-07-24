package com.example.bodytrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class diet_page extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_page);

        //Button for moving to exercise page//
        button=(Button) findViewById(R.id.gainBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opengain();
            }
        });
        //Button for moving to exercise page//
        button=(Button) findViewById(R.id.loseBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openlose();
            }
        });
    }
    public void opengain(){
        Intent intent = new Intent(this, gain.class);
        startActivity(intent);
    }
    public void openlose(){
        Intent intent = new Intent(this, lose.class);
        startActivity(intent);
    }
}