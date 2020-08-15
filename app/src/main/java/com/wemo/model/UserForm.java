package com.wemo.model;

import android.content.ContentValues;

import com.wemo.database.UserFormTable;

import java.util.UUID;

public class UserForm {

    private String id;
    private String fullName;
    private String cnic;
    private String phoneNum;
    private String shopArea;
    private String shopName;
    private String shopAddress;
    private String workingHours;
    private String serviceOffering;
    private String emailAddress;
    private String shopLat;
    private String shopLang;
    private String shopType;


    public UserForm(){
    }

    public UserForm(String id,
                    String fullName,
                    String cnic,
                    String phoneNum,
                    String shopArea,
                    String shopName,
                    String shopAddress,
                    String workingHours,
                    String serviceOffering,
                    String emailAddress,
                    String shopLat,
                    String shopLang,
                    String shopType) {

        if(id == null){
            id = UUID.randomUUID().toString();
        }

        this.id = id;
        this.fullName = fullName;
        this.cnic = cnic;
        this.phoneNum = phoneNum;
        this.shopArea = shopArea;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.workingHours = workingHours;
        this.serviceOffering = serviceOffering;
        this.emailAddress = emailAddress;
        this.shopLat = shopLat;
        this.shopLang = shopLang;
        this.shopType = shopType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getShopArea() {
        return shopArea;
    }

    public void setShopArea(String shopArea) {
        this.shopArea = shopArea;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getServiceOffering() {
        return serviceOffering;
    }

    public void setServiceOffering(String serviceOffering) {
        this.serviceOffering = serviceOffering;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getShopLat() {
        return shopLat;
    }

    public void setShopLat(String shopLat) {
        this.shopLat = shopLat;
    }

    public String getShopLang() {
        return shopLang;
    }

    public void setShopLang(String shopLang) {
        this.shopLang = shopLang;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public ContentValues getValues(){
        ContentValues contentValues = new ContentValues(13);
        contentValues.put(UserFormTable.COLUMN_ID, this.id);
        contentValues.put(UserFormTable.COLUMN_FULL_NAME, this.fullName);
        contentValues.put(UserFormTable.COLUMN_CNIC, this.cnic);
        contentValues.put(UserFormTable.COLUMN_PONE_NUM, this.phoneNum);
        contentValues.put(UserFormTable.COLUMN_SHOP_AREA, this.shopArea);
        contentValues.put(UserFormTable.COLUMN_SHOP_NAME, this.shopName);
        contentValues.put(UserFormTable.COLUMN_SHOP_ADDRESS, this.shopAddress);
        contentValues.put(UserFormTable.COLUMN_WORKING_HOURS, this.workingHours);
        contentValues.put(UserFormTable.COLUMN_SERVICE_OFFERING, this.serviceOffering);
        contentValues.put(UserFormTable.COLUMN_EMAIL_ADDRESS, this.emailAddress);
        contentValues.put(UserFormTable.COLUMN_SHOP_LATITUDE, this.shopLat);
        contentValues.put(UserFormTable.COLUMN_SHOP_LONGITUDE, this.shopLang);
        contentValues.put(UserFormTable.COLUMN_SHOP_TYPE, this.shopType);

        return contentValues;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", cnic='" + cnic + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", shopArea='" + shopArea + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", workingHours='" + workingHours + '\'' +
                ", serviceOffering='" + serviceOffering + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", shopLat='" + shopLat + '\'' +
                ", shopLang='" + shopLang + '\'' +
                ", shopType='" + shopType + '\'' +
                '}';
    }
}
