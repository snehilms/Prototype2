package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    TextView register;
    Button loginBT;
    EditText loginEmail;
    EditText LoginPassword;
    ProgressBar LoginProgressBar;
    FirebaseAuth loginAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register=(TextView)findViewById(R.id.Register);
        loginBT=(Button)findViewById(R.id.loginBT);
        loginEmail=(EditText)findViewById(R.id.username);
        LoginPassword=(EditText)findViewById(R.id.passwordLogin);
        LoginProgressBar=findViewById(R.id.loginProgressBar);
        loginAuth=FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,signUp.class));
            }
        });

        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,targetPage.class));
                String userEmail=loginEmail.getText().toString();
                String userPassword=LoginPassword.getText().toString();

                if(TextUtils.isEmpty(userEmail))
                {
                    loginEmail.setError("Enter username");
                    loginEmail.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(userPassword))
                {
                    LoginPassword.setError("Enter password");
                    LoginPassword.requestFocus();
                    return;
                }
                LoginProgressBar.setVisibility(View.VISIBLE);
                loginAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(login.this,targetPage.class));
                            Toast.makeText(getApplicationContext(),"Login Sucessful",Toast.LENGTH_SHORT);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"username or password incorrect",Toast.LENGTH_SHORT);
                            LoginProgressBar.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }
        });
    }
}
