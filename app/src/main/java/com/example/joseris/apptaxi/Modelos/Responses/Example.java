
package com.example.joseris.apptaxi.Modelos.Responses;

import android.accounts.Account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class Example {

    @SerializedName("success")
    @Expose
    private JSONObject success;
    @SerializedName("account")
    @Expose
    private JSONObject account;

    public JSONObject getSuccess() {
        return success;
    }

    public void setSuccess(JSONObject success) {
        this.success = success;
    }

    public JSONObject getAccount() {
        return account;
    }

    public void setAccount(JSONObject account) {
        this.account = account;
    }

}
