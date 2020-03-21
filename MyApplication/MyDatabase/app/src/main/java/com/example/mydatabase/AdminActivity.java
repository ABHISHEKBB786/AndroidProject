
package com.example.mydatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminActivity extends AppCompatActivity {
    // EditText name,phno,email;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    private  FirebaseDatabase firebaseDatabase;
   // TextView a,b,c;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        b1=(Button)findViewById(R.id.btnretrive);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this,RetriveData.class);
                startActivity(i);
                finish();
            }
        });
    }
        /*public void btnretrive(View view){
        startActivity(new Intent(getApplicationContext(),RetriveData.class));
        }*/

}