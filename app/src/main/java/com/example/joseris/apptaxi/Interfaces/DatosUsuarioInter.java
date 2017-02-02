package com.example.joseris.apptaxi.Interfaces;

import com.example.joseris.apptaxi.DatosUsuario.Cne;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Joseris on 01/02/2017.
 */

public interface DatosUsuarioInter {
    @GET("infove/cne/elector/{n}/{cd}")
    Call<Cne> UsuarioCne(@Path("n")String n,@Path("cd")int cd);
}
