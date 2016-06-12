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
   private TextView nombreM;
    private TextView descripcionM;
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

        Bundle bundle = this.getIntent().getExtras();
        nombreM.setText(bundle.getString("nombre"));
        imagenM.setImageResource(bundle.getInt("imagen"));
        descripcionM.setText(bundle.getString("descripcion"));
    }
}
