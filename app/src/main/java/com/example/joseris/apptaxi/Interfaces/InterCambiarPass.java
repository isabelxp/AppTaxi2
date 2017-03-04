package com.example.joseris.apptaxi.Interfaces;

import com.example.joseris.apptaxi.Modelos.Request.RequestCambiarPass;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseCambiarPass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Andy on 01/03/2017.
 */

public interface InterCambiarPass {

    @POST("change_password")
    Call<ResponseCambiarPass> cambiarPass(
            @Body RequestCambiarPass requestCambiarPass
    );
}
