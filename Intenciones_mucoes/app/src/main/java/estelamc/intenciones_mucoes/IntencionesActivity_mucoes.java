package estelamc.intenciones_mucoes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntencionesActivity_mucoes extends AppCompatActivity {

    private Button enviar; // botón enviar
    private EditText mensajeEditable; // texto editable
    private String mensaje; // mensaje (cadena que se enviará)

    // Carga el boton y la caja de texto editable
    private void cargarComponentes(){
        enviar = (Button) findViewById(R.id.bSend);
        mensajeEditable = (EditText) findViewById(R.id.edText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intenciones_activity_mucoes);

        cargarComponentes();

        enviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intencion =  new Intent(IntencionesActivity_mucoes.this, Mostrarmensaje_mucoes.class);
                Bundle paquete = new Bundle();
                mensaje = mensajeEditable.getText().toString();
                paquete.putString("MENSAJE", mensaje);
                intencion.putExtras(paquete);
                startActivity(intencion);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intenciones_activity_mucoes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
