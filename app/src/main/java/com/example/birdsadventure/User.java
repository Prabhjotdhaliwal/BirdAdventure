package com.example.birdsadventure;

public class User
{
    private  int userID;
    private String name;
    private  String email;
    private String phone;
    private  String address;
    private  String city;
    private  String province;
    private  String country;
    private  String postalcode;
    private boolean status;

    //constructors
    public User()
    {
    }

    public User(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public User(int userID, String name, String email, String phone, String address, String city, String province, String country, String postalcode, boolean status) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalcode = postalcode;
        this.status = status;
    }



    //Getters
    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public boolean isStatus() {
        return status;
    }


    //Setters
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
