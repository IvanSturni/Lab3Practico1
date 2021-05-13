package com.sturni.lab3practico1.model;

import androidx.annotation.NonNull;

public class Usuario {
    private long dni;
    private String nombre;
    private String mail;
    private String pass;

    public Usuario() {
    }

    public Usuario(long dni, String nombre, String mail, String pass) {
        this.dni = dni;
        this.nombre = nombre;
        this.mail = mail;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @NonNull
    @Override
    public String toString() {
        return getNombre() + " " + getMail();
    }
}
