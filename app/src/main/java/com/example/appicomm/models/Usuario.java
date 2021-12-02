package com.example.appicomm.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Usuario {
    @SerializedName("Id")
    @Expose
    private int Id;
    @SerializedName("Nombre")
    @Expose
    private String Nombre;
    @SerializedName("Password")
    @Expose
    private String Password;
    @SerializedName("Email")
    @Expose
    private String Email;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
