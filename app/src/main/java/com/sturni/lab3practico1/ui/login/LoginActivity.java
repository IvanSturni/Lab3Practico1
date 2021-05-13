package com.sturni.lab3practico1.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sturni.lab3practico1.R;
import com.sturni.lab3practico1.ui.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {
    private Button btLogin, btRegistro;
    private EditText etMail, etPass;
    private LoginActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);
        inicializarVista();
    }

    private void inicializarVista() {
        btLogin = findViewById(R.id.btLogin);
        btRegistro = findViewById(R.id.btRegistro);
        etMail = findViewById(R.id.etMail);
        etPass = findViewById(R.id.etPass);
        btLogin.setOnClickListener(v -> vm.login(etMail.getText().toString(), etPass.getText().toString()));
        btRegistro.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(i);
        });
    }
}