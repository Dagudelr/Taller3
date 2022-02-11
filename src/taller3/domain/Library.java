package taller3.domain;

import java.util.ArrayList;


/**
 *The class refers to the main library of the application.
 * Library spotify = new Library();
 *
 * @version 1.1.1 2022-02-09
 *
 * @author Heiner Palacios Asprilla
 * @author Daniel, agudelo - danielagudelo103@gmail.com
 *
 *  @since 1.0.0
 */
public abstract class Library extends Filters {
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
