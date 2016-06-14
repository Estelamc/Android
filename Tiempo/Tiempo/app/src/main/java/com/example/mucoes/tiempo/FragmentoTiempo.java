package com.example.mucoes.tiempo;


import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoTiempo extends Fragment {

    Typeface fuenteTiempo;
    TextView campoCiudad, campoActualizar, campoDetalles,
            campoTemperaturaActual, iconoTiempo;
    Handler manejador;
    Locale spain = new Locale("es","ES");

    public FragmentoTiempo() {
        manejador = new Handler();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fuenteTiempo = Typeface.createFromAsset(getActivity().getAssets(), "tiempo.ttf");
        actualizarTiempo(new CiudadPreferencia(getActivity()).getCiudad());
    }

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup contenedor,
                             Bundle paquete) {
        View vista =
                inflador.inflate(R.layout.fragmento_tiempo, contenedor, false);

        cargarComponentes(vista);

        iconoTiempo.setTypeface(fuenteTiempo);
        return vista;
    }

    private void cargarComponentes(View vista) {
        campoCiudad = (TextView) vista.findViewById(R.id.city_field);
        campoActualizar = (TextView) vista.findViewById(R.id.update_field);
        campoDetalles = (TextView) vista.findViewById(R.id.details_field);
        campoTemperaturaActual = (TextView) vista.findViewById(R.id.current_temperature_field);
        iconoTiempo = (TextView) vista.findViewById(R.id.weather_icon);
    }

    private void actualizarTiempo(final String ciudad) {
        new Thread() {
            @Override
            public void run() {
                final JSONObject json = Remoto.getJSON(getActivity(), ciudad);
                if(json == null) {
                    manejador.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(),
                                    getActivity().getString(R.string.ciudad_no_encontrada),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    manejador.post(new Runnable() {
                        @Override
                        public void run() {
                            renderizarTiempo(json);
                        }
                    });
                }
            }
        }.start();
    }

    private void renderizarTiempo(JSONObject json) {
        try {
            campoCiudad.setText(json.getString("name").toUpperCase(spain) +
                    ", " + json.getJSONObject("sys").getString("country"));

            JSONObject detalles = json.getJSONArray("weather").getJSONObject(0);
            JSONObject principal = json.getJSONObject("main");

            campoDetalles.setText(detalles.getString("description").toUpperCase(spain) + "\n"
                    + "Humedad: " + principal.getString("humidity") + "%" + "\n" + "Presión: "
                    + principal.getString("pressure") + "hPa");

            campoTemperaturaActual.setText(String.format("%.2f", principal.getDouble("temp")) + " °C");

            DateFormat formatoFecha = DateFormat.getDateTimeInstance();
            String actualizado = formatoFecha.format(new Date(json.getLong("dt") * 1000));
            campoActualizar.setText("Última actualización: " + actualizado);

            setIconoTiempo(detalles.getInt("id"), json.getJSONObject("sys").getLong("sunrise") * 1000,
                    json.getJSONObject("sys").getLong("sunset") * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setIconoTiempo(int actualId, long amanecer, long aterdecer) {
        int id = actualId / 100;
        String icono = "";
        if(actualId == 800) {
            long tiempoActual = new Date().getTime();
            if(tiempoActual >= amanecer && tiempoActual < aterdecer) {
                icono = getActivity().getString(R.string.tiempo_soleado);
            } else {
                icono = getActivity().getString(R.string.tiempo_noche_despejada);
            }
        } else {
            switch (id) {
                case 2 : icono = getActivity().getString(R.string.tiempo_tormenta);
                    break;
                case 3 : icono = getActivity().getString(R.string.tiempo_llovizna);
                    break;
                case 7 : icono = getActivity().getString(R.string.tiempo_niebla);
                    break;
                case 8 : icono = getActivity().getString(R.string.tiempo_nublado);
                    break;
                case 6 : icono = getActivity().getString(R.string.tiempo_nevado);
                    break;
                case 5 : icono = getActivity().getString(R.string.tiempo_lluvioso);
                    break;
            }
        }
        iconoTiempo.setText(icono);
    }

    public void cambiarCiudad(String ciudad) {
        actualizarTiempo(ciudad);
    }
}
