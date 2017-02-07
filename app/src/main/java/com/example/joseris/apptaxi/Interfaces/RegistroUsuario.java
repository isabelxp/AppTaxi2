package com.example.joseris.apptaxi.Interfaces;

import com.example.joseris.apptaxi.Modelos.RegistroUsuario.Account;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Joseris on 04/02/2017.
 */

public interface RegistroUsuario {
    @FormUrlEncoded
    @POST("register")
    Call<Account> RegistroUsuario(@Field("ci") String ci,
                                  @Field("name") String name,
                                  @Field("phone") String phone,
                                  @Field("inCne") String inCne,
                                  @Field("isActive") int isActive,
                                  @Field("role") String role,
                                  @Field("lastLogin") String lastLogin,
                                  @Field("registrationDate") String registrationDate,
                                  @Field("email") String email,
                                  @Field("photo") int photo,
                                  @Field("ciPhoto") int ciPhoto);

}

