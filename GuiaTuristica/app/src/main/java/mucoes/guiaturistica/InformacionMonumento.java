package mucoes.guiaturistica;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *
 * Created by Estela on 12/06/2016.
 */
public class InformacionMonumento extends AppCompatActivity {
    private TextView nombreM, descripcionM;
    private ImageView imagenM;

    private void cargarComponentes(){
        nombreM = (TextView)findViewById(R.id.nombreM);
        imagenM = (ImageView)findViewById(R.id.imagenM);
        descripcionM = (TextView)findViewById(R.id.descripcionM);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Orientación y contenido
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.content_main);

        cargarComponentes();

        Bundle paquete = this.getIntent().getExtras();
        nombreM.setText(paquete.getString("nombre"));
        imagenM.setImageResource(paquete.getInt("imagen"));
        descripcionM.setText(paquete.getString("descripcion"));
    }
}
