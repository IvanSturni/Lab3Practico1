package com.sturni.lab3practico1.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.sturni.lab3practico1.model.Usuario;

public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context context){
        if (sp == null) {
            sp = context.getSharedPreferences("datos.dat",0);
        }
        return sp;
    }

    public static void guardar(Context context, Usuario usuario){
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor edit = sp.edit();
        edit.putLong("dni", usuario.getDni());
        edit.putString("nombre", usuario.getNombre());
        edit.putString("mail", usuario.getMail());
        edit.putString("pass", usuario.getPass());
        edit.commit();
    }

    public static Usuario leer(Context context) {
        SharedPreferences sp = conectar(context);
        return new Usuario(
                sp.getLong("dni", 0),
                sp.getString("nombre", ""),
                sp.getString("mail", ""),
                sp.getString("pass", ""));
    }

    public static Usuario login(Context context, String mail, String pass) {
        Usuario u = leer(context);
        if (mail.equals(u.getMail()) && pass.equals(u.getPass())){ return u; }
        return null;
    }
}
