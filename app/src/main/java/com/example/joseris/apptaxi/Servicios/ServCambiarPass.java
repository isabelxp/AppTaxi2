package com.example.joseris.apptaxi.Servicios;

import android.util.Log;

import com.example.joseris.apptaxi.Interfaces.InterCambiarPass;
import com.example.joseris.apptaxi.Modelos.Request.RequestCambiarPass;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseCambiarPass;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andy on 01/03/2017.
 */

public class ServCambiarPass {

    public ServCambiarPass(final RequestCambiarPass requestCambiarPass){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
              @Override
              public okhttp3.Response intercept(Chain chain) throws IOException {
                  Request original = chain.request();

                  Request request = original.newBuilder()
                          .header("Authorization", "Bearer " + requestCambiarPass.getToken())
                          .method(original.method(), original.body())
                          .build();

                  return chain.proceed(request);
              }
        });
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apptaxi.esy.es/API/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        InterCambiarPass service = retrofit.create(InterCambiarPass.class);
        Call<ResponseCambiarPass> call = service.cambiarPass(requestCambiarPass);
        call.enqueue(new Callback<ResponseCambiarPass>() {
            @Override
            public void onResponse(Call<ResponseCambiarPass> call, Response<ResponseCambiarPass> response) {

                if (response.isSuccessful()) {
                    Log.e("Exito", ":" + new Gson().toJson(response.body()));
                }else
                {
                    Log.e("No exito", "------");
                }
            }

            @Override
            public void onFailure(Call<ResponseCambiarPass> call, Throwable t) {
                Log.e("Error base datos", "------"+ t);
            }
        });
    }
}
