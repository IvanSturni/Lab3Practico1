package com.sturni.lab3practico1.ui.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.sturni.lab3practico1.R;
import com.sturni.lab3practico1.model.Usuario;
import com.sturni.lab3practico1.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {
    private Button btGuardar;
    private EditText etRMail, etRPass;
    private RegisterActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegisterActivityViewModel.class);
        inicializarVista();
        vm.getUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                etRMail.setText(usuario.getMail());
                etRPass.setText(usuario.getPass());
            }
        });
        Bundle b = getIntent().getExtras();
        vm.comprobarLogin(b);
    }

    private void inicializarVista() {
        btGuardar = findViewById(R.id.btGuardar);
        etRMail = findViewById(R.id.etRMail);
        etRPass = findViewById(R.id.etRPass);
        btGuardar.setOnClickListener(v -> {
            vm.guardar(etRMail.getText().toString(), etRPass.getText().toString());
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        });
    }
}