package mucoes.mibaloncesto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button comenzar; // botón
    private EditText nombreA, nombreB; // texto editable
    private String mensaje1, mensaje2; // mensaje (cadena que se enviará)

    // Cargar elementos
    private void cargarComponenetes(){
        comenzar = (Button) findViewById(R.id.bEnviar);
        nombreA = (EditText) findViewById(R.id.equipo1);
        nombreB = (EditText) findViewById(R.id.equipo2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        cargarComponenetes();

        comenzar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intencion = new Intent(MainActivity.this, MiBaloncesto2.class);
                Bundle paquete = new Bundle();
                mensaje1 = nombreA.getText().toString();
                mensaje2 = nombreB.getText().toString();
                paquete.putString("Equipo1", mensaje1);
                paquete.putString("Equipo2", mensaje2);
                intencion.putExtras(paquete);
                startActivity(intencion);
            }
        });
    }
}
