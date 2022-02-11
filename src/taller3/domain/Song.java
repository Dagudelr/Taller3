package taller3.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * This class constructs a Song that is used from the Library class to create a list of songs.
 * private List<Song> songs
 *
 * @version 1.1.1 2022-02-09
 *
 * @author Daniel, Agudelo - danielagudelo103@gmail.com
 *
 * @since 1.0.0
 */
public class Song {
    private final UUID id;
    private String title;
    private Date date;
    private DurationSong duration;
    private Filters.MusicalGenre genre;
    private String coverPage;
    private String description;

    /**
     *It is the constructor of the class that initializes the values of the attributes.
     * @param title  of the Song when it is instantiated.
     * @param date of the Song when it is instantiated.
     * @param duration of the Song when it is instantiated.
     * @param genre of the Song when it is instantiated.
     * @param coverPage of the Song when it is instantiated.
     * @param description of the Song when it is instantiated.
     * @throws ParseException
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.0.0
     */
    public Song(String title, String date, DurationSong duration, Filters.MusicalGenre genre, String coverPage, String description) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        this.id = UUID.randomUUID();
        this.title = Objects.requireNonNull(title);
        this.date = Objects.requireNonNull(format.parse(date));
        this.duration = Objects.requireNonNull(duration);
        this.genre = Objects.requireNonNull(genre);
        this.coverPage = Objects.requireNonNull(coverPage);
        this.description = Objects.requireNonNull(description);
    }

    /**
     * Gets the id value of the Song class.
     * Song song1 = new Song(attributes of the builder)
     * song1.getId()
     *
     * @return id value
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.0.0
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the title value of the Song class.
     * Song song1 = new Song(attributes of the builder)
     * song1.getTitle()
     *
     * @return title value
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.0.0
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the date value of the Song class.
     * Song song1 = new Song(attributes of the builder)
     * song1.getDate()
     *
     * @return date value
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.0.0
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the genre value of the Song class.
     * Song song1 = new Song(attributes of the builder)
     * song1.getGenre()
     *
     * @return genre value
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.0.0
     */
    public Filters.MusicalGenre getGenre() {
        return genre;
    }

    /**
     * Gets the coverPage value of the Song class.
     * Song song1 = new Song(attributes of the builder)
     * song1.getCoverPage()
     *
     * @return coverPage value
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.0.0
     */
    public String getCoverPage() {
        return coverPage;
    }

    /**
     * Gets the description value of the Song class.
     * Song song1 = new Song(attributes of the builder)
     * song1.getDescription()
     *
     * @return description value
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.0.0
     */
    public String getDescription() {
        return description;
    }

    /**
     * The duration of the song in milliseconds.
     * Song song1 = new Song(attributes of the builder)
     * song1.getDuration()
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public long getDuration(){
        return this.duration.toMilliSeconds();
    }

    /**
     *Method that allows to return the song information.
     * Song song1 = new Song(attributes of the builder)
     * song1.toString()
     *
     * @return Song information
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    @Override
    public String toString() {
        return "Song{" +
                "\nid=" + this.id +
                ", \ntitle='" + this.title + '\'' +
                ", \ndate=" + this.date +
                ", \nduration{" + "\nMinutes: "+ this.duration.getMinutes() +
                "\nSeconds: " + this.duration.getSeconds() + "\n}" +
                ", \ngenre=" + this.genre +
                ", \ncoverPage='" + this.coverPage + '\'' +
                ", \ndescription='" + this.description + '\'' +
                '}';
    }

}
