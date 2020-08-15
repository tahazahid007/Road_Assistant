package com.wemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.wemo.model.UserForm;

public class UserFormDataSource {

    private static final String TAG = "myTag";
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

    public void insertItem(UserForm item){
        ContentValues contentValues = item.getValues();
        long insert = sqLiteDatabase.insert(UserFormTable.TABLE_USER_FORM, null, contentValues);
        Log.d(TAG, "insertItem: " + insert);
    }
}
