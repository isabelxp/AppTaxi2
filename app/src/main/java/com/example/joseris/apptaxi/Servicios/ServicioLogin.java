package com.example.joseris.apptaxi.Servicios;

import android.util.Log;

import com.example.joseris.apptaxi.Interfaces.InterLogin;
import com.example.joseris.apptaxi.Interfaces.RegistroUsuario;
import com.example.joseris.apptaxi.Modelos.Request.RequesLogin;
import com.example.joseris.apptaxi.Modelos.Request.RequesLoginDatos;
import com.example.joseris.apptaxi.Modelos.Request.RequestCrearUsuario;
import com.example.joseris.apptaxi.Modelos.Responses.Example;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseRegistroUsuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eukaris on 14/2/2017.
 */

public class ServicioLogin {


    public void UsuarioLogin(RequesLoginDatos requestlogindatos)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apptaxi.esy.es/API/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterLogin service=retrofit.create(InterLogin.class);
        Call<Example> call=service.ingresarLogin(requestlogindatos);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                if (response.isSuccessful()) {
                   // Log.e("Login", ":" + call.request().body());
                    Log.e("Nombre", ":" + response.body().getSuccess());
                }else
                {
                    Log.e("No Login", "------");
                    Log.e("No Login", "------"+ call.request().url().toString());
                }
            }
            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("Error base datos", "------"+ t);
            }
        });

    }
}
