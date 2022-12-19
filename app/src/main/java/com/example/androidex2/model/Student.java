package com.example.androidex2.model;

public class Student {
    String name;
    String id;
    String avatarUrl;
    Boolean checkBox;

    public Student(String name, String id, String avatarUrl, Boolean checkBox) {
        this.name = name;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.checkBox = checkBox;
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
}
