package com.example.joseris.apptaxi.Interfaces;

import com.example.joseris.apptaxi.Modelos.Responses.ResponseRegistroUsuario;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * Created by Joseris on 04/02/2017.
 */

public interface RegistroUsuario {

    @Multipart
    @POST("register")
    Call<ResponseRegistroUsuario> registroUsuario(
            @PartMap Map<String, RequestBody> params
    );
}

