package taller3.domain;

import java.text.ParseException;


/**
 * This is an interface that implements sorting methods.
 * class Library implements Isort
 *
 * @version 1.1.1 2022-02-09
 *
 * @author Daniel, Agudelo - danielagudelo103@gmail.com
 *
 * @since 1.1.1
 */
public interface ISort {
    /**
     *The method sorts the songs by duration in descending order.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    void sortSongsByDurationDescending();

    /**
     * The method sorts the songs by duration in ascendant order.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    void sortSongsByDurationAscendant();

    /**
     * The method sorts the songs by date in descending order.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    void sortSongsByDateDescending();

    /**
     * The method sorts the songs by date in ascending order
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    void sortSongsByDateAscendant();
}
