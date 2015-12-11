package estelamc.calculadora_mucoes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora_mucoes extends AppCompatActivity implements View.OnClickListener { //MainActivity

    // ----- DECLARAR VARIABLES (botones, operaciones) -----\\

    private Button boton1, boton2, boton3, boton4, boton5, boton6, boton7,
            boton8, boton9,boton0, botonPunto, botonC, botonBorrar,
            botonDividir,botonMultiplicar, botonRestar, botonSumar,
            botonIgual;
    private TextView display;
    private boolean lOperando1, lOperando2, lNuevoNumero; // falta uno
    private int resultado, operando1, operando2=0;
    String operacion;


    // ----- CARGAR COMPONENETES -----\\

    private void cargarComponentes(){
        // BOTONES
        botonC = (Button)findViewById(R.id.bC);
        boton1 = (Button)findViewById(R.id.b1);
        boton2 = (Button)findViewById(R.id.b2);
        boton3 = (Button)findViewById(R.id.b3);
        boton4 = (Button)findViewById(R.id.b4);
        boton5 = (Button)findViewById(R.id.b5);
        boton6 = (Button)findViewById(R.id.b6);
        boton7 = (Button)findViewById(R.id.b7);
        boton8 = (Button)findViewById(R.id.b8);
        boton9 = (Button)findViewById(R.id.b9);
        boton0 = (Button)findViewById(R.id.b0);
        botonPunto = (Button)findViewById(R.id.bPunto);
        botonBorrar = (Button)findViewById(R.id.bBorrar);
        botonDividir = (Button)findViewById(R.id.bD);
        botonMultiplicar = (Button)findViewById(R.id.bM);
        botonRestar = (Button)findViewById(R.id.bR);
        botonSumar = (Button)findViewById(R.id.bS);
        botonIgual = (Button)findViewById(R.id.bIgual);
        // CAMPO DE TEXTO
        display = (TextView) findViewById(R.id.texto);
    }


    // ----- MUESTRA EL RESULTADO -----\\

    private void mostrarResultado(){
        switch (operacion){
            case "+":
                resultado = operando1+operando2;
                break;
            case "-":
                resultado = operando1-operando2;
                break;
            case "x":
                resultado = operando1*operando2;
                break;
            case "/":
                resultado = operando1/operando2;
                break;
            default: // le damos al igual
                // No hace nada - resultado no cambia
                break;
        }
        display.setText(Integer.toString(resultado));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_mucoes);

        cargarComponentes();

        lOperando1 = lOperando2 = false;

        lNuevoNumero = true;

        display.setText("0");

        boton0.setOnClickListener(this);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton4.setOnClickListener(this);
        boton5.setOnClickListener(this);
        boton6.setOnClickListener(this);
        boton7.setOnClickListener(this);
        boton8.setOnClickListener(this);
        boton9.setOnClickListener(this);
        botonC.setOnClickListener(this);
        botonPunto.setOnClickListener(this);
        botonBorrar.setOnClickListener(this);
        botonDividir.setOnClickListener(this);
        botonMultiplicar.setOnClickListener(this);
        botonRestar.setOnClickListener(this);
        botonSumar.setOnClickListener(this);
        botonIgual.setOnClickListener(this);
    }

    // ----- AL HACER CLICK EN LOS BOTONES -----\\
    @Override
    public void onClick(View control){ // Para todos
        String entrada = (String) ((Button) control).getText();

        // Si le damos a una operación (da resultado o pasa al op2)
        switch(control.getId()) { // control hace referencia a los botones
            case R.id.bR:
            case R.id.bS:
            case R.id.bM:
            case R.id.bD:
            case R.id.bIgual:
                lNuevoNumero = true;
                lOperando2 = false; // DEFINITIVO --> MEJOR AQUÍ
                if (lOperando2) { // si está activado el operando 2 (estamos usando éste)
                    operando2 = Integer.parseInt(display.getText().toString()); // lo recogemos
                    mostrarResultado(); // mostramos el resultado
                    operando1 = resultado; // el operando 1 lo igualamos al resultado
                    // seguimos en el operando 2, porque el resultado de la operación
                    // pasa a ser el operando 1, así que podemos poner otro número para seguir operando
                    //lOperando2= true;
                    // el operando 1 está desactivado (es el resultado y
                    // seguimos con el operando 2 para meter más números)
                    //lOperando1=false;
                } else { // si está desactivado el operando 2 (estamos usando el 1)
                    operando1 = Integer.parseInt(display.getText().toString()); // recogemos el operando 1
                    lOperando2 = true; // activamos el operando 2 para meter otro número con el que operar
                    //lOperando1=false; // el operando 1 se desactiva, pues ya ha sido introducido (toca el 2)
                }
                //lOperando1 = false; // se pone aquí pq en ambos casos se desactiva --> más óptimo arriba del todo(segundo cambio)
                operacion = entrada;
                break;

            case R.id.bC: // volvemos al estado inicial (tecla C)
                display.setText("0");
                lNuevoNumero = true;
                operando1 = operando2 = 0;
                lOperando1 = lOperando2 = false;
                break;

            default:
                if (lNuevoNumero) { // si hay nuevo número
                    display.setText(entrada); // se modifica el texto con la entrada
                    lNuevoNumero = false;
                } else { // no hay nuevo número
                    display.setText(display.getText() + entrada); // se le añade la entrada
                }
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora_mucoes, menu);
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
