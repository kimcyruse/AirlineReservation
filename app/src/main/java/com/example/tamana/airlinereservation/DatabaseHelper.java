package com.example.tamana.airlinereservation;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import java.util.HashMap;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.Hashtable;
/**
 * Created by Tamana on 2018-04-03.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "FLIGHT.db";

    public static final String TABLE_NAME = "Customer_Info";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TITLE";
    public static final String COL_3 = "F_NAME";
    public static final String COL_4 = "L_NAME";
    public static final String COL_5 = "EMAIL";
    public static final String COL_6 = "PHONE";

    public DatabaseHelper(Context context)

    {
        super(context, DATABASE_NAME, null, 1);

    }


    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TITLE TEXT, F_NAME TEXT, L_NAME TEXT, EMAIL TEXT, PHONE TEXT)";
        db.execSQL(createTable);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String title, String fname, String lname, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, title);
        contentValues.put(COL_3, fname);
        contentValues.put(COL_4, lname);
        contentValues.put(COL_5, email);
        contentValues.put(COL_6, phone);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }



    }

    public Cursor showData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " +TABLE_NAME, null);
        return data;
    }

}

