package com.example.joseris.apptaxi.Modelos.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Eukaris on 6/3/2017.
 */

public class RequestRecuperarPass {
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("ci")
    @Expose
    private String ci;

    public RequestRecuperarPass(String email, String ci){
        this.email = email;
        this.ci = ci;
    }

    public String getEmail(){
        return this.email;
    }

    public String getCi(){
        return this.ci;
    }
}
