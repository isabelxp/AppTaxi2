package com.example.joseris.apptaxi.Modelos.Responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andy on 01/03/2017.
 */

public class ResponseRecuperarPass {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("description")
    @Expose
    private String description;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
