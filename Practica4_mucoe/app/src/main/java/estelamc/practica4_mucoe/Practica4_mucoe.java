package estelamc.practica4_mucoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Practica4_mucoe extends AppCompatActivity {

    Button boton;
    TextView myTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica4_mucoe);
        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                TextView myTextView = (TextView) findViewById(R.id.myTextView);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practica4_mucoe, menu);
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

    public void verMensaje(){
        Toast.makeText(getApplicationContext(),R.string.mensaje, Toast.LENGTH_SHORT).show();
    }
}
