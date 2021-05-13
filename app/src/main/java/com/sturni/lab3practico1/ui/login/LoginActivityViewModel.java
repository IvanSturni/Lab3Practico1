package com.sturni.lab3practico1.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sturni.lab3practico1.request.ApiClient;
import com.sturni.lab3practico1.ui.register.RegisterActivity;

public class LoginActivityViewModel extends AndroidViewModel {
    private MutableLiveData<String> error;
    private Context context;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public void login(String mail, String pass) {
        if (ApiClient.login(context, mail, pass) != null) {
            Bundle b = new Bundle();
            b.putBoolean("login", true);
            Intent i = new Intent(getApplication(), RegisterActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra("login", true);
            context.startActivity(i, b);
        } else {
            error.setValue("Datos incorrectos.");
        }
    }

    public LiveData<String> getError() {
        if (error == null){
            error = new MutableLiveData<>();
            error.setValue("");
        }
        return error;
    }
}
