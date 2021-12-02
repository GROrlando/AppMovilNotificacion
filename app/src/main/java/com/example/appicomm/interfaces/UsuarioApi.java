package com.example.appicomm.interfaces;

import com.example.appicomm.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsuarioApi {
    String API_ROUTE = "GetUsuarios/{Id}";//aqui poner la api que vamos a extraer
    @GET(API_ROUTE)
   public Call<Usuario> find(@Path("Id")String Id); //En Get()va la api que estamos jalando ej. GetSuscripciones();
}
