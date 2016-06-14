package estelamc.divisas;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity_Divisas_mucoe extends AppCompatActivity implements View.OnClickListener {
    // Variables
    private Button botonEU_USD, botonUSD_EU, botonEU_JPY,
            botonJPY_EU, botonEU_BGN, botonBGN_EU;
    private EditText cantidadTexto;
    private TextView resultadoTexto;
    private double cantidad, resultado;

    // Carga los componentes (botones, cajas de texto...)
    private void cargarComponentes(){
        botonBGN_EU = (Button)findViewById(R.id.bBGN_EU);
        botonEU_BGN = (Button)findViewById(R.id.bEU_BGN);
        botonEU_JPY = (Button)findViewById(R.id.bEU_JPY);
        botonJPY_EU = (Button)findViewById(R.id.bJPY_EU);
        botonEU_USD = (Button)findViewById(R.id.bEU_USD);
        botonUSD_EU = (Button)findViewById(R.id.bUSD_EU);
        resultadoTexto = (TextView)findViewById(R.id.textoResultadoEditable); // lo que se ve
        cantidadTexto = (EditText)findViewById(R.id.textoCantidadEditable); // lo que se introduce
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity__divisas_mucoe);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        cargarComponentes(); // Cargamos los componentes

        cantidadTexto.setText("0"); // Lo iniciamos en 0

        // Añadimos el evento a cada botón
        botonBGN_EU.setOnClickListener(this);
        botonEU_BGN.setOnClickListener(this);
        botonUSD_EU.setOnClickListener(this);
        botonEU_USD.setOnClickListener(this);
        botonEU_JPY.setOnClickListener(this);
        botonJPY_EU.setOnClickListener(this);
    }

    // El evento cambiará según cada botón
    @Override
    public void onClick(View control){
        cantidad = Double.parseDouble(cantidadTexto.getText().toString());
        // Reconocemos el botón por su id
        switch (control.getId()){
            case R.id.bEU_USD:
                resultado = cantidad*1.0943;
                resultadoTexto.setText(Double.toString(resultado));
                break;
            case R.id.bUSD_EU:
                resultado = cantidad/1.0943;
                resultadoTexto.setText(Double.toString(resultado));
                break;
            case R.id.bEU_BGN:
                resultado = cantidad*1.9558;
                resultadoTexto.setText(Double.toString(resultado));
                break;
            case R.id.bBGN_EU:
                resultado = cantidad/1.9558;
                resultadoTexto.setText(Double.toString(resultado));
                break;
            case R.id.bEU_JPY:
                resultado = cantidad*132.97;
                resultadoTexto.setText(Double.toString(resultado));
                break;
            case R.id.bJPY_EU:
                resultado = cantidad/132.97;
                resultadoTexto.setText(Double.toString(resultado));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity__divisas_mucoe, menu);
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
