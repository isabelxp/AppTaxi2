package com.example.joseris.apptaxi.Servicios;

import android.util.Log;

import com.example.joseris.apptaxi.Interfaces.RegistroUsuario;
import com.example.joseris.apptaxi.Modelos.Request.RequestCrearUsuario;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseRegistroUsuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Joseris on 04/02/2017.
 */

public class ServRegistroUsuario {

    public void registrarUsuario(RequestCrearUsuario requestCrearUsuario)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apptaxi.esy.es/API/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegistroUsuario service=retrofit.create(RegistroUsuario.class);
        Call<ResponseRegistroUsuario> call=service.registroUsuario(requestCrearUsuario);
        call.enqueue(new Callback<ResponseRegistroUsuario>() {
            @Override
            public void onResponse(Call<ResponseRegistroUsuario> call, Response<ResponseRegistroUsuario> response) {

                if (response.isSuccessful()) {
                    Log.e("Registro", ":" + call.request().url().toString());
                }else
                {
                   Log.e("No Registro", "------");

                }
            }

            @Override
            public void onFailure(Call<ResponseRegistroUsuario> call, Throwable t) {
                Log.e("Error base datos", "------"+ t);
            }
        });

    }
}
