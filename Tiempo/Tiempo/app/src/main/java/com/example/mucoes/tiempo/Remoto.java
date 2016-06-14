package com.example.mucoes.tiempo;

import android.content.Context;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mucoes on 15.06.2015.
 */
public class Remoto {

    private static final String OPEN_WEATHER_MAP_API =
            "http://api.openweathermap.org/data/2.5/weather?q=";


    public static JSONObject getJSON(Context contenido, String ciudad) {
        try {
            URL url = new URL(OPEN_WEATHER_MAP_API + ciudad + "&appid=677a86d851969daa188c204c903b8f57&units=metric&lang=sp");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

            conexion.addRequestProperty("x-api-key",
                    contenido.getString(R.string.open_weather_maps_app_id));

            BufferedReader lector =
                    new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp = "";

            while((tmp = lector.readLine()) != null)
                json.append(tmp).append("\n");
            lector.close();

            JSONObject datos = new JSONObject(json.toString());

            if(datos.getInt("cod") != 200) {
                return null;
            }

            return datos;
        } catch (Exception e) {
            return null;
        }
    }
}
