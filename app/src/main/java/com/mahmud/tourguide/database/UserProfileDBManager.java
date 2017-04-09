package com.mahmud.tourguide.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mahmud.tourguide.model.UserModel;

import java.util.ArrayList;


public class UserProfileDBManager {
    DBHelper dbHelper;
    Context mContext;
   // UserModel mUsermodel;

    public UserProfileDBManager(Context context) {
        this.mContext = context;
        dbHelper = new DBHelper( context );
    }

    public long addUserToDB(UserModel usermodel){
        SQLiteDatabase sqlitedatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues(  );
        contentValues.put( dbHelper.COLUMN_USERNAME,usermodel.getUserName() );
        contentValues.put( dbHelper.COLUMN_PASSWORD,usermodel.getPassword() );
        contentValues.put( dbHelper.COLUMN_PHONE,usermodel.getPhoneNumber() );
        contentValues.put( dbHelper.COLUMN_EMAIL,usermodel.getEmail() );
        contentValues.put( dbHelper.COLUMN_ADDRESS,usermodel.getAddress() );
        long row = sqlitedatabase.insert( dbHelper.DB_TABLE_PROFILE,null,contentValues );
        sqlitedatabase.close();
        return row;
    }






    public ArrayList<UserModel> getUserByName ( ){
        ArrayList<UserModel>userModels = new ArrayList<>();
        SQLiteDatabase sqlite = dbHelper.getReadableDatabase();
        String query = "select * from "+DBHelper.DB_TABLE_PROFILE;
        Cursor cusor = sqlite.rawQuery( query,null );
        if (cusor.moveToFirst()){
            do {
                String userName = cusor.getString( cusor.getColumnIndex( dbHelper.COLUMN_USERNAME ) );
                String email = cusor.getString( cusor.getColumnIndex( dbHelper.COLUMN_EMAIL ) );
                String phone = cusor.getString( cusor.getColumnIndex( dbHelper.COLUMN_PHONE ) );
                String address = cusor.getString( cusor.getColumnIndex( dbHelper.COLUMN_ADDRESS ) );
                UserModel userModel = new UserModel(userName,email, phone,address);
                userModels.add(userModel);
            }while (cusor.moveToNext());


        }
        return userModels;
    }

    public boolean cheeckUser(String userName, String password){
        SQLiteDatabase sqlite = dbHelper.getReadableDatabase();
        String query = "SELECT id FROM profile_details WHERE username LIKE '"+userName+"' AND password LIKE '"+password+"'";
        Cursor cusor = sqlite.rawQuery( query,null );
        if (cusor.moveToFirst()){
            int id = cusor.getInt( cusor.getColumnIndex( dbHelper.COLUMN_ID ) );
            if (id>0){
                return true;
            }
        }
        return false;
    }
}
