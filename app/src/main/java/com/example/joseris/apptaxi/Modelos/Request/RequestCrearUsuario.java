package com.example.joseris.apptaxi.Modelos.Request;

/**
 * Created by hector on 06/02/17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestCrearUsuario {
    @SerializedName("ci")
    @Expose
    private String ci;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("in_cne")
    @Expose
    private Integer inCne;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("photo")
    @Expose
    private Integer photo;
    @SerializedName("ci_photo")
    @Expose
    private Integer ciPhoto;

    public RequestCrearUsuario() {
    }

    public RequestCrearUsuario(String ci, String password, String name, String phone, Integer inCne, String email, String role, Integer photo, Integer ciPhoto) {
        this.ci = ci;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.inCne = inCne;
        this.email = email;
        this.role = role;
        this.photo = photo;
        this.ciPhoto = ciPhoto;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getInCne() {
        return inCne;
    }

    public void setInCne(Integer inCne) {
        this.inCne = inCne;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public Integer getCiPhoto() {
        return ciPhoto;
    }

    public void setCiPhoto(Integer ciPhoto) {
        this.ciPhoto = ciPhoto;
    }

}