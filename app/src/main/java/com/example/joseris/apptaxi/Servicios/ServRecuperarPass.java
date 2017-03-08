package com.example.joseris.apptaxi.Servicios;

import android.content.Context;
import android.util.Log;

import com.example.joseris.apptaxi.InterComuni.InterRecuperarContra;
import com.example.joseris.apptaxi.Interfaces.InterRecuperarPass;
import com.example.joseris.apptaxi.Modelos.Request.RequestRecuperarPass;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseRecuperarPass;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eukaris on 6/3/2017.
 */

public class ServRecuperarPass {
    InterRecuperarContra inter;

    public ServRecuperarPass(RequestRecuperarPass requestRecuperarPass, Context context){
        inter= (InterRecuperarContra) context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apptaxi.esy.es/API/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterRecuperarPass service = retrofit.create(InterRecuperarPass.class);
        Call<ResponseRecuperarPass> call = service.recuperarPass(requestRecuperarPass);
        call.enqueue(new Callback<ResponseRecuperarPass>() {
            @Override
            public void onResponse(Call<ResponseRecuperarPass> call, Response<ResponseRecuperarPass> response) {

                if (response.isSuccessful()) {

                    inter.showMessage();

                    Log.e("Recuperado", ":" + new Gson().toJson(response.body()));
                }else
                {
                    inter.showMessageError();
                    Log.e("No recuperado", "------");
                }
            }

            @Override
            public void onFailure(Call<ResponseRecuperarPass> call, Throwable t) {
                Log.e("Error base datos", "------"+ t);
            }
        });
    }

}
