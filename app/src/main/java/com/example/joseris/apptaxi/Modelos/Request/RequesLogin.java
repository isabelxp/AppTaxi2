
package com.example.joseris.apptaxi.Modelos.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequesLogin {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("ci")
    @Expose
    private String ci;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("in_cne")
    @Expose
    private String inCne;
    @SerializedName("is_active")
    @Expose
    private String isActive;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;
    @SerializedName("registration_date")
    @Expose
    private String registrationDate;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("photo_ci")
    @Expose
    private String photoCi;
    @SerializedName("is_valid_ci")
    @Expose
    private String isValidCi;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("is_first_login")
    @Expose
    private Boolean isFirstLogin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInCne() {
        return inCne;
    }

    public void setInCne(String inCne) {
        this.inCne = inCne;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhotoCi() {
        return photoCi;
    }

    public void setPhotoCi(String photoCi) {
        this.photoCi = photoCi;
    }

    public String getIsValidCi() {
        return isValidCi;
    }

    public void setIsValidCi(String isValidCi) {
        this.isValidCi = isValidCi;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsFirstLogin() {
        return isFirstLogin;
    }

    public void setIsFirstLogin(Boolean isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

}
