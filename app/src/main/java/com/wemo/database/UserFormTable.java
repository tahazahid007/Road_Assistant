package com.wemo.database;

public class UserFormTable {

    public static final String TABLE_USER_FORM = "userForm";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FULL_NAME = "fullName";
    public static final String COLUMN_CNIC = "cnic";
    public static final String COLUMN_PONE_NUM = "phoneNum";
    public static final String COLUMN_SHOP_AREA = "shopArea";
    public static final String COLUMN_SHOP_NAME = "shopName";
    public static final String COLUMN_SHOP_ADDRESS = "shopAddress";
    public static final String COLUMN_WORKING_HOURS = "workingHours";
    public static final String COLUMN_SERVICE_OFFERING = "serviceOffering";
    public static final String COLUMN_EMAIL_ADDRESS = "emailAddress";
    public static final String COLUMN_SHOP_LATITUDE = "shopLat";
    public static final String COLUMN_SHOP_LONGITUDE = "shopLang";
    public static final String COLUMN_SHOP_TYPE = "shopType";

    public static final String SQL_CREATE =
            "CREATE TABLE " +
                    TABLE_USER_FORM + "(" +
                    COLUMN_ID + "TEXT PRIMARY KEY," +
                    COLUMN_FULL_NAME + "TEXT ," +
                    COLUMN_CNIC + "TEXT ," +
                    COLUMN_PONE_NUM + "TEXT ," +
                    COLUMN_SHOP_AREA + "TEXT ," +
                    COLUMN_SHOP_NAME + "TEXT ," +
                    COLUMN_SHOP_ADDRESS + "TEXT ," +
                    COLUMN_WORKING_HOURS + "TEXT ," +
                    COLUMN_SERVICE_OFFERING + "TEXT ," +
                    COLUMN_EMAIL_ADDRESS + "TEXT ," +
                    COLUMN_SHOP_LATITUDE + "TEXT ," +
                    COLUMN_SHOP_LONGITUDE + "TEXT ," +
                    COLUMN_SHOP_TYPE + "TEXT);";

    public static final String SQL_DELETE =
            "DROP TABLE IF EXISTS " + TABLE_USER_FORM;
}
