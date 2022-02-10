package taller3.domain;
/**
 *
 * @author HEINER PALACIOS ASPRILLA
 */
import java.util.ArrayList;


/**
 *
 * @author Heiner Palacios Asprilla
 */
public abstract class Library {
     private ArrayList songs = new ArrayList();

     public abstract void filtarCancionesGenero();
     public abstract void filtarCancionesAno();
     public abstract void ordenarDuracion();
     public abstract void ordenaFecha();
     
     
      public ArrayList getSongs() {
        return this.songs;
    }

    public void setSongs(ArrayList songs) {
        this.songs = songs;
    }
     
}
