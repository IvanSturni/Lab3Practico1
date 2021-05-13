package com.sturni.lab3practico1.ui.register;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sturni.lab3practico1.model.Usuario;
import com.sturni.lab3practico1.request.ApiClient;

public class RegisterActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Usuario> usuario;
    private MutableLiveData<String> titulo;

    public RegisterActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public LiveData<Usuario> getUsuario() {
        if (usuario == null) {
            usuario = new MutableLiveData<>();
            usuario.setValue(new Usuario(0,"","",""));
        }
        return usuario;
    }

    public LiveData<String> getTitulo() {
        if (titulo == null) {
            titulo = new MutableLiveData<>();
            titulo.setValue("Registrarse");
        }
        return titulo;
    }

    public void comprobarLogin(Bundle b) {
        if (b != null && b.getBoolean("login")) {
            usuario.setValue(ApiClient.leer(context));
            titulo.setValue("Cambiar Datos");
        } else {
            titulo.setValue("Registrarse");
        }
    }

    public void guardar(String mail, String pass, String nombre, String dni) {
        Usuario u = new Usuario(Long.parseLong(dni), nombre, mail, pass);
        ApiClient.guardar(context, u);
    }
}
