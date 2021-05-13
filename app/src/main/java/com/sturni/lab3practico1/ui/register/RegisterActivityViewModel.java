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

    public RegisterActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public LiveData<Usuario> getUsuario() {
        if (usuario == null) {
            usuario = new MutableLiveData<>();
            usuario.setValue(new Usuario(0,"","","3"));
        }
        return usuario;
    }

    public void comprobarLogin(Bundle b) {
        if (b != null && b.getBoolean("login")) {
            usuario.setValue(ApiClient.leer(context));
        }
    }

    public void guardar(String mail, String pass) {
        Usuario u = new Usuario();
        u.setMail(mail);
        u.setPass(pass);
        ApiClient.guardar(context, u);
    }
}
