package com.example.joseris.apptaxi.Servicios;

import android.util.Log;

import com.example.joseris.apptaxi.Interfaces.RegistroUsuario;
import com.example.joseris.apptaxi.Modelos.Account;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        Account acont=new Account("v25275254","joseris","0412","1",1,"pasajero", "1", "06" ,"isabel_indriago23@hotmail.com",15,33, 14);
        Call<Account> call=service.RegistroUsuario(acont);
        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if (response.isSuccessful()) {
                    Log.e("Registro", ":" + call.request().url().toString());
                }else
                {
                   Log.e("No Registro", "------" );
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Log.e("Error base datos", "------"+ t);
            }
        });

    }
}
