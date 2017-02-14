package com.example.joseris.apptaxi.Interfaces;

import com.example.joseris.apptaxi.Modelos.Request.RequesLogin;
import com.example.joseris.apptaxi.Modelos.Request.RequesLoginDatos;
import com.example.joseris.apptaxi.Modelos.Request.RequestCrearUsuario;
import com.example.joseris.apptaxi.Modelos.Responses.Example;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseRegistroUsuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Eukaris on 14/2/2017.
 */

public interface InterLogin{
    @POST("login")
    Call<Example> ingresarLogin(@Body RequesLoginDatos request);
}
