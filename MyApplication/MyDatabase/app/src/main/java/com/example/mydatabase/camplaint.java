package com.example.mydatabase;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;
import org.w3c.dom.Text;

import java.util.ArrayDeque;
import java.util.Objects;

public class camplaint extends AppCompatActivity {

    EditText dept, timing, location;
    Button btn_submit;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
   // private Object Intent;


   public static final String EXTRA_TEXT="com.example.application.mydatabase.EXTRA_TEXT";
  // public static final String EXTRA_TEXTT="com.example.mydatabase.EXTRA_TEXT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camplaint);
        getSupportActionBar().setTitle("Complaint Form");
        Firebase.setAndroidContext(this);
        //final String user = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        // String username = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
       // final String unme=FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();

       // dept = (EditText) findViewById(R.id.dept);
        //timing = (EditText) findViewById(R.id.time);
        //location = (EditText) findViewById(R.id.loc);
       // btn_submit = (Button) findViewById(R.id.submit);
       // databaseReference = FirebaseDatabase.getInstance().getReference("complaint");

        firebaseAuth = FirebaseAuth.getInstance();

              /*  final String dpt = dept.getText().toString().trim();
                final String Tme = timing.getText().toString().trim();
                //final String loc = location.getText().toString().trim();

               /* if (TextUtils.isEmpty(loc)) {
                    dept.setError("loc is erquired...");
                    return;
                }
                if (TextUtils.isEmpty(Tme)) {
                    timing.setError("name is erquired...");
                    return;
                }
                if (TextUtils.isEmpty(dpt)) {
                    dept.setError("department is erquired...");
                    return;
                }
              /* member meb;
               meb=new member(dpt,loc,Tme,user,unme);
                FirebaseDatabase.getInstance().getReference("complaint")
                        .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                        .setValue(meb).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(camplaint.this, "complaint Registered Complete", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), lastfile.class));
                    }
                });*/


              /*  Toast.makeText(camplaint.this, "complaint Registered Complete", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), mapcheckingg.class));*/
            }
    public void btncrntloc(View view) {

       /* EditText edi1=(EditText) findViewById(R.id.dept);
        String text=edi1.getText().toString();

       /* EditText edi2=(EditText) findViewById(R.id.time);
        String text1= edi2.getText().toString();


        Intent intent = new Intent(this,map.class);
        //startActivity(new Intent(getApplicationContext(),map.class));
        intent.putExtra(EXTRA_TEXT, text);
       // inetent.putExtra(Intent.EXTRA_TEXT1);

        startActivity(intent);
        */

        startActivity(new Intent(getApplicationContext(), map.class));

    }

}

