package taller3.domain;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This class constructs a song that is used from the Library class to create a list of songs.
 * private List<Song> songs
 *
 * @version 1.1.1 2022-02-09
 *
 * @author Daniel, Agudelo - danielagudelo103@gmail.com
 *
 * @since 1.0.0
 */
public class song {
    private final Integer id;
    private String title;
    private Date date;
    private Map<String, Integer> duration = new HashMap<String, Integer>();
    private MusicalGenre genre;
    private String coverPage;
    private String description;

    /**
     *It is the constructor of the class that initializes the values of the attributes.
     * @param id of the song when it is instantiated.
     * @param title  of the song when it is instantiated.
     * @param date of the song when it is instantiated.
     * @param duration of the song when it is instantiated.
     * @param genre of the song when it is instantiated.
     * @param coverPage of the song when it is instantiated.
     * @param description of the song when it is instantiated.
     * @throws ParseException
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.0.0
     */
    public song(Integer id, String title, String date, Map<String, Integer> duration, MusicalGenre genre, String coverPage, String description) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        this.id = Objects.requireNonNull(id);
        this.title = Objects.requireNonNull(title);
        this.date = Objects.requireNonNull(format.parse(date));
        this.genre = Objects.requireNonNull(genre);
        this.coverPage = Objects.requireNonNull(coverPage);
        this.description = Objects.requireNonNull(description);
        if(id < 0){
            throw new IllegalArgumentException("Identifiers cannot be negative.");
        }
    }

    /**
     * Gets the id value of the song class.
     * Song song1 = new Song(attributes of the builder)
     * song1.getId()
     *
     * @return id value
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.0.0
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets the title value of the song class.
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
     * Gets the date value of the song class.
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
     * Gets the genre value of the song class.
     * Song song1 = new Song(attributes of the builder)
     * song1.getGenre()
     *
     * @return genre value
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.0.0
     */
    public MusicalGenre getGenre() {
        return genre;
    }

    /**
     * Gets the coverPage value of the song class.
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
     * Gets the description value of the song class.
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
     * The duration of the song is displayed in a dictionary when the method is called.
     * Song song1 = new Song(attributes of the builder)
     * song1.getDuration()
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public void getDuration(){
        this.duration.forEach((k, v) -> System.out.println("key = " + k + " Value = " + v));
    }

}
