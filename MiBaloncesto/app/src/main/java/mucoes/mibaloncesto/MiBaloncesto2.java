package mucoes.mibaloncesto;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Estela on 28/05/2016.
 */
public class MiBaloncesto2 extends AppCompatActivity implements View.OnClickListener{

    private Button boton1A, boton2A, boton3A, botonRA, boton1B, boton2B, boton3B, botonRB, botonReset;
    private TextView pA, pB, nombreA, nombreB;
    private int resultadoA, resultadoB;

    private void cargarComponentes(){
        boton1A = (Button)findViewById(R.id.b1A);
        boton1B = (Button)findViewById(R.id.b1B);
        boton2A = (Button)findViewById(R.id.b2A);
        boton2B = (Button)findViewById(R.id.b2B);
        boton3A = (Button)findViewById(R.id.b3A);
        boton3B = (Button)findViewById(R.id.b3B);
        botonRA = (Button)findViewById(R.id.bRA);
        botonRB = (Button)findViewById(R.id.bRB);
        botonReset = (Button)findViewById(R.id.bReset);
        pA = (TextView)findViewById(R.id.puntosA);
        pB = (TextView)findViewById(R.id.puntosB);
        nombreA = (TextView)findViewById(R.id.equipoA);
        nombreB = (TextView) findViewById(R.id.equipoB);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_baloncesto2);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        cargarComponentes();

        Bundle paquete2 = this.getIntent().getExtras();

        nombreA.setText(paquete2.getString("Equipo1"));
        nombreB.setText(paquete2.getString("Equipo2"));

        boton1A.setOnClickListener(this);
        boton2A.setOnClickListener(this);
        boton3A.setOnClickListener(this);
        boton1B.setOnClickListener(this);
        boton2B.setOnClickListener(this);
        boton3B.setOnClickListener(this);
        botonRA.setOnClickListener(this);
        botonRB.setOnClickListener(this);
        botonReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        resultadoA = Integer.parseInt(pA.getText().toString());
        resultadoB = Integer.parseInt(pB.getText().toString());

        switch (v.getId()){
            case R.id.b1A:
                resultadoA += 1;
                pA.setText(Integer.toString(resultadoA));
                break;
            case R.id.b1B:
                resultadoB += 1;
                pB.setText(Integer.toString(resultadoB));
                break;
            case R.id.b2A:
                resultadoA += 2;
                pA.setText(Integer.toString(resultadoA));
                break;
            case R.id.b2B:
                resultadoB += 2;
                pB.setText(Integer.toString(resultadoB));
                break;
            case R.id.b3A:
                resultadoA += 3;
                pA.setText(Integer.toString(resultadoA));
                break;
            case R.id.b3B:
                resultadoB += 3;
                pB.setText(Integer.toString(resultadoB));
                break;
            case R.id.bRA:
                if (resultadoA > 0){
                    resultadoA-=1;
                }
                pA.setText(Integer.toString(resultadoA));
                break;
            case R.id.bRB:
                if (resultadoB > 0){
                    resultadoB-=1;
                }
                pB.setText(Integer.toString(resultadoB));
                break;
            case R.id.bReset:
                pA.setText("0");
                pB.setText("0");
                break;
        }
    }
}
