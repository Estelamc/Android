package estelamc.baloncesto_mucoes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Baloncesoto_mucoes extends AppCompatActivity {

    private Button boton1A, boton2A, boton3A, botonRA,
            boton1B, boton2B, boton3B, botonRB, botonReset;
    private TextView textA, textB;
    private int resultadoA, resultadoB;

    private void cargarComponentes(){
        boton1A = (Button)findViewById(R.id.b1A);
        boton2A = (Button)findViewById(R.id.b2A);
        boton3A = (Button)findViewById(R.id.b3A);
        botonRA = (Button)findViewById(R.id.bRA);
        boton1B = (Button)findViewById(R.id.b1B);
        boton2B = (Button)findViewById(R.id.b2B);
        boton3B = (Button)findViewById(R.id.b3B);
        botonRB = (Button)findViewById(R.id.bRB);
        botonReset = (Button)findViewById(R.id.bReset);
        textA = (TextView)findViewById(R.id.textoA);
        textB = (TextView)findViewById(R.id.textoB);
    }

=======

public class Baloncesoto_mucoes extends AppCompatActivity {

>>>>>>> origin/master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baloncesoto_mucoes);
<<<<<<< HEAD

        cargarComponentes();

        boton1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultadoA = Integer.parseInt(textA.getText().toString());
                resultadoA += 1;
                textA.setText(Integer.toString(resultadoA));
            }
        });

        boton2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultadoA = Integer.parseInt(textA.getText().toString());
                resultadoA += 2;
                textA.setText(Integer.toString(resultadoA));
            }
        });

        boton3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultadoA = Integer.parseInt(textA.getText().toString());
                resultadoA += 3;
                textA.setText(Integer.toString(resultadoA));
            }
        });

        botonRA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultadoA = Integer.parseInt(textA.getText().toString());
                resultadoA -= 1;
                textA.setText(Integer.toString(resultadoA));
            }
        });


        boton1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultadoB = Integer.parseInt(textB.getText().toString());
                resultadoB += 1;
                textB.setText(Integer.toString(resultadoB));
            }
        });

        boton2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultadoB = Integer.parseInt(textB.getText().toString());
                resultadoB += 2;
                textB.setText(Integer.toString(resultadoB));
            }
        });

        boton3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultadoB = Integer.parseInt(textB.getText().toString());
                resultadoB += 3;
                textB.setText(Integer.toString(resultadoB));
            }
        });

        botonRA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultadoB = Integer.parseInt(textB.getText().toString());
                resultadoB -= 1;
                textB.setText(Integer.toString(resultadoB));
            }
        });

        botonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textB.setText(Integer.toString(0));
                textA.setText(Integer.toString(0));
            }
        });

=======
>>>>>>> origin/master
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_baloncesoto_mucoes, menu);
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
