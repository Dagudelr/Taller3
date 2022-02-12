package taller3.domain;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.*;

/**
 * Refers to the class that will allow the user to access the application.
 *
 * @version 1.1.1 2022-02-11
 *
 * @author Daniel, Agudelo - danielagudelo103@gmail.com
 *
 * @since 1.1.1
 */
public class ApplicationUser{

    private static Integer optionMenuMain;
    private static Integer optionMenuLibrary;
    private static Boolean enterApp;
    private static Boolean enterLibraryMenu;
    private static Boolean exitLibraryMenu;
    private static Boolean optionCreatePlayList;

    private static Library spotify;
    private static final Scanner answersString;
    private static final Scanner answersNumber;

    /**
     * Static block that initializes the static attributes.
     * It is initialized when starting to compile the application.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    static {
        optionMenuMain = 0;
        optionMenuLibrary = 0;
        enterApp = false;
        enterLibraryMenu = false;
        exitLibraryMenu = false;
        optionCreatePlayList = false;
        answersString = new Scanner(in);
        answersNumber = new Scanner(in);
        try {
            spotify = new Library();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Java main method where the application is executed
     *The control flows use the static attributes to perform the queries and display the information.
     *
     * @param args It refers to the method that optimizes the code to exit the control flows.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public static void main(String[] args) {
        while (!enterApp) {
            out.println("Welcome to the next generation music application");
            do {
                try {
                    out.println("""
                            What do you want to do?\s
                            1.View my song library.\s
                            2.Create a new PlayList.
                            Any other number: Exit.""");
                    optionMenuMain = answersNumber.nextInt();
                    if (optionMenuMain == 1) {
                        out.println(spotify.getSongs());
                        enterLibraryMenu = true;
                    } else if (optionMenuMain == 2) {
                        out.println("Enter the name of your temporary PlayList");
                        String namePlayList = answersString.nextLine();
                        createPlayList(namePlayList);
                        optionMenuMain = 2;
                    } else {
                        enterApp = true;
                        optionMenuMain = 1;
                    }
                } catch (InputMismatchException e) {
                    out.println("Choose a numeric option.");
                    answersNumber.next();
                } catch (ParseException e) {
                    e.printStackTrace();
                    answersNumber.next();
                }
            }while (optionMenuMain != 1);

            while (enterLibraryMenu) {
                try {
                    out.println("""
                            What do you want to do?\s
                            1.Filter songs by year.
                            2.Filter songs by genre.\s
                            3.Sort songs by ascending duration.
                            4.Sort songs by descending duration.\s
                            5.Sort songs by ascending date.
                            6.Sort songs by descending date.\s
                            Any other number: Exit this menu.""");
                    optionMenuLibrary = answersNumber.nextInt();
                    do {
                        try {
                            if(optionMenuLibrary == 1) {
                                out.println("Adds the year in format yyyy/MM/dd");
                                String date = answersString.nextLine();
                                spotify.filterSongsByYear(date).map(Song::toString).forEach(out::println);

                                out.println("""
                                        What do you want to do??\s
                                        1.Repeat filter.\s
                                        2.Repeat library menu.
                                        3.Exit the library menu.\s
                                        Any other number: exit the application""");

                                exitMenu();

                            } else if (optionMenuLibrary == 2) {
                                out.println("""
                                        Do you want to filter by which genre?\s
                                        1.ROCK.\s
                                        2.REGGAETON.\s
                                        3.POP.\s
                                        4.TROPICAL\s
                                        5.ELECTRONIC.\s
                                        6.RAP.\s
                                        7.CLASSIC.\s
                                        8.SALSA.\s
                                        9.TRAP.\s
                                        Any other number: REGGAE""");
                                int optionNumberFilterGenre = answersNumber.nextInt();
                                switch (optionNumberFilterGenre) {
                                    case 1 -> spotify.filterSongsByGenre(Filters.MusicalGenre.ROCK).map(
                                            Song::toString).forEach(out::println);
                                    case 2 -> spotify.filterSongsByGenre(Filters.MusicalGenre.REGGAETON).map(
                                            Song::toString).forEach(out::println);
                                    case 3 -> spotify.filterSongsByGenre(Filters.MusicalGenre.POP).map(
                                            Song::toString).forEach(out::println);
                                    case 4 -> spotify.filterSongsByGenre(Filters.MusicalGenre.TROPICAL).map(
                                            Song::toString).forEach(out::println);
                                    case 5 -> spotify.filterSongsByGenre(Filters.MusicalGenre.ELECTRONIC).map(
                                            Song::toString).forEach(out::println);
                                    case 6 -> spotify.filterSongsByGenre(Filters.MusicalGenre.RAP).map(
                                            Song::toString).forEach(out::println);
                                    case 7 -> spotify.filterSongsByGenre(Filters.MusicalGenre.CLASSIC).map(
                                            Song::toString).forEach(out::println);
                                    case 8 -> spotify.filterSongsByGenre(Filters.MusicalGenre.SALSA).map(
                                            Song::toString).forEach(out::println);
                                    case 9 -> spotify.filterSongsByGenre(Filters.MusicalGenre.TRAP).map(
                                            Song::toString).forEach(out::println);
                                    default -> spotify.filterSongsByGenre(Filters.MusicalGenre.REGGAE).map(
                                            Song::toString).forEach(out::println);
                                }
                                out.println("""
                                        What do you want to do?\s
                                        1.Repeat filter.\s
                                        2.Repeat library menu.
                                        3.Exit the library menu.\s
                                        Any other number: exit the application""");

                                exitMenu();

                            } else if(optionMenuLibrary == 3) {
                                spotify.sortSongsByDurationAscendant();
                                out.println(spotify.getSongs());
                                out.println("Do you want to sort them in descending order? \n1: Yes. \nCAny other number: No");
                                int optionSortReverse = answersNumber.nextInt();
                                if (optionSortReverse == 1) {
                                    spotify.sortSongsByDurationDescending();
                                    out.println(spotify.getSongs());
                                }
                                out.println("""
                                        What do you want to do?\s
                                        1.Repeat this functionality.\s
                                        2.Repeat library menu.
                                        3.Exit the library menu.\s
                                        Any other number: exit the application""");
                                exitMenu();

                            } else if(optionMenuLibrary == 4) {
                                spotify.sortSongsByDurationDescending();
                                out.println(spotify.getSongs());
                                out.println("Do you want to sort them in ascending order? \n1: Yes. \nCAny other number: No");
                                int optionSortReverse = answersNumber.nextInt();
                                if (optionSortReverse == 1) {
                                    spotify.sortSongsByDurationAscendant();
                                    out.println(spotify.getSongs());
                                }
                                out.println("""
                                        What do you want to do?\s
                                        1.Repeat this functionality.\s
                                        2.Repeat library menu.
                                        3.Exit the library menu.\s
                                        Any other number: exit the application""");
                                exitMenu();

                            } else if(optionMenuLibrary == 5) {
                                spotify.sortSongsByDateAscendant();
                                out.println(spotify.getSongs());
                                out.println("Do you want to sort them in descending order? \n1: Yes. \nCAny other number: No");
                                int optionSortReverse = answersNumber.nextInt();
                                if(optionSortReverse == 1){
                                    spotify.sortSongsByDateDescending();
                                    out.println(spotify.getSongs());
                                }
                                out.println("""
                                        What do you want to do?\s
                                        1.Repeat this functionality.\s
                                        2.Repeat library menu.
                                        3.Exit the library menu.\s
                                        Any other number: exit the application""");
                                exitMenu();

                            } else if (optionMenuLibrary == 6) {
                                spotify.sortSongsByDateDescending();
                                out.println(spotify.getSongs());
                                out.println("Do you want to sort them in ascending order? \n1: Yes. \nCAny other number: No");
                                int optionSortReverse = answersNumber.nextInt();
                                if (optionSortReverse == 1) {
                                    spotify.sortSongsByDateAscendant();
                                    out.println(spotify.getSongs());
                                }
                                out.println("""
                                        What do you want to do?\s
                                        1.Repeat this functionality.\s
                                        2.Repeat library menu.
                                        3.Exit the library menu.\s
                                        Any other number: exit the application""");
                                exitMenu();

                            } else {
                                exitLibraryMenu = false;
                                enterLibraryMenu = false;
                            }
                        } catch (Exception e) {
                            out.println("Wrong format or option. Date example: 1995/3/30.");
                            exitLibraryMenu = true;
                            answersNumber.next();
                        }
                    } while(exitLibraryMenu);
                } catch (Exception e) {
                    out.println("Wrong option.");
                    enterLibraryMenu = true;
                    answersNumber.next();
                }
            }
        }

    }

    /**
     * It refers to the method that optimizes the code to exit the control flows.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public static void exitMenu() {

        int optionNumberFilterDate = answersNumber.nextInt();
        if (optionNumberFilterDate == 1) {
            exitLibraryMenu = true;
        } else if (optionNumberFilterDate == 2) {
            exitLibraryMenu = false;
            enterLibraryMenu = true;
        } else if (optionNumberFilterDate == 3) {
            exitLibraryMenu = false;
            enterLibraryMenu = false;
        } else {
            exitLibraryMenu = false;
            enterLibraryMenu = false;
            enterApp = true;
        }
    }

    /**
     * Refers to the method that creates the playlists.
     *
     * @author Daniel, Agudelo - danielagudelo103@gmail.com
     *
     * @since 1.1.1
     */
    public static void createPlayList(String name) throws ParseException {
        PlayList newPlayList = new PlayList(name);
        out.println("Temporarily created playlist");
        out.println(spotify.getSongs());
        do {
            try {
                out.println("Look at the list of songs and choose in order from 0 to x which one you want to add." +
                        "\nExample: 0 = 'Welcome to Ibiza', 1 = 'The final Countdown', etc.");
                int option = answersNumber.nextInt();
                if (option < spotify.sizeListSongs()) {
                    for (int i = 0; i < spotify.sizeListSongs(); i++) {
                        if (i == option) {
                            if (newPlayList.getSongs().contains(spotify.getSong(i))) {
                                out.println("The song is already in the playlist.");
                                break;
                            } else if(spotify.getSongs().contains(spotify.getSong(i))) {
                                newPlayList.setSong(spotify.getSong(i));
                                break;
                            }
                        }
                    }
                    out.println("Do you want to add another song?: \n1.Yes. \nAny other number: No");
                    int optionNewSong = answersNumber.nextInt();
                    optionCreatePlayList = optionNewSong == 1;
                } else {
                    out.println("The song does not exist.");
                    optionCreatePlayList = true;
                }
            } catch (InputMismatchException e) {
                out.println("Enter numbers only.");
                optionCreatePlayList = true;
                answersNumber.next();
            }
        } while (optionCreatePlayList);
        out.println(newPlayList.getSongs());
        out.println("This is your list.");
        out.println("The list will be deleted, thank you for using the service.");

    }

}
