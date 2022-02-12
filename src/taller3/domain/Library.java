package taller3.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Comparator;
import java.util.stream.Stream;

/**
* This class builds the Library class that will store all the songs..
*
* @versión 1.1.1 2022-02-09
*
* @author Heiner palacios - heinerpalacios@gmail.com
* @author Daniel, Agudelo - danielagudelo103@gmail.com
*
* @since 1.0.0
 */
public class Library extends Filters implements ISort {

    private List<Song> songs;

    /**
     * It refers to the constructor that when instantiating the class creates the list of songs.
     *
     * @throws ParseException
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.0.0
     */
    public Library() throws ParseException {
        this.songs = new ArrayList<>();
        this.addSong(new Song( "Welcome to Ibiza", "2000/5/31", new DurationSong(5, 4),
                Filters.MusicalGenre.ELECTRONIC, "https://i1.sndcdn.com/artworks-000072475663-j82zly-t500x500.jpg",
                "The author of this electronica song is Dj Tiesto."));
        this.addSong(new Song( "The final Countdown", "1986/8/20", new DurationSong(4, 56),
                Filters.MusicalGenre.ROCK,
                "https://i0.wp.com/masdecibelios.es/wp-content/uploads/2018/10/countdown-europe.jpg?fit=620%2C350&ssl=1",
                "Song performed by the rock band Europe."));
        this.addSong(new Song( "Dákiti", "2020/10/30", new DurationSong(3, 26),
                Filters.MusicalGenre.REGGAETON,
                "https://geniuslyrics.net/i/bands/350/bad-bunny-el-ultimo-tour-del-mundo.jpg",
                "Bad Bunny's song"));
        this.addSong(new Song( "Gotas de Lluvia", "1995/3/31", new DurationSong(5, 36),
                Filters.MusicalGenre.SALSA,
                "https://i1.sndcdn.com/artworks-000667296796-zan9fu-t500x500.jpg",
                "Musical of the Salsa genre from Colombia."));
        this.addSong(new Song( "Así Empezaron Papá Y Mamá", "2005/1/01", new DurationSong(2, 28),
                MusicalGenre.TROPICAL,
                "https://cps-static.rovicorp.com/3/JPG_400/MI0001/814/MI0001814027.jpg?partner=allrovi.com",
                "Interpreted by Gustavo Quintero."));
        this.addSong(new Song( "Hips Don't Lie", "2006/2/28 ", new DurationSong(3, 38),
                MusicalGenre.POP, "https://m.media-amazon.com/images/I/51gkGhM9H8L._AC_SY355_.jpg",
                "Interpreted by Colombian Shakira."));
        this.addSong(new Song( "In Da Club", "2003/1/7", new DurationSong(4, 8),
                MusicalGenre.RAP, "https://direct.rhapsody.com/imageserver/images/alb.58515180/500x500.jpg",
                "Performed by the famous U.S. rapper 50 cents."));
        this.addSong(new Song( "Is This Love", "1987/1/01", new DurationSong(3, 51),
                MusicalGenre.REGGAE,
                "https://i.ytimg.com/vi/CHekNnySAfM/0.jpg",
                "Interpreted by Bob Marley"));
        this.addSong(new Song( "Trap", "2018/1/26", new DurationSong(3, 21),
                MusicalGenre.TRAP,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Chopin_nocturne_op9_1a.png/400px-Chopin_nocturne_op9_1a.png",
                "Shakira in collaboration with Maluma"));
        this.addSong(new Song( "Gasolina", "2004/7/13", new DurationSong(4, 13),
                MusicalGenre.REGGAETON,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Chopin_nocturne_op9_1a.png/400px-Chopin_nocturne_op9_1a.png",
                "Interpreted by Daddy Yankee"));
    }

     /**
     * Gets the filter of songs by year.
     *
     * @return the list of songs filtered by year.
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @since 1.0.0
     */
    @Override
    public Stream<Song> filterSongsByYear(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date dateFilter = format.parse(date);
        return this.songs.stream().filter(songs -> songs.getDate().equals(dateFilter));
    }

    /**
     * Gets the filter of the songs by genre.
     *
     * @return the list of songs filtered by genre.
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @since 1.0.0
     */
    @Override
    public Stream<Song> filterSongsByGenre(MusicalGenre genre) {
         return this.songs.stream().filter(songs -> songs.getGenre() == genre);
    }

    /**
     * Compares songs according to length and sorts in descending order.
     *
     * @return the list of songs sorted by descending duration.
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @since 1.0.0
     */
    @Override
    public void sortSongsByDurationDescending() {
        this.songs.sort(Comparator.comparing(Song::getDuration));
    }

    /**
     * Compares songs by duration and sorts in ascending order.
     *
     * @return the list of songs sorted by ascending duration
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @since 1.0.0
     */
    @Override
    public void sortSongsByDurationAscendant() {
        this.songs.sort(Comparator.comparing(Song::getDuration).reversed());
    }

    /**
     * Compare songs by date and sort in descending order
     *
     * @return the list of songs sorted by descending date
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @since 1.0.0
     */
    @Override
    public void sortSongsByDateDescending() {
        this.songs.sort(Comparator.comparing(Song::getDate));
    }

    /**
     * Compares songs by date and sorts in descending order.
     *
     *  @return the list of songs sorted by ascending date
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @since 1.0.0
     */
    @Override
    public void sortSongsByDateAscendant() {
        this.songs.sort(Comparator.comparing(Song::getDate).reversed());
    }

    /**
     * Add songs to the library.
     *
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @since 1.0.0
     */
    public void addSong(Song song) {
        this.songs.add(song);
    }

    /**
     * method that obtains the size of the list.
     *
     * @return the size of the song list
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @since 1.0.0
     */
    public Integer sizeListSongs(){
        return this.songs.size();
    }

    /**
     * Displays a song from the library.
     *
     * @return song from the library
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @since 1.0.0
     */
    public Song getSong(Integer i){
        return this.songs.get(i);
    }

    /**
     * Displays the songs in the library.
     *
     * @return songs from the list
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     *@since 1.0.0
     */
    public List<Song> getSongs(){
        return this.songs;
    }

}