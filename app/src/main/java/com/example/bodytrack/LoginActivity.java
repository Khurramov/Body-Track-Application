package com.example.bodytrack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.bodytrack.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private ActionBar actionBar;
    private String email="",password="";
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        actionBar=getSupportActionBar();
        actionBar.setTitle("Login");

        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Logging In");
        progressDialog.setCanceledOnTouchOutside(false);

        firebaseAuth=FirebaseAuth.getInstance();
        checkUser();


        binding.haveAccounttv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                validateData();
            }
        });
    }

    private void checkUser() {
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if (firebaseUser!=null){
            startActivity(new Intent(this, ProfileActivity.class));
            finish();
        }
    }

    private void validateData(){

        email=binding.emailEl.getText().toString().trim();
        password=binding.passwordEl.getText().toString().trim();

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailEl.setError("Invalid email format");
        }
        else if (TextUtils.isEmpty(password)){
            binding.passwordEl.setError("Enter password");
        }
        else {
            firebaseLogin();
        }

    }

    private void firebaseLogin() {

        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                        String email = firebaseUser.getEmail();
                        Toast.makeText(LoginActivity.this, "LoggedIn\n"+email, Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
                        finish();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });


    }
}