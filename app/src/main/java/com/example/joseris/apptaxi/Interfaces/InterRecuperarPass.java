package com.example.joseris.apptaxi.Interfaces;

import com.example.joseris.apptaxi.Modelos.Request.RequestRecuperarPass;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseRecuperarPass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Andy on 01/03/2017.
 */

public interface InterRecuperarPass {

    @POST("forgot_password")
    Call<ResponseRecuperarPass> recuperarPass(
            @Body RequestRecuperarPass requestRecuperarPass
    );
}
