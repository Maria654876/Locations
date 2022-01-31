package com.example.locations.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="locationBd.db";
    public static final String TABLE_NAME="location";
    public static final String KEY_NAME="name";
    public static final String KEY_IMG="image";

    public DBHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +
                TABLE_NAME + " ( " +KEY_NAME + "text,"+ KEY_IMG + "BLOB"+")" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }
}
