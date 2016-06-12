package mucoes.guiaturistica;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView listado;
    private ImageView imagen;
    private Monumento[] monumentos = new Monumento[]{
            new Monumento("Mezquita", "Es Patrimonio de la Humanidad desde 1984, siendo el monumento de más importancia"+
                    " de todo el Occidente islámico y uno de los más asombrosos del mundo. En su historia se resume la "+
                    "evolución completa del estilo omeya en España, además de los estilos gótico, renacentista y barroco de la construcción",
                    R.drawable.mezquitap, R.drawable.mezquitag),
            new Monumento("Puente Romano", "Junto a la Mezquita Catedral y el río, conforma una de las vistas más exquisitas"+
                    " de la ciudad, máxime aún si se visita al atardecer, en esa hora incierta en la que los últimos rayos"+
                    " del sol doran las superficies. Fue levantado en el siglo I a.C. y ha sufrido varias remodelaciones.",
                    R.drawable.puentep, R.drawable.puenteg),
            new Monumento("Torre de la Calahorra", "En el extremo sur del Puente Romano se levanta esta torre, enclave"+
                    " de control y defensa desde la antigüedad, mencionada en ealguna fuente árabae sobre Al-Ándalus, y "+
                    "en numerosas referencias históricas desde la conquista cristiana de Córdoba hasta la actualidad.",
                    R.drawable.calahorrap, R.drawable.calahorrag),
            new Monumento("Sinagoga", "Es la única en Andalucía y tercera de las mejor conservadas de época medieval de toda"+
                    " España. Está situada en el barrio de la Judería. Fue construida entre los años 1314 y 1315 según las inscripciones"+
                    " halladas en el edificio. Sirvió de templo hasta la definitiva expulsión judía.",
                    R.drawable.sinagogap, R.drawable.sinagogag),
            new Monumento("Alcázar de los Reyes Cristianos", "Es fortaleza y palacio de sólidos muros, que encierra en us interior gran parte"+
                    " de la evolución arquitectónica de Córdoba. Restos romanos y visigodos conviven con los de origen árabe en este majestuoso"+
                    " solar, ya que fue lugar predilecto de los distintos gobernantes de la ciudad",
                    R.drawable.alcazarp, R.drawable.alcazarg)};

    private void cargarComponentes(){
        listado = (ListView)findViewById(R.id.lista);
        imagen = (ImageView)findViewById(R.id.imagenM);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarComponentes();

        // Cabecera
        View cabecera = getLayoutInflater().inflate(R.layout.listado, null);
        listado.addHeaderView(cabecera);

        // Adaptador
        Adaptador adaptador = new Adaptador(this, monumentos);
        listado.setAdapter(adaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String nombreM = ((Monumento)a.getItemAtPosition(position)).getNombre();
                String descripcionM = ((Monumento)a.getItemAtPosition(position)).getDescripcion();
                int imagenSeleccionada = ((Monumento)a.getItemAtPosition(position)).getImagenG();
                Intent intencion = new Intent(MainActivity.this, InformacionMonumento.class);
                Bundle paquete = new Bundle();

                paquete.putString("nombre", nombreM);
                paquete.putString("descripcion", descripcionM);
                paquete.putInt("imagen", imagenSeleccionada);
                intencion.putExtras(paquete);
                startActivity(intencion);
            }
        });
    }

    // Clase para el adaptador
    class Adaptador extends ArrayAdapter<Monumento> {
        public Adaptador(Context contenido, Monumento[] monumentos) {
            super(contenido, R.layout.listado, monumentos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View elemento = inflater.inflate(R.layout.listado, null);

            TextView nombreE = (TextView)elemento.findViewById(R.id.nombreEt);
            nombreE.setText(monumentos[position].getNombre());

            TextView descripcionE = (TextView)elemento.findViewById(R.id.descripcionEt);
            descripcionE.setText(monumentos[position].getDescripcion());

            ImageView imagenI = (ImageView) elemento.findViewById(R.id.imagenIcono);
            imagenI.setImageResource(monumentos[position].getImagenP());

            return(elemento);
        }
    }
}
