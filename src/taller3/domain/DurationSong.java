package taller3.domain;

/**
 * Refers to the class that gets the duration of the song and converts it to milliseconds
 * DurationSong duration;
 *
 * @version 1.1.1 2022-02-09
 *
 * @author Daniel, Agudelo - danielagudelo103@gmail.com
 *
 * @since 1.1.1
 */
public class DurationSong {

    private Integer minutes;
    private  Integer seconds;

    /**
     * It is the constructor that obtains the minutes and seconds that are entered when the class is instantiated.
     *new DurationSong(4,25);
     *
     * @param minutes The minutes of the song
     * @param seconds The seconds of the song
     *
     *@author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public DurationSong(Integer minutes, Integer seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     *Method that obtains the minutes of the song.
     *
     * @return the minutes of the song.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public Integer getMinutes() {
        return minutes;
    }

    /**
     *Method that obtains the seconds of the song.
     *
     * @return the seconds of the song.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public Integer getSeconds() {
        return seconds;
    }

    /**
     *Method that transforms minutes and seconds to milliseconds.
     *
     * @return the sum of the milliseconds of minutes and seconds.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public Integer toMilliSeconds(){
        return (this.minutes * 60000) + (this.seconds*1000);
    }
}
