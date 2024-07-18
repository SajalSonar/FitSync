package com.example.finalfitnessmad;

public class Users {
    public String userName;
    public String age;
    public String sap;

    public Users(String userName, String age, String sap) {
        this.userName = userName;
        this.age = age;
        this.sap = sap;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSap() {
        return sap;
    }

    public void setSap(String sap) {
        this.sap = sap;
    }
}
