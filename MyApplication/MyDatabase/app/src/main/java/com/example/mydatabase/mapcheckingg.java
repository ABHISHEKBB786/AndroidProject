package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mapcheckingg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapcheckingg);
    }
    public void btncrntloc(View view) {
        startActivity(new Intent(getApplicationContext(),map.class));
    }
}
