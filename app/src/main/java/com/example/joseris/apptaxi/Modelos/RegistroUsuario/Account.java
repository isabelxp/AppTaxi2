
package com.example.joseris.apptaxi.Modelos.RegistroUsuario;


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
    @SerializedName("inCne")
    @Expose
    private String inCne;
    @SerializedName("isActive")
    @Expose
    private Integer isActive;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("lastLogin")
    @Expose
    private String lastLogin;
    @SerializedName("registrationDate")
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
    @SerializedName("ciPhoto")
    @Expose
    private Integer ciPhoto;

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
