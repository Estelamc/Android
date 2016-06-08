package mucoes.animales;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton botonOveja, botonCaballo, botonCerdo;
    private MediaPlayer mp;

    private void cargarComponentes(){
        botonOveja = (ImageButton)findViewById(R.id.bOveja);
        botonCaballo = (ImageButton)findViewById(R.id.bCaballo);
        botonCerdo = (ImageButton)findViewById(R.id.bCerdo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        cargarComponentes();

        botonOveja.setOnClickListener(this);
        botonCaballo.setOnClickListener(this);
        botonCerdo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bOveja:
                Log.i("Test", "Oveja Botón");
                mp = MediaPlayer.create(this, R.raw.oveja);
                break;
            case R.id.bCaballo:
                Log.i("Test", "Caballo Botón");
                mp = MediaPlayer.create(this, R.raw.caballo);
                break;
            case R.id.bCerdo:
                Log.i("Test", "Cerdo Botón");
                mp = MediaPlayer.create(this, R.raw.cerdo);
                break;
        }
        mp.seekTo(0);
        mp.start();
    }
}
