package com.example.bodytrack;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bodytrack.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private String email="",password ="";
    private ActionBar actionBar;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        actionBar=getSupportActionBar();
        actionBar.setTitle("SignUp");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        firebaseAuth=FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Creating your account...");
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("usersTable");


        binding.signUpBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                validateData();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    private void validateData() {
        String phoneNumber = binding.phonenumberEl.getText().toString().trim();
        String fullName = binding.fullnameEl.getText().toString().trim();
        email = binding.emailEl.getText().toString().trim();
        password=binding.passwordEl.getText().toString().trim();


        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
           binding.emailEl.setError("Invalid email format");
        }
        else if (TextUtils.isEmpty(password)){
            binding.passwordEl.setError("Enter password");
        }
        else if (password.length()<6){
            binding.emailEl.setError("Password must at least 6 characters long");
        }
        else {
//            Can't pass null for argument 'pathString' in child()
//            firebaseSignUp();
//

            String userId = databaseReference.push().getKey();

//            DatabaseReference usersRef = databaseReference.child("users");
//
//            Map<String, User> users = new HashMap<>();
//            users.put(fullName, new User(fullName,  email, password, phoneNumber));
//            users.put("gracehop", new User("December 9, 1906", "Grace Hopper"));

//            usersRef.setValueAsync(users);

//            System.out.println("User ID : "+userId);
            writeNewUserWithTaskListeners(userId,fullName, email, password, phoneNumber);
//            Context context = getApplicationContext();
//            Toast toast = Toast.makeText(context, "Your ID is "+userId, Toast.LENGTH_LONG);
//            toast.show();

        }
        

    }

    private void writeNewUser(String userId, String fullName, String email, String password, String phoneNumber) {
        User user = new User(fullName, email, password, phoneNumber);

        databaseReference.child("users").child(userId).setValue(user);
        Context context = getApplicationContext();
        CharSequence text;
        Toast toast = Toast.makeText(context, fullName +" successful Signup!", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void writeNewUserWithTaskListeners(String userId ,String fullName, String email, String password, String phoneNumber) {
        User user = new User(fullName, email, password, phoneNumber);

        // [START rtdb_write_new_user_task]
        databaseReference.child(userId).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Write was successful!
                        Context context = getApplicationContext();
                        CharSequence text;
                        Toast toast = Toast.makeText(context, "You" + fullName +" successful Signup!", Toast.LENGTH_SHORT);
                        toast.show();
                        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Write failed
                        Context context = getApplicationContext();
                        CharSequence text;
                        Toast toast = Toast.makeText(context, "Problem during signup", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
        // [END rtdb_write_new_user_task]

//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                // inside the method of on Data change we are setting
//                // our object class to our database reference.
//                // data base reference will sends data to firebase.
//                databaseReference.setValue(user);
//
//                // after adding this data we are showing toast message.
//                Toast.makeText(getApplicationContext(), "data added", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
//                finish();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // if the data is not added or it is cancelled then
//                // we are displaying a failure toast message.
//                Toast.makeText(getApplicationContext(), "Fail to add data " + error, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void firebaseSignUp() {

        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        progressDialog.dismiss();
                        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                        assert firebaseUser != null;
                        String email=firebaseUser.getEmail();
                        Toast.makeText(SignUpActivity.this, "Account created\n"+email, Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(SignUpActivity.this, ProfileActivity.class));
                        finish();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e){
                        progressDialog.dismiss();
                        Toast.makeText(SignUpActivity.this,""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
}