package com.example.gestiondestock;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseDevices extends SQLiteOpenHelper {
    private static final String DATA_BASE_NAME="Devices.db";
    private static final int DATA_BASE_VERSION=2;


    public DataBaseDevices(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS devices(id INTEGER  PRIMARY KEY AUTOINCREMENT ,code long,produits TEXT,catégorie TEXT,prix DOUBLE,quantité long)");
        db.execSQL("CREATE TABLE IF NOT EXISTS USERS(UserID INTEGER PRIMARY KEY, username TEXT, password TEXT)");


    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old, int newO) {


    }
    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from devices",null);
        return  cursor;

    }
}