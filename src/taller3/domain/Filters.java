package taller3.domain;

import java.text.ParseException;
import java.util.stream.Stream;

/**
 * This class constructs a Song that is used from the Library class to create a list of songs.
 * private List<Song> songs
 *
 * @version 1.1.1 2022-02-09
 *
 * @author Daniel, Agudelo - danielagudelo103@gmail.com
 *
 * @since 1.1.1
 */
public abstract class Filters {

    /**
     *Filter songs by date.
     *SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
     *Date dateFilter = format.parse(date);
     *return this.songs.stream().filter(songs -> songs.getDate().equals(dateFilter));
     *
     * @param date receives a date string that is formatted to type Date
     * @return a list of type Song filtered by date.
     * @throws ParseException
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public abstract Stream<Song> filterSongsByYear(String date) throws ParseException;

    /**
     *Filter the song by genre.
     *this.songs.stream().filter(songs -> songs.getGenre() == genre);
     *
     * @param genre of type enum MusicalGenre
     * @return A list of Songs filtered by year
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public abstract Stream<Song> filterSongsByGenre(MusicalGenre genre);

    /**
     *Enumerator that stores the constants of elements to be used as song genre
     * Filter.MusicalGenre.ROCK or Filter.MusicalGenre.POP
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public enum MusicalGenre {
        ROCK, REGGAETON, POP, TROPICAL, ELECTRONIC, RAP, CLASSIC, SALSA, TRAP, REGGAE;
    }
}
