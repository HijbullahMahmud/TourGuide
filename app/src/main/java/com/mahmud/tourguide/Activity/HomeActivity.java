package com.mahmud.tourguide.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mahmud.tourguide.R;

public class HomeActivity extends AppCompatActivity {
    private Button loginBTN;
    private Button signUpBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loginBTN = (Button) findViewById(R.id.loginBTn);
        signUpBTN = (Button) findViewById(R.id.signUpBTN);

    }

    public void Login(View view) {
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void SignUp(View view) {
        Intent intent = new Intent(HomeActivity.this, SignupActivity.class);
        startActivity(intent);
    }
}
