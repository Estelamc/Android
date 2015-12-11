package estelamc.practica6_eventos_mucoes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Eventos6_mucoes extends AppCompatActivity {
    private int num1, num2, result;
    private EditText camp1, camp2;
    private TextView camp3;
    private Button botonS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos6_mucoes);

        camp1=(EditText) findViewById(R.id.campo1);
        camp2=(EditText) findViewById(R.id.campo2);
        camp3=(TextView) findViewById(R.id.campo3);
        botonS=(Button) findViewById(R.id.boton);

        botonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(camp1.getText().toString());
                num2=Integer.parseInt(camp2.getText().toString());
                result= num1+num2;
                camp3.setText(Integer.toString(result));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eventos6_mucoes, menu);
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
