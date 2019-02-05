package com.kalela.philipkalela.newstock.feature.all_users_dashboard.model;

import com.google.gson.annotations.SerializedName;

public class Users {
    private int id;

    @SerializedName("username")
    private String username;

    @SerializedName("govt_name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

    @SerializedName("password")
    private String password;

    @SerializedName("date_joined")
    private String dateJoined;

    public int getId() {
        return id;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public String getUsername() {
        return username;
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

    public String getPassword() {
        return password;
    }

}
