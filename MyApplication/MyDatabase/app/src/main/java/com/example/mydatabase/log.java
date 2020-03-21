package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class log extends AppCompatActivity {
    Button btn_wash,btn_cls,btn_lab,btn_staff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        btn_wash=(Button)findViewById(R.id.btnwashroom);
        btn_cls=(Button)findViewById(R.id.btnclsroom);
        btn_lab=(Button)findViewById(R.id.btnlab);
        btn_staff=(Button)findViewById(R.id.btnstaff);

        btn_wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(log.this ,"you have selected washroom. ",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),mapcheckingg.class));
            }
        });
        btn_cls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(log.this ,"you have selected  class room..",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),camplaint.class));
            }
        });
        btn_lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(log.this ,"you have selected laboratory. ",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),camplaint.class));
            }
        });
        btn_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(log.this ,"you have selected staffroom. ",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),camplaint.class));
            }
        });


    }
}