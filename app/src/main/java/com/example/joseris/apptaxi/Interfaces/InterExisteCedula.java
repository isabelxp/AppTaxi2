package com.example.joseris.apptaxi.Interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Andy on 29/03/2017.
 */

public interface InterExisteCedula {

    @GET("cedula_exist/{ci}")
    Call<ResponseBody> existeCedula(
            @Path("ci") String ci
    );

}
