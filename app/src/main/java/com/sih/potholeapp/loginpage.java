package com.sih.potholeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
    }

    public void civilianactivity(View view) {
        startActivity(new Intent(loginpage.this,MainActivity.class));
    }

    public void wrorkeractivity(View view) {
        startActivity(new Intent(loginpage.this,Main2Activity.class));
    }
}
