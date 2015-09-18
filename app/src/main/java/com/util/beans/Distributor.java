package com.util.beans;

/**
 * Created by govinb2 on 06-09-2015.
 */
public class Distributor {

    String distributorid;
    String name;
    String address;
    String City;
    String pincode;
    String mobileno;
    String emailid;
    String phoneIMENo;
    String comments;
    Login login = new Login();

    public Distributor(){
        login = new Login();
    }
    public String getDistributorid() {
        return distributorid;
    }

    public void setDistributorid(String distributorid) {
        this.distributorid = distributorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPhoneIMENo() {
        return phoneIMENo;
    }

    public void setPhoneIMENo(String phoneIMENo) {
        this.phoneIMENo = phoneIMENo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }



    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }


}
