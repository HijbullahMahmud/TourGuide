package com.mahmud.tourguide.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mahmud.tourguide.R;
import com.mahmud.tourguide.database.UserProfileDBManager;

public class LoginActivity extends AppCompatActivity {
    private EditText emailET;
    private EditText passwordET;
    UserProfileDBManager userProfileDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = (EditText) findViewById(R.id.emailValueET);
        passwordET = (EditText) findViewById(R.id.passwordValueET);
        userProfileDBManager = new UserProfileDBManager(this);
    }

    public void logIn(View view) {
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();
        if (email.isEmpty()){
            emailET.setError("Enter Email");
        }else if (password.isEmpty()){
            passwordET.setError("Enter Password");
        }else {
            if (userProfileDBManager.cheeckUser(email, password)){
                Intent intent = new Intent(LoginActivity.this, EventActivity.class).putExtra("email", email);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(this, "Login Failed. Please enter valid email & password", Toast.LENGTH_LONG).show();
            }

        }



    }

    public void signIn(View view) {
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class );
        startActivity(intent);
    }
}
