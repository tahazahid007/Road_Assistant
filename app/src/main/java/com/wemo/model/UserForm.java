package com.wemo.model;

import java.util.List;

public class UserForm {

    private int id;
    private String fullName;
    private String cnic;
    private String phoneNumber;
    private String shopArea;
    private String shopName;
    private String shopAddress;
    private String workingHours;
    private String emailAddress;
    private String latitude;
    private String longitude;
    private String serviceOffer;
    private String shopType;

    public UserForm(int id, String fullName, String cnic, String phoneNumber, String shopArea, String shopName, String shopAddress, String workingHours, String emailAddress, String latitude, String longitude, String serviceOffer, String shopType) {
        this.id = id;
        this.fullName = fullName;
        this.cnic = cnic;
        this.phoneNumber = phoneNumber;
        this.shopArea = shopArea;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.workingHours = workingHours;
        this.emailAddress = emailAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.serviceOffer = serviceOffer;
        this.shopType = shopType;
    }

    public UserForm(String fullName, String cnic, String phoneNumber, String shopArea, String shopName, String shopAddress, String workingHours, String emailAddress, String latitude, String longitude, String serviceOffer, String shopType) {
        this.fullName = fullName;
        this.cnic = cnic;
        this.phoneNumber = phoneNumber;
        this.shopArea = shopArea;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.workingHours = workingHours;
        this.emailAddress = emailAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.serviceOffer = serviceOffer;
        this.shopType = shopType;
    }

    public UserForm(String fullName, String shopName, String shopAddress){
        this.fullName = fullName;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
    }

    public UserForm(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getServiceOffer() {
        return serviceOffer;
    }

    public void setServiceOffer(String serviceOffer) {
        this.serviceOffer = serviceOffer;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }
}
