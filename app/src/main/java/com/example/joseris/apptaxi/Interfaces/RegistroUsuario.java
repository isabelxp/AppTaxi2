package com.example.joseris.apptaxi.Interfaces;

import com.example.joseris.apptaxi.Modelos.Request.RequestCrearUsuario;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseRegistroUsuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Joseris on 04/02/2017.
 */

public interface RegistroUsuario {

    @POST("register")
    Call<ResponseRegistroUsuario> registroUsuario(@Body RequestCrearUsuario request);

}

