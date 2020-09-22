package com.example.prototype;

public class Users {
    public  String fullname;
    public  String phoneNum;
    public  String emailaddress;
    public  String password;


    public Users(){};

    public Users(String fullname, String phoneNum, String emailaddress, String password) {
        this.fullname = fullname;
        this.phoneNum = phoneNum;
        this.emailaddress = emailaddress;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
