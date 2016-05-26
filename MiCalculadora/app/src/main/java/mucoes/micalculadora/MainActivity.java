package mucoes.micalculadora;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //--- DECLARAR VARIABLES ---\\

    private Button boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8,
            boton9, boton0, botonPunto, botonSumar, botonRestar, botonDividir,
            botonMultiplicar, botonIgual, botonC, botonSigno, botonSeno, botonCoseno,
            botonTangente, botonSenoH, botonCosenoH, botonTangenteH, botonExp10,
            botonCuadrado, botonCubo, botonPi, botonRaiz, botonAleatorio;
    private TextView texto;
    private boolean lOperando1, lOperando2, lNuevoNumero;
    private double resultado, operando1, operando2;
    private String operacion;

    //--- CARGAR COMPONENTES ---\\

    private void cargarComponentes(){
        // BOTONES
        boton1 = (Button)findViewById(R.id.boton1);
        boton2 = (Button)findViewById(R.id.boton2);
        boton3 = (Button)findViewById(R.id.boton3);
        boton4 = (Button)findViewById(R.id.boton4);
        boton5 = (Button)findViewById(R.id.boton5);
        boton6 = (Button)findViewById(R.id.boton6);
        boton7 = (Button)findViewById(R.id.boton7);
        boton8 = (Button)findViewById(R.id.boton8);
        boton9 = (Button)findViewById(R.id.boton9);
        boton0 = (Button)findViewById(R.id.boton0);
        botonC = (Button)findViewById(R.id.botonC);
        botonSigno = (Button)findViewById(R.id.botonSigno);
        botonSumar = (Button)findViewById(R.id.botonSumar);
        botonRestar = (Button)findViewById(R.id.botonRestar);
        botonMultiplicar = (Button)findViewById(R.id.botonMultiplicar);
        botonDividir = (Button)findViewById(R.id.botonDividir);
        botonPunto = (Button)findViewById(R.id.botonPunto);
        botonIgual = (Button)findViewById(R.id.botonIgual);

        // TEXTO
        texto = (TextView)findViewById(R.id.texto);
    }

    //--- MUESTRA LA VISTA APAISADA, CARGANDO SUS COMPONENTES---\\

    private void obtenerVistaApaisada() {
        botonPi = (Button) findViewById(R.id.botonPi);
        botonAleatorio = (Button) findViewById(R.id.botonAleatorio);
        botonExp10 = (Button) findViewById(R.id.botonExponencia10);
        botonCuadrado = (Button) findViewById(R.id.botonExponencia2);
        botonCubo = (Button) findViewById(R.id.botonExponencia3);
        botonRaiz = (Button) findViewById(R.id.botonRaiz);
        botonSeno = (Button) findViewById(R.id.botonSeno);
        botonCoseno = (Button) findViewById(R.id.botonCoseno);
        botonTangente = (Button) findViewById(R.id.botonTangente);
        botonSenoH = (Button) findViewById(R.id.botonSenoHiperbolico);
        botonCosenoH = (Button) findViewById(R.id.botonCosenoHiperbolico);
        botonTangenteH = (Button) findViewById(R.id.botonTangenteHiperbolica);

        botonPi.setOnClickListener(this);
        botonAleatorio.setOnClickListener(this);
        botonExp10.setOnClickListener(this);
        botonCuadrado.setOnClickListener(this);
        botonCubo.setOnClickListener(this);
        botonRaiz.setOnClickListener(this);
        botonSeno.setOnClickListener(this);
        botonCoseno.setOnClickListener(this);
        botonTangente.setOnClickListener(this);
        botonSenoH.setOnClickListener(this);
        botonCosenoH.setOnClickListener(this);
        botonTangenteH.setOnClickListener(this);
    }

    //--- MUESTRA EL RESULTADO ---\\

    private void mostrarResultado(){
        switch (operacion){
            case "+":
                resultado = operando1+operando2;
                break;
            case "-":
                resultado = operando1-operando2;
                break;
            case "*":
                resultado = operando1*operando2;
                break;
            case "/":
                resultado = operando1/operando2;
                break;
            default:
                break; // No hace nada
        }
        texto.setText(Double.toString(resultado));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_2);
            obtenerVistaApaisada();
        }else{
            setContentView(R.layout.activity_main);
        }

        cargarComponentes();

        lOperando1 = lOperando2 = false;
        lNuevoNumero = true;
        texto.setText("0");

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
        botonSigno.setOnClickListener(this);
        botonPunto.setOnClickListener(this);
        botonDividir.setOnClickListener(this);
        botonMultiplicar.setOnClickListener(this);
        botonSumar.setOnClickListener(this);
        botonRestar.setOnClickListener(this);
        botonIgual.setOnClickListener(this);
    }

    //--- AL HACER CLICK EN LOS BOTONES ---\\

    @Override
    public void onClick(View v) {
        String entrada = (String)((Button)v).getText();

        switch (v.getId()){
            case R.id.botonRestar:
            case R.id.botonSumar:
            case R.id.botonMultiplicar:
            case R.id.botonDividir:
            case R.id.botonIgual:
                lNuevoNumero = true;
                lOperando1 = false;
                if (lOperando2){
                    operando2 = Double.parseDouble(texto.getText().toString());
                    mostrarResultado();
                    operando1 = resultado;
                }
                else{
                    operando1 = Double.parseDouble(texto.getText().toString());
                    lOperando2 = true;
                }
                operacion = entrada;
                break;
            case R.id.botonC:
                texto.setText("0");
                lNuevoNumero = true;
                operando1 = operando2 = 0.0;
                lOperando1 = lOperando2 = false;
                break;
            case R.id.botonSigno:
                resultado = Double.parseDouble(texto.getText().toString()) * -1;
                texto.setText(Double.toString(resultado));
                break;
            case R.id.botonPunto:
                if(texto.getText().toString().indexOf(".") < 0){
                    texto.setText(texto.getText() + ".");
                }
                break;
            case R.id.botonPi:
                texto.setText(Double.toString(Math.PI));
                break;
            case R.id.botonAleatorio:
                texto.setText(Double.toString(Math.random()));
                break;
            case R.id.botonExponencia10:
                texto.setText(Double.toString(Math.pow(10, Double.parseDouble(texto.getText().toString()))));
                break;
            case R.id.botonExponencia2:
                texto.setText(Double.toString(Math.pow(Double.parseDouble(texto.getText().toString()), 2)));
                break;
            case R.id.botonExponencia3:
                texto.setText(Double.toString(Math.pow(Double.parseDouble(texto.getText().toString()), 3)));
                break;
            case R.id.botonRaiz:
                if (Double.parseDouble(texto.getText().toString()) > 0){
                    texto.setText(Double.toString(Math.sqrt(Double.parseDouble(texto.getText().toString()))));
                }
                break;
            case R.id.botonSeno:
                if (texto.getText().toString().contains(".")){
                    texto.setText(Double.toString(Math.sin(Math.toRadians(Double.parseDouble(texto.getText().toString())))));
                }
                else{
                    texto.setText(Double.toString(Math.sin(Math.toRadians(Integer.parseInt(texto.getText().toString())))));
                }
                break;
            case R.id.botonCoseno:
                if (texto.getText().toString().contains(".")){
                    texto.setText(Double.toString(Math.cos(Math.toRadians(Double.parseDouble(texto.getText().toString())))));
                }
                else{
                    texto.setText(Double.toString(Math.cos(Math.toRadians(Integer.parseInt(texto.getText().toString())))));
                }
                break;
            case R.id.botonTangente:
                if (!texto.getText().equals("90") || !texto.getText().equals(270)){
                    if (texto.getText().toString().contains(".")){
                        texto.setText(Double.toString(Math.tan(Math.toRadians(Double.parseDouble(texto.getText().toString())))));
                    }
                    else{
                        texto.setText(Double.toString(Math.tan(Math.toRadians(Integer.parseInt(texto.getText().toString())))));
                    }
                }
                break;
            case R.id.botonSenoHiperbolico:
                texto.setText(Double.toString(Math.sinh(Double.parseDouble(texto.getText().toString()))));
                break;
            case R.id.botonCosenoHiperbolico:
                texto.setText(Double.toString(Math.cosh(Double.parseDouble(texto.getText().toString()))));
                break;
            case R.id.botonTangenteHiperbolica:
                texto.setText(Double.toString(Math.tanh(Double.parseDouble(texto.getText().toString()))));
                break;
            default:
                if (lNuevoNumero){
                    texto.setText(entrada);
                    lNuevoNumero = false;
                } else{
                    if (texto.getText().length() < 8){
                        texto.setText(texto.getText() + entrada);
                    }
                }
        }
    }
}
