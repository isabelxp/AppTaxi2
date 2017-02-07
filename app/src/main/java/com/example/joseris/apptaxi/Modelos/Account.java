
package com.example.joseris.apptaxi.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("ci")
    @Expose
    private String ci;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("in_cne")
    @Expose
    private String inCne;
    @SerializedName("is_active")
    @Expose
    private Integer isActive;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;
    @SerializedName("registration_date")
    @Expose
    private String registrationDate;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("photo")
    @Expose
    private Integer photo;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ci_photo")
    @Expose
    private Integer ciPhoto;

    public Account(String name, String ci, String phone, String inCne, Integer isActive, String role, String lastLogin, String registrationDate, String email, Integer photo, Integer ciPhoto, Integer id) {
        this.name = name;
        this.ci = ci;
        this.phone = phone;
        this.inCne = inCne;
        this.isActive = isActive;
        this.role = role;
        this.lastLogin = lastLogin;
        this.registrationDate = registrationDate;
        this.email = email;
        this.photo = photo;
        this.ciPhoto = ciPhoto;
        this.id = id;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCiPhoto() {
        return ciPhoto;
    }

    public void setCiPhoto(Integer ciPhoto) {
        this.ciPhoto = ciPhoto;
    }

}
