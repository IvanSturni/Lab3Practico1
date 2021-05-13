package com.sturni.lab3practico1.ui.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sturni.lab3practico1.R;
import com.sturni.lab3practico1.model.Usuario;
import com.sturni.lab3practico1.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {
    private Button btGuardar;
    private EditText etRMail, etRPass, etRNombre, etRDni;
    private TextView tvTitulo;
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
                etRNombre.setText(usuario.getNombre());
                etRDni.setText(String.valueOf(usuario.getDni()));
            }
        });

        vm.getTitulo().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvTitulo.setText(s);
            }
        });
        Bundle b = getIntent().getExtras();
        vm.comprobarLogin(b);
    }

    private void inicializarVista() {
        tvTitulo = findViewById(R.id.tvTitulo);
        btGuardar = findViewById(R.id.btGuardar);
        etRMail = findViewById(R.id.etRMail);
        etRPass = findViewById(R.id.etRPass);
        etRNombre = findViewById(R.id.etRNombre);
        etRDni = findViewById(R.id.etRDni);
        btGuardar.setOnClickListener(v -> {
            vm.guardar(etRMail.getText().toString(), etRPass.getText().toString(), etRNombre.getText().toString(), etRDni.getText().toString());
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        });
    }
}