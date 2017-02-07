package com.example.joseris.apptaxi.Interfaces;

import com.example.joseris.apptaxi.Modelos.Account;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Joseris on 04/02/2017.
 */

public interface RegistroUsuario {
    @POST("register")
    Call<Account> RegistroUsuario(@Body Account acont);
}

