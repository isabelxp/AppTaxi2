package com.example.joseris.apptaxi.Servicios;

import android.content.Intent;
import android.util.Log;

import com.example.joseris.apptaxi.FragmnetsRegistroUsuario.Actividad_principalTaxi;
import com.example.joseris.apptaxi.Interfaces.InterLogin;
import com.example.joseris.apptaxi.Interfaces.RegistroUsuario;
import com.example.joseris.apptaxi.Login;
import com.example.joseris.apptaxi.Modelos.Request.RequesLogin;
import com.example.joseris.apptaxi.Modelos.Request.RequesLoginDatos;
import com.example.joseris.apptaxi.Modelos.Request.RequestCrearUsuario;
import com.example.joseris.apptaxi.Modelos.Responses.Example;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseRegistroUsuario;
import com.example.joseris.apptaxi.R;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eukaris on 14/2/2017.
 */

public class ServicioLogin {
public boolean loginTrue;

    public boolean isLoginTrue() {
        return loginTrue;
    }

    public void setLoginTrue(boolean loginTrue) {
        this.loginTrue = loginTrue;
    }

    public void UsuarioLogin(RequesLoginDatos requestlogindatos)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apptaxi.esy.es/API/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterLogin service=retrofit.create(InterLogin.class);
        Call<Example> call=service.ingresarLogin (requestlogindatos);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                if (response.isSuccessful()) {
                   // Log.e("Login", ":" + call.request().body());
                    Gson gson=new Gson();
                    gson.toJson(response.body());
                    Log.e("Login Exito", ":" +  gson.toJson(response.body()));

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
