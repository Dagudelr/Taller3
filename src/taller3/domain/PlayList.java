package taller3.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * This class builds the Playlist class that will store all the songs that the user has from the library.
 *
 * @versión 1.1.1 2022-02-09
 *
 * @author Daniel, Agudelo - danielagudelo103@gmail.com
 *
 * @since 1.1.1
 */
public class PlayList extends Filters implements ISort{

    private String name;
    private List<Song> songs;

    /**
     * Builder that initializes the name of the playlist and the list of songs.
     *
     * @param name of the playlist
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @@since 1.1.1
     */
    public PlayList(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    /**
     * Displays a song from the PlayList.
     *
     * @return song from the PlayList.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @@since 1.1.1
     */
    public Song getSong(Integer i) {
        return songs.get(i);
    }

    /**
     * Displays the songs in the PlayList.
     *
     * @return songs from the list the PlayList.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public List<Song> getSongs() {
        return this.songs;
    }

    /**
     * Add songs to the PlayList.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public void setSong(Song song) throws ParseException {
        this.songs.add(song);
    }

    /**
     * method that obtains the size of the list.
     *
     * @return the size of the song list
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public Integer getSize(){
        return this.songs.size();
    }


    /**
     * Gets the filter of songs by year.
     *
     * @return the list of songs filtered by year.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
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
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
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
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
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
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
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
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
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
     * @author @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    @Override
    public void sortSongsByDateAscendant() {
        this.songs.sort(Comparator.comparing(Song::getDate).reversed());
    }
}

