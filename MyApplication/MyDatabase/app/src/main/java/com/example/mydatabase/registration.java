package com.example.mydatabase;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mydatabase.Main2Activity;
import com.example.mydatabase.R;
import com.example.mydatabase.member;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;
import java.util.Objects;
import java.util.regex.Pattern;

public class registration extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN=
            Pattern.compile("^" +
                    "(?=.*[0-9])"+
                    "(?=.*[A-Z])"+
                    "(?=.*[a-z])"+
                    "(?=.*[@#$%^&+=])"+
                    "(?=\\s+$)"+
                    ".{6,}" +
                    "$");

    EditText txt_fullName,txt_phno,txt_email,txt_password,txt_confirmPassword;
    Button btn_register;
    String fullName,phno,email;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;



    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().setTitle("Signup Form");

        txt_fullName = (EditText)findViewById(R.id.name);
        txt_email = (EditText)findViewById(R.id.email);
        txt_phno = (EditText)findViewById(R.id.phno);
        txt_password = (EditText)findViewById(R.id.pass);
        txt_confirmPassword = (EditText)findViewById(R.id.cpass);

        btn_register=(Button)findViewById(R.id.btninser);


        databaseReference = FirebaseDatabase.getInstance().getReference("member");
        firebaseAuth= FirebaseAuth.getInstance();


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullName = txt_fullName.getText().toString();
                email = txt_email.getText().toString();
                phno = txt_phno.getText().toString();
                final String password = txt_password.getText().toString();
                String confirmpassword = txt_confirmPassword.getText().toString();
                progressBar = (ProgressBar) findViewById(R.id.progressBar);




               boolean k= validateEmailAddress(txt_email);
               /* if (TextUtils.isEmpty(email)) {
                    //Toast.makeText(registration.this, "Please Enter Email", Toast.LENGTH_LONG).show();
                    txt_email.setError("email is erquired...");
                    return;

                }*/
                /*else if(Patterns.EMAIL_ADDRESS.matcher(email)){
                    txt_email.setError("please enter valid email ...");
                    return;
                }/*/
               // checkemail();
                if (TextUtils.isEmpty(fullName)) {
                   // Toast.makeText(registration.this, "Please Enter Fullname", Toast.LENGTH_LONG).show();
                    txt_fullName.setError("Name is erquired...");
                    return;
                }
                if (TextUtils.isEmpty(phno)) {
                    //Toast.makeText(registration.this, "Please Enter Phone Number", Toast.LENGTH_LONG).show();
                    txt_phno.setError("Phone number is erquired...");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                   // Toast.makeText(registration.this, "Please Enter Password", Toast.LENGTH_LONG).show();
                    txt_password.setError("Enter password...");
                    return;
                }



                if (password.length() < 6  || PASSWORD_PATTERN.matcher(password).matches() ) {
                    txt_password.setError("please enter valid password");
                   // Toast.makeText(registration.this, "Password not strong", Toast.LENGTH_LONG).show();
                }
               /* else if(PASSWORD_PATTERN.matcher(password).matches()){
                    txt_password.setError("please enter valid password");
                    Toast.makeText(registration.this, "Password is not strong", Toast.LENGTH_LONG).show();
                }*/

                if (TextUtils.isEmpty(confirmpassword)) {
                    // Toast.makeText(registration.this, "Please Confirm Password", Toast.LENGTH_LONG).show();
                    txt_confirmPassword.setError(" confirm  your password...");
                    return;
                }

if (k==true){

    Toast.makeText(registration.this,"eamil validated suceefully",Toast.LENGTH_SHORT).show();

    if (password.equals(confirmpassword)) {

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(registration.this, new OnCompleteListener<AuthResult>() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            member MEB = new member(
                                    fullName,
                                    phno,
                                    email,
                                    password
                            );

                            FirebaseDatabase.getInstance().getReference("member")
                                    .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                    .setValue(MEB).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    Toast.makeText(registration.this, "Registraterd successfully", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                                }
                            });
                        }
                        else {
                            try {
                                throw task.getException();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(registration.this, "Email id already exists", Toast.LENGTH_LONG).show();
                        }
                        //progressBar.setVisibility(View.VISIBLE);
                    }
                });

    }
    else{
        Toast.makeText(registration.this, "Passwords Do Not Match", Toast.LENGTH_LONG).show();
    }

}
else{
    Toast.makeText(registration.this, "please enter valid emial id", Toast.LENGTH_LONG).show();
}


            }

         /*   private void checkemail() {
                FirebaseUser firebaseUser =firebaseAuth.getInstance().getCurrentUser();
                Boolean emailflag =firebaseUser.isEmailVerified();
                if (emailflag){
                    finish();
                    return;
                }
                else{
                    Toast.makeText(registration.this,"verifying",Toast.LENGTH_LONG).show();
                }
            }*/

            private boolean validateEmailAddress(EditText email){
                String eminp=txt_email.getText().toString();

                if(!eminp.isEmpty()  && Patterns.EMAIL_ADDRESS.matcher(eminp).matches()){
                    //Toast.makeText(registration.this,"validateed suceefullyy ",Toast.LENGTH_SHORT).show();
                    return true;
                }
                else{
                    //Toast.makeText(registration.this,"Invailad email id",Toast.LENGTH_SHORT).show();
                    return false;
                }
            }


        });
    }
}
