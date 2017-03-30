package com.example.joseris.apptaxi.Modelos.Responses;

import android.accounts.Account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andy on 10/03/2017.
 */

public class ResponseRegistroDriver {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("driver_service")
    @Expose
    private Account account;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
