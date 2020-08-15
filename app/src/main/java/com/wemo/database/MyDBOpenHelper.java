package com.wemo.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class MyDBOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_Name = "RoadAssist";
    public static final int DATABASE_VERSION = 1;

    public MyDBOpenHelper(@Nullable Context context) {
        super(context,DATABASE_Name, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserFormTable.SQL_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserFormTable.SQL_DELETE);
        onCreate(db);
    }
}
