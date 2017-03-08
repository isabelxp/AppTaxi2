package com.example.joseris.apptaxi.Interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Joseris on 05/03/2017.
 */

public interface InterPhotoByCI {
    @GET("photo/byCI/{ci}/{size}")
    Call<ResponseBody> getPhotoByCI(
            @Path("ci") String ci,
            @Path("size") Integer size
    );
}
