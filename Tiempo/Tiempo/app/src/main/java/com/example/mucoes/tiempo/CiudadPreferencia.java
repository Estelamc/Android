package com.example.mucoes.tiempo;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Estela on 13.06.2016.
 */
public class CiudadPreferencia {

    SharedPreferences preferencias;

    public CiudadPreferencia(Activity actividad) {
        preferencias = actividad.getPreferences(Activity.MODE_PRIVATE);
    }

    String getCiudad() {
        return preferencias.getString("city", "Cordoba,ES");
    }

    void setCity(String ciudad) {
        preferencias.edit().putString("city", ciudad).commit();
    }
}
