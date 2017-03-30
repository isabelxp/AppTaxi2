package com.example.joseris.apptaxi.Interfaces;

import com.example.joseris.apptaxi.Modelos.Responses.ResponseRegistroDriver;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseRegistroUsuario;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * Created by Andy on 10/03/2017.
 */

public interface InterRegistroDriver {
    @Multipart
    @POST("driver/register")
    Call<ResponseRegistroDriver> registroDriver(
            @PartMap Map<String, RequestBody> params
    );
}
