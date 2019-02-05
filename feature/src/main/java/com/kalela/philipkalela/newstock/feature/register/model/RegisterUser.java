package com.kalela.philipkalela.newstock.feature.register.model;

import com.google.gson.annotations.SerializedName;

public class RegisterUser {

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

    @SerializedName("confirmPassword")
    private String confirmPassword;

    public RegisterUser(String username, String name, String email, String phone, String password, String confirmPassword) {
        setUsername(username);
        setName(name);
        setEmail(email);
        setPhone(phone);
        setPassword(password);
        setConfirmPassword(confirmPassword);

    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setPassword(String password) {
        this.password = password;
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

    public static class Builder {
        private String username;
        private String name;
        private String email;
        private String phone;
        private String password;
        private String confirmPassword;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public RegisterUser build() {
            return new RegisterUser(username, name, email, phone, password, confirmPassword);
        }
    }

}
