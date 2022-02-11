
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
* @versión 1.1.1 2022-02-10
*
* @author Heiner palacios - heinerpalacios@gmail.com
*
* @from 1.0.0
 */

public class Library extends Filters implements ISort{

    private List<Song> songs;

    public Library() throws ParseException {
        this.songs = new ArrayList<>();
        this.addSong(new Song( "Welcome to Ibiza", "2000/5/31", new DurationSong(5, 04),
                    MusicalGenre.ELECTRONIC, "https://i1.sndcdn.com/artworks-000072475663-j82zly-t500x500.jpg",
                    "The author of this electronica song is Dj Tiesto."));
        this.addSong(new Song( "The final Countdown", "1986/8/20", new DurationSong(4, 56),
                    MusicalGenre.ROCK, "https://i0.wp.com/masdecibelios.es/wp-content/uploads/2018/10/countdown-europe.jpg?fit=620%2C350&ssl=1",
                    "Song performed by the rock band Europe."));
        this.addSong(new Song( "Dákiti", "2020/10/30", new DurationSong(3, 26),
                    MusicalGenre.REGGAETON, "https://geniuslyrics.net/i/bands/350/bad-bunny-el-ultimo-tour-del-mundo.jpg",
                    "Bad Bunny's song"));
        this.addSong(new Song( "Gotas de Lluvia", "1995/3/31", new DurationSong(5, 36),
                    MusicalGenre.REGGAETON, "https://i1.sndcdn.com/artworks-000667296796-zan9fu-t500x500.jpg",
                    "Musical of the Salsa genre from Colombia."));
    }

     /**
     * Gets the filter of songs by year.
     *
     * value of the song and year @return
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @from 1.0.0
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
     * value of the song and the genre @return
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @from 1.0.0
     */
    @Override
    public Stream<Song> filterSongsByGenre(MusicalGenre genre) {
         return this.songs.stream().filter(songs -> songs.getGenre() == genre);
    }

    /**
     * Compares songs according to length and sorts in descending order.
     *
     * Song duration descending @return
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @from 1.0.0
     */
    @Override
    public void sortSongsByDurationDescending() {
        this.songs.sort(Comparator.comparing(Song::getDuration));
    }

    /**
     * Compares songs by duration and sorts in ascending order.
     *
     * Song duration ascending @return
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @from 1.0.0
     */
    @Override
    public void sortSongsByDurationAscendant() {
        this.songs.sort(Comparator.comparing(Song::getDuration).reversed());
    }

    /**
     * Compare songs by date and sort in descending order
     *
     * date of the song descending @return
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @from 1.0.0
     */
    @Override
    public void sortSongsByDateDescending() {
        this.songs.sort(Comparator.comparing(Song::getDate));
    }

    /**
     * Compares songs by date and sorts in descending order.
     *
     * date of the song ascending @return
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @from 1.0.0
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
     * @from 1.0.0
     */
    public void addSong(Song song) {
        this.songs.add(song);
    }

    /**
     * create a specific list of songs.
     *
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @from 1.0.0
     */
    public Integer sizeListSongs(){
        return this.songs.size();
    }

    /**
     * Displays the songs in the library.
     *
     * songs from the library @return
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @from 1.0.0
     */
    public Song getSong(Integer i){
        return this.songs.get(i);
    }

    /**
     * Displays the songs in the selected list.
     *
     * songs from the list @return
     *
     * @author Heiner palacios - heinerpalacios@gmail.com
     *
     * @from 1.0.0
     */
    public List<Song> getSongs(){
        return this.songs;
    }

}