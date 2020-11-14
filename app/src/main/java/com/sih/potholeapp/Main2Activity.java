package com.sih.potholeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button login;
    private int counter=3;
    private TextView userRegistration;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Name =(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.tvinfo);
        login=(Button)findViewById(R.id.btnLogin);
        userRegistration=(TextView)findViewById(R.id.tvRegister);

        Info.setText("Number of attempts remaining:3");

        firebaseAuth=FirebaseAuth.getInstance();

        progressDialog =new ProgressDialog(this);


        FirebaseUser user= firebaseAuth.getCurrentUser();

        if(user !=null){
            finish();
            startActivity(new Intent(Main2Activity.this,workerActivity.class));

        }

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this,WorkerRegistrationActivity.class));

            }
        }); }



    private void validate( String userName, String userPassword){

        progressDialog.setMessage("Hey! By using this app we can solve potholes problem.");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    startActivity(new Intent(Main2Activity.this,workerActivity.class));
                    Toast.makeText(Main2Activity.this,"Login Successful", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(Main2Activity.this,"Login Failed!", Toast.LENGTH_SHORT).show();
                    counter--;
                    Info.setText("Number of attempts remaining:"+counter);
                    if(counter==0){
                        login.setEnabled(false);
                    }
                }
            }
        });


    }
}


