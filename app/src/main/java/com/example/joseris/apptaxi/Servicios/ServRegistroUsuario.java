package com.example.joseris.apptaxi.Servicios;

import android.util.Log;

import com.example.joseris.apptaxi.Interfaces.RegistroUsuario;
import com.example.joseris.apptaxi.Modelos.RegistroUsuario.Account;
import com.example.joseris.apptaxi.Modelos.RegistroUsuario.ModeloRegistroUsuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

/**
 * Created by Joseris on 04/02/2017.
 */

public class ServRegistroUsuario {

    public void Registrar_usurario(String email, String name, String telefono, int ci, String icn, String role, int isActive, String lastLogin,String registrationDate, int photo, int ciPhoto)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apptaxi.esy.es/API/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegistroUsuario service=retrofit.create(RegistroUsuario.class);

        Call<ModeloRegistroUsuario> call=service.RegistroUsuario("v25274878","joseris","0412","1",1,"pasajero", "1", "06" ,"isabel.indriago23@gmail.com",1, 1);
        call.enqueue(new Callback<ModeloRegistroUsuario>() {
            @Override
            public void onResponse(Call<ModeloRegistroUsuario> call, Response<ModeloRegistroUsuario> response) {
                if (response.isSuccessful()) {
                    Log.e("Registro", ":" + call.request().url().toString());
                }else
                {
                   Log.e("No Registro", "------");

                }
            }

            @Override
            public void onFailure(Call<ModeloRegistroUsuario> call, Throwable t) {
                Log.e("Error base datos", "------"+ t);
            }
        });

    }
}
