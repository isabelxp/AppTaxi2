package com.example.joseris.apptaxi.Servicios;

import android.util.Log;
import android.widget.Toast;

import com.example.joseris.apptaxi.ClasesBasedeDatos.Account;
import com.example.joseris.apptaxi.ClasesBasedeDatos.RegistroUsuarioDatos;
import com.example.joseris.apptaxi.Interfaces.RegistroUsuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Joseris on 04/02/2017.
 */

public class ServRegistroUsuario {

    public void Registrar_usurario(String email, String name, String telefono, int ci, String icn, String role)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.instant.com.ve/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegistroUsuario service=retrofit.create(RegistroUsuario.class);

        Call<Account> call=service.RegistroUsuario(email,name,telefono,ci,icn,role);
        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if (response.isSuccessful()) {
                    Log.e("Registro", ":" + call.request().url().toString());
                }else
                {
                    Log.e("No Registro", "------"+ call.request().url().toString());
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Log.e("Error base datos", "------"+ t);
            }
        });

    }
}
