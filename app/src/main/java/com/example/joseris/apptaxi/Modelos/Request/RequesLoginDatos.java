package com.example.joseris.apptaxi.Modelos.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Eukaris on 14/2/2017.
 */

public class RequesLoginDatos {
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("firebase_token")
    @Expose
    private String firebase_token;


    public RequesLoginDatos(String email,  String password, String firebase_token) {
        this.email = email;
        this.password = password;
        this.firebase_token = firebase_token;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirebase_token(String firebase_token) {
        this.firebase_token = firebase_token;
    }

    public String getPassword() {
        return password;
    }

    public String getFirebase_token() {
        return firebase_token;
    }

    public String getEmail() {
        return email;
    }
}

