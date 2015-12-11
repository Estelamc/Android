package estelamc.practica5_eventos_mucoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class eventos_mucoe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_mucoe);

        Button myButton = (Button)findViewById(R.id.boton);
        myButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                TextView myTextView = (TextView) findViewById(R.id.texto);
                myTextView.setText("Botón pulsado");
            }
        });

        myButton.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                TextView myTextView = (TextView) findViewById(R.id.texto);
                myTextView.setText("Manteniendo el botón pulsado");
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eventos_mucoe, menu);
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
