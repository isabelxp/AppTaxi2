package com.example.joseris.apptaxi;

/**
 * Created by Joseris on 16/02/2017.
 */

public class ClassInformacionUsuarioRegistro {
    private String ci;
    private String password;
    private String name;
    private String phone;
    private Integer inCne;
    private String email;
    private String role;
    private Integer photo;
    private Integer ciPhoto;

    @Override
    public String toString() {
        return "ClassInformacionUsuarioRegistro{" +
                "ci='" + ci + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", inCne=" + inCne +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", photo=" + photo +
                ", ciPhoto=" + ciPhoto +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setInCne(Integer inCne) {
        this.inCne = inCne;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public void setCiPhoto(Integer ciPhoto) {
        this.ciPhoto = ciPhoto;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getCi() {
        return ci;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getInCne() {
        return inCne;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public Integer getPhoto() {
        return photo;
    }

    public Integer getCiPhoto() {
        return ciPhoto;
    }
}
