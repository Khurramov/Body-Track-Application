package com.example.bodytrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class group1 extends AppCompatActivity {

    private Button button;
    FirebaseDatabase database;
    DatabaseReference reference;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group1);

        database=FirebaseDatabase.getInstance();
        reference=database.getReference("videos");

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
        //Moving to reminder page//
        button=(Button) findViewById(R.id.grouponel2Btn);

        CheckLevel1VideosStatus();

    }

    public void CheckLevel1VideosStatus(){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot myDataSnapshot : dataSnapshot.getChildren())
                {
                    Video video = myDataSnapshot.getValue(Video.class);
                    if(video.getFlag() == 1) {
                        index++;
                    }
                }


                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            Toast.makeText(getApplicationContext(),"The index is " + index + " == " + (int) dataSnapshot.getChildrenCount(),Toast.LENGTH_LONG).show();
                            if(index == (int) dataSnapshot.getChildrenCount()) {
                                opengrouponel2();
                            }else {
                                Toast.makeText(getApplicationContext(),"You have to finish Level 1 and lose at least 3kg weight first!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
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
    public void opengrouponel2(){
        Intent intent = new Intent(this, grouponel2.class);
        startActivity(intent);
    }
    //--------//
}