package com.util.beans;

/**
 * Created by govinb2 on 06-09-2015.
 */
public class Retailer {

    String retailId;
    String firstname;
    String lastname;
    String DOB;
    String gender;
    String mobileno;
    String emailid;
    String address;
    String city;
    String pincode;
    Login login=new Login();
    String imagePOI1,imagePOI2;
    String imagePOA1,imagePOA2;
    String sign_image,retailerPhoto;
    Boolean isVerified;
    String preferredDistributorid;
    Store store=new Store();

    public String getRetailId() {
        return retailId;
    }

    public void setRetailId(String retailId) {
        this.retailId = retailId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getImagePOI1() {
        return imagePOI1;
    }

    public void setImagePOI1(String imagePOI1) {
        this.imagePOI1 = imagePOI1;
    }

    public String getImagePOI2() {
        return imagePOI2;
    }

    public void setImagePOI2(String imagePOI2) {
        this.imagePOI2 = imagePOI2;
    }

    public String getImagePOA1() {
        return imagePOA1;
    }

    public void setImagePOA1(String imagePOA1) {
        this.imagePOA1 = imagePOA1;
    }

    public String getImagePOA2() {
        return imagePOA2;
    }

    public void setImagePOA2(String imagePOA2) {
        this.imagePOA2 = imagePOA2;
    }

    public String getSign_image() {
        return sign_image;
    }

    public void setSign_image(String sign_image) {
        this.sign_image = sign_image;
    }

    public String getRetailerPhoto() {
        return retailerPhoto;
    }

    public void setRetailerPhoto(String retailerPhoto) {
        this.retailerPhoto = retailerPhoto;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getPreferredDistributorid() {
        return preferredDistributorid;
    }

    public void setPreferredDistributorid(String preferredDistributorid) {
        this.preferredDistributorid = preferredDistributorid;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
