package com.iqOption.client;

public class Client {
    //Obligatory fields for Rest request
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String tz;

    //Not obligatory fields for Rest request
    private String gender;
    private String isDemo;
    private String phoneCode;
    private String phone;
    private String autoActivation;
    private String googleClientId;
    private String socialId;
    private String userSocialId;
    private String token;
    private String currencyId;

    public Client(String email, String password, String firstName, String lastName, String tz) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tz = tz;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIsDemo(String isDemo) {
        this.isDemo = isDemo;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAutoActivation(String autoActivation) {
        this.autoActivation = autoActivation;
    }

    public void setGoogleClientId(String googleClientId) {
        this.googleClientId = googleClientId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public void setUserSocialId(String userSocialId) {
        this.userSocialId = userSocialId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTz() {
        return tz;
    }

    public String getGender() {
        return gender;
    }

    public String getIsDemo() {
        return isDemo;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getAutoActivation() {
        return autoActivation;
    }

    public String getGoogleClientId() {
        return googleClientId;
    }

    public String getSocialId() {
        return socialId;
    }

    public String getUserSocialId() {
        return userSocialId;
    }

    public String getToken() {
        return token;
    }

    public String getCurrencyId() {
        return currencyId;
    }
}
