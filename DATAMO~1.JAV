package com.example.assignment7;

public class DataModel {
    private String user;
    private String email;
    private String value;

    public DataModel(String user, String email, String value) {
        this.user = user;
        this.email = email;
        this.value = value;
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getValue() {
        return value;
    }
}
