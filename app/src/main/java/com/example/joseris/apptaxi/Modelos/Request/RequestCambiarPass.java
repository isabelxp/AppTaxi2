package com.example.joseris.apptaxi.Modelos.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andy on 01/03/2017.
 */

public class RequestCambiarPass {
    @SerializedName("old_password")
    @Expose
    private String old_password;
    @SerializedName("new_password")
    @Expose
    private String new_password;

    private String token;

    public RequestCambiarPass(String old_password, String new_password, String token){
        this.old_password = old_password;
        this.new_password = new_password;
        this.token = token;
    }

    public String getOld_password(){
        return this.old_password;
    }

    public String getNew_password(){
        return this.new_password;
    }

    public String getToken(){
        return this.token;
    }
}
