package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class signUp extends AppCompatActivity {
    private EditText fullname;
    private EditText phone;
    private EditText emailAddress;
    private EditText password;
    private Button registrationBt;
    private TextView goToLogin;
    private ProgressBar progressBar;
    private TextView logintext;
    FirebaseAuth firebaseAuth;
    String fname;
    String pnum;
    String eaddress;
    String passwordText;
    FirebaseFirestore db= FirebaseFirestore.getInstance();
    CollectionReference userInformation =db.collection("USERS");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullname=findViewById(R.id.fullname);
        phone=findViewById(R.id.phone);
        emailAddress=findViewById(R.id.emailAddress);
        password =(EditText)findViewById(R.id.passwordSingUp);
        registrationBt=findViewById(R.id.registerBT);
        goToLogin=findViewById(R.id.LoginText);
        progressBar=findViewById(R.id.progressBar);
        logintext=findViewById(R.id.LoginText);

        firebaseAuth=FirebaseAuth.getInstance();

        logintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });

        firebaseAuth=FirebaseAuth.getInstance();

//        if(firebaseAuth.getCurrentUser()!=null)
//        {
//            startActivity(new Intent(getApplicationContext(),targetPage.class));
//            finish();
//        }

        registrationBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 fname=fullname.getText().toString();
                 pnum=phone.getText().toString();
                 eaddress=emailAddress.getText().toString();
                 passwordText=password.getText().toString();

                if(TextUtils.isEmpty(fname))
                {
                    fullname.setError("Full name is required");
                    fullname.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(pnum))
                {
                    phone.setError("Phone number is required");
                    phone.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(eaddress))
                {
                    emailAddress.setError("Email required");
                    emailAddress.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(passwordText))
                {
                    password.setError("Password is required");
                    password.requestFocus();
                    return;
                }

                if(passwordText.length()<6){
                    password.setError("Password length must be above 6");
                    password.requestFocus();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

            Users myuser=new Users(fname,pnum,eaddress,passwordText);

            userInformation.add(myuser).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                   // Toast.makeText(this,"User Added Successfully",Toast.LENGTH_SHORT);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

                firebaseAuth.createUserWithEmailAndPassword(eaddress, passwordText)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    Log.w("message", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(signUp.this, "Authentication Successful.",
                                            Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),targetPage.class));
                                }
                                else
                                {
                                    Log.w("message", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(signUp.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });


    }
}


/* How to logout from the app

Firebase.getInstance().signOut();
Go to the login Page using the intent
finsis();
 */