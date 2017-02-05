package com.example.joseris.apptaxi.Interfaces;

import com.example.joseris.apptaxi.ClasesBasedeDatos.Account;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Joseris on 04/02/2017.
 */

public interface RegistroUsuario {
    @FormUrlEncoded
    @POST("api/register")
    Call<Account> RegistroUsuario(@Field("email") String email,
                                  @Field("name") String name,
                                  @Field("phone") String phone,
                                  @Field("ci") int ci,
                                  @Field("inCne") String inCne,
                                  @Field("role") String role);
}

