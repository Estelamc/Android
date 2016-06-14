package com.example.mucoes.tiempo;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Estela on 13.06.2016.
 */
public class CityPreference {

    SharedPreferences prefs;

    public CityPreference(Activity activity) {
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    String getCity() {
        return prefs.getString("city", "Cordoba,ES");
    }

    void setCity(String city) {
        prefs.edit().putString("city", city).commit();
    }
}
