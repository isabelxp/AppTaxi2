package com.example.joseris.apptaxi.Servicios;

import android.util.Log;

import com.example.joseris.apptaxi.Interfaces.InterPhotoByCI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andy on 24/02/2017.
 */

public class ServPhotoByCI {

    private String url = "http://apptaxi.esy.es/API/storage/images/profiles/";

    protected ServPhotoByCI(final String ci, int size){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apptaxi.esy.es/API/public/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        InterPhotoByCI service = retrofit.create(InterPhotoByCI.class);
        Call<ResponseBody> call = service.getPhotoByCI(ci, size);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()) {
                    url = url + ci + ".jpg";
                    Log.e("ENCONTRADA!", "---------");
                    onSuccess();
                }
                else
                    Log.e("NO ENCONTRADA!", "--------");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("FAIL!", "--------" + t);
            }
        });
    }

    protected String getUrl(){
        return this.url;
    }

    public void onSuccess(){

    }
}
