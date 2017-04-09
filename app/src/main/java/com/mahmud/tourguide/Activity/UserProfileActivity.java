package com.mahmud.tourguide.Activity;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.mahmud.tourguide.R;

import com.mahmud.tourguide.adapter.Imtiaz.UserProfileAdapter;
import com.mahmud.tourguide.database.UserProfileDBManager;
import com.mahmud.tourguide.model.UserModel;

import java.util.ArrayList;


public class UserProfileActivity extends AppCompatActivity {
    ListView userProfileListView;

    UserProfileDBManager userProfileDBManager;
    ArrayList<UserModel>userModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userProfileListView = (ListView) findViewById(R.id.userProfileListView);
        userProfileDBManager = new UserProfileDBManager(this);
        userModels = userProfileDBManager.getUserByName();

        UserProfileAdapter userProfileAdapter = new UserProfileAdapter(getApplicationContext(), userModels);
        userProfileListView.setAdapter(userProfileAdapter);



    }
}
