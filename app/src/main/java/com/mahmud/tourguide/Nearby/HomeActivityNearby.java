package com.mahmud.tourguide.Nearby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mahmud.tourguide.R;

public class HomeActivityNearby extends AppCompatActivity {

    Button atm,hospital,restaurent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_nearby);
        atm= (Button) findViewById(R.id.nearbyATMBtn);
        restaurent= (Button) findViewById(R.id.nearbyResBtn);
        hospital= (Button) findViewById(R.id.nearbyHospitalBtn);

        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivityNearby.this,MainActivity.class);
                String atm="atm";
                intent.putExtra("ATM",atm);
                startActivity(intent);
            }
        });
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivityNearby.this,MainActivity.class);
                String atm="hospitals";
                intent.putExtra("Hospital",atm);
                startActivity(intent);
            }
        });
        restaurent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivityNearby.this,MainActivity.class);
                String atm="Food|Cafe";
                intent.putExtra("Food",atm);
                startActivity(intent);

            }
        });
    }

}
