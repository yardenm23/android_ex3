package com.example.androidex2.model;

public class Student {
    String name;
    String id;
    String avatarUrl;
    String phone;
    String address;
    Boolean checkBox;
    String year ="2023";
    String mounth = "01";
    String day = "01";

    public Student(String name, String id, String avatarUrl, String phone, String address, Boolean checkBox, String year) {
        this.name = name;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.phone = phone;
        this.address = address;
        this.checkBox = checkBox;
        this.year=year;
        this.mounth=mounth;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Boolean getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(Boolean checkBox) {
        this.checkBox = checkBox;
    }

    public String getPhone() { return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

//    public String getYear() {return year;}
//
//    public void setYear(String year) {this.year = year;}
//
//    public String getMounth() {return mounth;}
//
//    public void setMounth(String mounth) {this.mounth = mounth;}
//
//    public String getDay() {return day;}
//
//    public void setDay(String day) {this.day = day;}

    public String getBirthDate() {return "" + day + "/" + mounth + "/" + year;}


}
