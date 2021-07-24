package com.example.bodytrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bodytrack.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private ActionBar actionBar;
    private FirebaseAuth firebaseAuth;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        actionBar=getSupportActionBar();
        actionBar.setTitle("Login");
        
        firebaseAuth=FirebaseAuth.getInstance();
        checkUser();

        binding.logoutBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                firebaseAuth.signOut();
                checkUser();
            }
        });

        //Button for moving to exercise page//
        button=(Button) findViewById(R.id.exerciseBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openexercise();
            }
        });
           //Button for moving to diet page//
        button=(Button) findViewById(R.id.dietBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opendiet();
            }
        });
        //Moving to map page//

        //Moving to diet page//
        button=(Button) findViewById(R.id.DietBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opendiet_page();
            }
        });
        button=(Button) findViewById(R.id.AboutBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openabout();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.reminderBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openreminder();
            }
        });
        //Moving to reminder page//
        button=(Button) findViewById(R.id.groupBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openjoininggroup();
            }
        });



    }
    public void openexercise(){
        Intent intent = new Intent(this, exercise.class);
        startActivity(intent);
    }
    //--------//
    public void opendiet(){
        Intent intent = new Intent(this, bmi.class);
        startActivity(intent);
    }
    //-----//


    //---------//
    public void opendiet_page(){
        Intent intent = new Intent(this, diet_page.class);
        startActivity(intent);
    }
    //---------//
    public void openabout(){
        Intent intent = new Intent(this, about.class);
        startActivity(intent);
    }
    //---------//
    public void openreminder(){
        Intent intent = new Intent(this, reminder.class);
        startActivity(intent);
    }
    //---------//
    public void openjoininggroup(){
        Intent intent = new Intent(this, joininggroup.class);
        startActivity(intent);
    }
    //---------//



    private void checkUser() {
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if (firebaseUser==null){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        else{
            String email=firebaseUser.getEmail();
            binding.emailTv.setText(email);
        }
    }
}