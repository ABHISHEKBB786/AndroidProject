package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class practice extends AppCompatActivity {
    private EditText mvalfield,mkey;
    private Button maddbtn;

    private Firebase mrootref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        mrootref=new Firebase("https://mydatabase-d2023.firebaseio.com/member");
        mvalfield = (EditText)findViewById(R.id.valuefield);
        maddbtn=(Button)findViewById(R.id.addbtn);
        mkey=(EditText)findViewById(R.id.keyvalue);

        maddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value=mvalfield.getText().toString();
                String key=mkey.getText().toString();
                Firebase childref = mrootref.child("department");
                Firebase ch1=mrootref.child("location");
                //databaseReference.child("-M-GCjTtubYQtAVIlfkv").setValue(meb);
                // DocumentReference documentReference = fstore.collection("member").document(membid);
                childref.setValue(value);
                //mrootref.push().setValue(value);
                ch1.setValue(key);
            }
        });

    }
}
