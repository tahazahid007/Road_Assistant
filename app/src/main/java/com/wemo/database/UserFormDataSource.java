package com.wemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UserFormDataSource {

    private Context mContext;
    private MyDBOpenHelper myDBOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public UserFormDataSource(Context mContext) {
        this.mContext = mContext;
        this.myDBOpenHelper = new MyDBOpenHelper(mContext);
        sqLiteDatabase = myDBOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = myDBOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteDatabase.close();
    }
}
