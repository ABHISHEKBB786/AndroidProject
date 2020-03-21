package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("HOUSE KEEPING");

    }


    public void btn_loginform(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    public void btn_signform(View view) {
        startActivity(new Intent(getApplicationContext(),registration.class));
    }

    public void btn_adloginform(View view){
        startActivity(new Intent(getApplicationContext(),adminlogin.class));
    }
}
