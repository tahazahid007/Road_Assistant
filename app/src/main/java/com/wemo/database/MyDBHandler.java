package com.wemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.wemo.model.UserForm;
import com.wemo.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {
    public MyDBHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.Form_TABLE + "("
                + Params.KEY_ID + " INTEGER PRIMARY KEY, "
                + Params.KEY_NAME + " TEXT, "
                + Params.KEY_CNIC + " TEXT, "
                + Params.KEY_PHONE + " TEXT, "
                + Params.KEY_SHOP_AREA + " TEXT, "
                + Params.KEY_SHOP_NAME + " TEXT, "
                + Params.KEY_SHOP_ADDRESS + " TEXT, "
                + Params.KEY_WORKING_HOURS + " TEXT, "
                + Params.KEY_EMAIL_ADDRESS + " TEXT, "
                + Params.KEY_LATITUDE + " TEXT, "
                + Params.KEY_LONGITUDE + " TEXT, "
                + Params.KEY_SERVICE_OFFER + " TEXT, "
                + Params.KEY_SHOP_TYPE + " TEXT" + ")";
        Log.d("MyTag", "onCreate: DB Created... " + create);

        String latLang = "CREATE TABLE " + Params.LATLANG_TABLE + "("
                + Params.KEY_ID + " INTEGER PRIMARY KEY, "
                + Params.KEY_SHOP_NAME + " TEXT, "
                + Params.KEY_LATITUDE + " TEXT, "
                + Params.KEY_LONGITUDE + " TEXT" + ")";
        Log.d("MyTag", "onCreate: DB Created... " + latLang);

        db.execSQL(create);
        db.execSQL(latLang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addUser(UserForm userForm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues formValues = new ContentValues();
        ContentValues latLangValues = new ContentValues();

        formValues.put(Params.KEY_NAME, userForm.getFullName());
        formValues.put(Params.KEY_CNIC, userForm.getCnic());
        formValues.put(Params.KEY_PHONE, userForm.getPhoneNumber());
        formValues.put(Params.KEY_SHOP_AREA, userForm.getShopArea());
        formValues.put(Params.KEY_SHOP_NAME, userForm.getShopName());
        formValues.put(Params.KEY_SHOP_ADDRESS, userForm.getShopAddress());
        formValues.put(Params.KEY_WORKING_HOURS, userForm.getWorkingHours());
        formValues.put(Params.KEY_EMAIL_ADDRESS, userForm.getEmailAddress());
        formValues.put(Params.KEY_LATITUDE, userForm.getLatitude());
        formValues.put(Params.KEY_LONGITUDE, userForm.getLongitude());
        formValues.put(Params.KEY_SERVICE_OFFER, userForm.getServiceOffer());
        formValues.put(Params.KEY_SHOP_TYPE, userForm.getShopType());

        latLangValues.put(Params.KEY_LATITUDE, userForm.getLatitude());
        latLangValues.put(Params.KEY_LONGITUDE, userForm.getLongitude());
        latLangValues.put(Params.KEY_SHOP_NAME, userForm.getShopName());

        db.insert(Params.Form_TABLE, null, formValues);
        db.insert(Params.LATLANG_TABLE, null, latLangValues);
        Log.d("MyTag", "SuccessFully Inserted");
        db.close();
    }

    public List<UserForm> getAllUser(){
        List<UserForm> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //Query
        String select = "SELECT * FROM " + Params.Form_TABLE;
        Cursor cursor = db.rawQuery(select, null);

        if(cursor.moveToNext()){
            do {
                UserForm userForm = new UserForm();
                userForm.setFullName(cursor.getString(1));
                userForm.setShopName(cursor.getString(5));
                userForm.setShopAddress(cursor.getString(6));
                userForm.setPhoneNumber(cursor.getString(3));
                userList.add(userForm);
            }
            while (cursor.moveToNext());
        }
        return userList;
    }


    public List<UserForm> getAllLatLang(){
        List<UserForm> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //Query
        String select = "SELECT * FROM " + Params.LATLANG_TABLE;
        Cursor cursor = db.rawQuery(select, null);

        if(cursor.moveToNext()){
            do {
                UserForm userForm = new UserForm();
                userForm.setShopName(cursor.getString(1));
                userForm.setLatitude(cursor.getString(2));
                userForm.setLongitude(cursor.getString(3));

                userList.add(userForm);
            }
            while (cursor.moveToNext());
        }
        return userList;
    }
}
