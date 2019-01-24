package com.intern_app.practicesqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.PasswordAuthentication;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Users_db";
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USER_NAME = "username";
    public static final String PASS_WORD = "password";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME VARCHAR,LAST_NAME VARCHAR,USERNAME VARCHAR,PASSWORD VARCHAR)");
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }

    public boolean insertIntoDatabase(String f_name, String l_name, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME, f_name);
        contentValues.put(LAST_NAME, l_name);
        contentValues.put(USER_NAME, username);
        contentValues.put(PASS_WORD, password);

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public boolean userAuthentication(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery(" select * from users where USERNAME = ? and PASSWORD = ? ", new String[]{username, password});
        if (username.equals(USER_NAME) && password.equals(PASS_WORD)){
            return false;
        }else {
            return true;
        }
    }
}
