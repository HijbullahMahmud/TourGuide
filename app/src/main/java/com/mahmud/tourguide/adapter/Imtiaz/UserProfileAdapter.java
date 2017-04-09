package com.mahmud.tourguide.adapter.Imtiaz;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mahmud.tourguide.R;
import com.mahmud.tourguide.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/27/2017.
 */

public class UserProfileAdapter extends ArrayAdapter<UserModel>{
    ArrayList<UserModel>userModels;
    Context context;
    public UserProfileAdapter(Context context, ArrayList<UserModel> userModels) {
        super(context, R.layout.activity_user_profile, userModels);
        this.context = context;
        this.userModels = userModels;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,   ViewGroup parent) {
       // UserModel userModel = getItem(position);
        UserModel userModel = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_profile_row, parent, false);
        }
        TextView userNameTV = (TextView) convertView.findViewById(R.id.userNameTVLV);
        TextView userEmailTV = (TextView) convertView.findViewById(R.id.userEmailTVLV);
        TextView userPhoneTV = (TextView) convertView.findViewById(R.id.userPhoneTVLV);
        TextView userAddressTV = (TextView) convertView.findViewById(R.id.userAddressTVLV);
        userNameTV.setText(userModel.getUserName());
        userEmailTV.setText(userModel.getEmail());
        userPhoneTV.setText(userModel.getPhoneNumber());
        userAddressTV.setText(userModel.getAddress());

        return convertView;
    }
}
