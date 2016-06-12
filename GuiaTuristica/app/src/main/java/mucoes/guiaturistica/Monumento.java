package mucoes.guiaturistica;

/**
 * Created by Estela on 12/06/2016.
 */
public class Monumento {
    private String nombre;
    private String descripcion;
    private int imagenP;
    private int imagenG;

    public Monumento(String n, String d, int iP, int iG){
        nombre = n;
        descripcion = d;
        imagenP = iP;
        imagenG = iG;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getImagenP(){
        return imagenP;
    }

    public int getImagenG(){
        return imagenG;
    }
}
