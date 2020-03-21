package com.example.mydatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RetriveData extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<locationhelper> userData;
    private userAdapter userAdapter;

    DatabaseReference dref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive_data);


        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userData = new ArrayList<locationhelper>();



        dref = FirebaseDatabase.getInstance().getReference().child("CYpOMJgdbjURWSmlavD1QtGBD0r2");
        dref.addListenerForSingleValueEvent(valueEventListener);
    }


    ValueEventListener valueEventListener=new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                locationhelper uData = dataSnapshot1.getValue(locationhelper.class);
                userData.add(uData);

            }

            //userAdapter = new userAdapter(RetriveData.this,member);
            userAdapter = new userAdapter(RetriveData.this,userData);
            recyclerView.setAdapter(userAdapter);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}
