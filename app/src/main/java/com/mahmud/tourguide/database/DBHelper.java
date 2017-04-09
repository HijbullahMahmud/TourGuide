package com.mahmud.tourguide.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "users_details_db";
    public static final int DB_VERSION = 1;

    public static final String DB_TABLE_PROFILE = "profile_details";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_ADDRESS = "address";


    public static final String DB_TABLE_EVENT_LIST = "eventlist";
    public static final String COLUMN_EVENT_ID = "id";
    public static final String COLUMN_EVENT_UID = "uid";
    public static final String COLUMN_DESTINATION = "destination";
    public static final String COLUMN_BUDGET = "budget";
    public static final String COLUMN_FROM_DATE = "fromdate";
    public static final String COLUMN_TO_DATE = "todate";

    private static final String TABLE_PROFILE_DETAILS_CREATE_QUERY = "create table "+DB_TABLE_PROFILE+"("+COLUMN_ID+" integer primary key autoincrement,"+COLUMN_USERNAME+" text,"+COLUMN_PASSWORD+" text,"+COLUMN_EMAIL+" text,"+COLUMN_PHONE+" text,"+COLUMN_ADDRESS+" text);";

    private static final String TABLE_EVENT_LIST_CREATE_QUERY ="create table "+DB_TABLE_EVENT_LIST+"("+COLUMN_EVENT_ID+" integer primary key autoincrement,"+COLUMN_EVENT_UID+" integer,"+COLUMN_DESTINATION+" text,"+COLUMN_BUDGET+" text,"+COLUMN_FROM_DATE+" text,"+COLUMN_TO_DATE+" text);";

    public DBHelper(Context context) {
        super( context, DB_NAME, null, DB_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( TABLE_PROFILE_DETAILS_CREATE_QUERY );
        db.execSQL( TABLE_EVENT_LIST_CREATE_QUERY );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table "+DB_TABLE_PROFILE+" if exists");
        db.execSQL("drop table "+DB_TABLE_EVENT_LIST+" if exists");

        onCreate(db);
    }
}
