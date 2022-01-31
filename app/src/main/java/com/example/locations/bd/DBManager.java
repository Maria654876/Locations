package com.example.locations.bd;

import static com.example.locations.bd.DBHelper.KEY_IMG;
import static com.example.locations.bd.DBHelper.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;

import javax.xml.namespace.QName;

public class DBManager {

    private Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase db;


    public DBManager(Context context){
        this.context=context;
        dbHelper=new DBHelper(context);
    }

    public void openDB(){

        db=dbHelper.getWritableDatabase();

    }

    public long insert(byte[] image) {
        return db.insert(TABLE_NAME, null, createContentValues(image));
    }

    private ContentValues createContentValues(byte[] image) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_IMG, image);
        return cv;
    }
}
