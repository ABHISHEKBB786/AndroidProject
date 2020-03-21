package com.example.mydatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mydatabase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity  extends AppCompatActivity {

    EditText txtEmail, txtPassword;
    Button btn_Login;
    ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Login Form");

        txtEmail = (EditText) findViewById(R.id.email);
        txtPassword = (EditText) findViewById(R.id.pass);
        btn_Login = (Button) findViewById(R.id.logbn);
        //  progressBar=(ProgressBar)findViewById(R.id.progressBar);

        firebaseAuth = FirebaseAuth.getInstance();

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                //     progressBar.setVisibility(View.VISIBLE);
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this,"Please Enter Email",Toast.LENGTH_LONG).show();
                    //       progressBar.setVisibility(View.INVISIBLE);
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this,"Please Enter Password",Toast.LENGTH_LONG).show();
                    //     progressBar.setVisibility(View.INVISIBLE);
                    return;
                }
                if(password.length()<6){
                    Toast.makeText(MainActivity.this,"Password not valid",Toast.LENGTH_LONG).show();
                    //   progressBar.setVisibility(View.INVISIBLE);
                }


                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    //                 progressBar.setVisibility(View.VISIBLE);
                                    startActivity(new Intent(getApplicationContext(),log.class));

                                } else {
                                    Toast.makeText(MainActivity.this,"Login Failed or User Not Available",Toast.LENGTH_LONG).show();
                                }

                            }
                        });




            }
        });



    }


}