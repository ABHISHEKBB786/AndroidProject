package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class lastfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastfile);


    }
    public void btn_back(View view) {
        startActivity(new Intent(getApplicationContext(),Main2Activity.class));
    }
}
