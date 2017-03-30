package com.example.joseris.apptaxi.Servicios;

import android.util.Log;

import com.example.joseris.apptaxi.Interfaces.InterExisteCedula;
import com.example.joseris.apptaxi.Interfaces.InterPhotoByCI;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andy on 29/03/2017.
 */

public class ServExisteCedula {

    private boolean exist;

    public ServExisteCedula(String cedula){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apptaxi.esy.es/API/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterExisteCedula service = retrofit.create(InterExisteCedula.class);
        Call<ResponseBody> call = service.existeCedula(cedula);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {
                        JSONObject json = new JSONObject(response.body().string());
                        exist = json.getBoolean("exist");
                        onDone();
                    }else
                    {
                        Log.e("No existe", "------");
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("FAIL!", "--------" + t);
            }
        });
    }

    public boolean exist(){
        return exist;
    }

    public void onDone(){

    }
}
