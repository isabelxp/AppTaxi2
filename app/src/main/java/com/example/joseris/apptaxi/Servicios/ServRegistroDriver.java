package com.example.joseris.apptaxi.Servicios;

import android.util.Log;

import com.example.joseris.apptaxi.Interfaces.InterRegistroDriver;
import com.example.joseris.apptaxi.Interfaces.RegistroUsuario;
import com.example.joseris.apptaxi.Modelos.Request.RequestRegistroDriver;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseRegistroDriver;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseRegistroUsuario;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andy on 10/03/2017.
 */

public class ServRegistroDriver {
    public ServRegistroDriver(){}

    public void registrarDriver(RequestRegistroDriver requestRegistroDriver){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apptaxi.esy.es/API/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterRegistroDriver service=retrofit.create(InterRegistroDriver.class);
        Call<ResponseRegistroDriver> call=service.registroDriver(requestRegistroDriver);
        call.enqueue(new Callback<ResponseRegistroDriver>() {
            @Override
            public void onResponse(Call<ResponseRegistroDriver> call, Response<ResponseRegistroDriver> response) {

                if (response.isSuccessful()) {
                    Log.e("Registro exitoso", ":" + new Gson().toJson(response.body()));
                }else
                {
                    Log.e("No Registro", "------");

                }
            }

            @Override
            public void onFailure(Call<ResponseRegistroDriver> call, Throwable t) {
                Log.e("Error base datos", "------"+ t);
            }
        });
    }
}
