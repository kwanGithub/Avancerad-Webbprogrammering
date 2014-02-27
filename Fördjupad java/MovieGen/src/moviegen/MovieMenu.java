package moviegen;

import java.util.Scanner;

/**
 *
 * This the core of the application wheres the user interacts with the menu options
 *
 * @author kevin
 * @version 0.1
 */
public class MovieMenu
{

    private Scanner userInput = new Scanner(System.in);
    private MovieList movielist = new MovieList();
    // Securtiy for while loop
    private static final int MAX_NB_OF_TIMES = 0;
    private boolean continueMenu = true;

    public MovieMenu()
    {

    }

    /**
     * Prints the Main menu
     */
    public void printMenu()
    {
        {

            {
                String menu = "----------------------------------\n";
                menu += "1. Watch List of Movies\n";
                menu += "2. Add a Moive\n";
                menu += "3. Remove a Movie\n";
                menu += "----------------------------------\n";
                menu += "9. Exit\n";

                System.out.println(menu);

                System.out.println("What do your want to do?");

                try
                {
                    int userChoice = userInput.nextInt();
                    ShowMenuChoice(userChoice);
                    while (continueMenu)
                    {
                        back2MenuChoice();

                    }

                }
                catch (Exception e)
                {
                    System.out.println("Invalid input please en valid number");
                }
            }

        }

    }

    public void printMovieList()
    {
        movielist.printMovie();
    }

    /**
     *
     * @param userChoice is the choice whom the user have chosen
     */
    public void ShowMenuChoice(int userChoice)
    {
        if (userChoice == 1)
        {
            printMovieList();
        }
        else if (userChoice == 2)
        {
            addMovieChoice();
        }
        else if (userChoice == 3)
        {
            removeMovieChoice();
        }
        else if (userChoice == 9)
        {
            quitChoice();
        }
        else if (userChoice == 0)
        {
            printMenu();
        }
    }

    /**
     * Adds movies to the list
     */
    public void addMovieChoice()
    {   // Check listSisze
        int listSize = movielist.listSize();

        System.out.println("Title: ");
        // NextLine seems to jump a line, this workaround seems to help
        userInput.nextLine();
        String title = userInput.nextLine();

        System.out.println("Time: ");
        int time = Integer.parseInt(userInput.nextLine());

        System.out.println("genre: ");
        String genre = userInput.nextLine();

        System.out.println("Director: ");
        String director = userInput.nextLine();

        System.out.println("Age: ");
        int age = Integer.parseInt(userInput.nextLine());

        addMovie2List(title, time, genre, director, age);
        // Checks the listsize after adding
        int listSizeAfter = movielist.listSize();

        if (listSizeAfter > listSize)
        {
            System.out.println("Movie " + title + " have been successfully added");
        }
        else
        {
            System.out.println("I wasn´t Possible to add the Movie " + title);
        }

        //movielist.printMovie();
    }

    /**
     *
     * @param title Creates the movie title
     * @param time Sets the playtime for the movie
     * @param genre Sets the move genre
     * @param director Sets the director of the movie
     * @param age Sets the minium age for watching the movie
     */
    public void addMovie2List(String title, int time, String genre, String director, int age)
    {
        movielist.addMovie(title, time, genre, director, age);
    }

    /**
     * Removes movie files, and gives the user an Error message if the list is empty
     */
    public void removeMovieChoice()
    {   // Check listSize
        int listSize = movielist.listSize();

        if (listSize <= 0)
        {
            System.out.println("There is nothing to Erase! list has " + listSize + " of movies");
            back2MenuChoice();
        }

        System.out.println("Which movie do you want to erase?");
        movielist.getmovieTitle();
        System.out.println("Enter the movie number to erase: ");
        int nr2remove = userInput.nextInt();
        movielist.removeMovie(nr2remove);
        // Check the listsize after it have been removed
        int listSizeAfter = movielist.listSize();

        if (listSizeAfter < listSize)
        {
            System.out.println("Movie Number " + nr2remove + " have successfully been removed");
        }
        else
        {
            System.out.println("I wasn´t Possible to remove Movie number " + nr2remove);
        }

    }

    /**
     * Sub menu
     */
    public void back2MenuChoice()
    {

        try
        {
            System.out.println("0 = Back to HeadMenu\t9 = Exit program");
            int userChoice = userInput.nextInt();
            ShowMenuChoice(userChoice);
        }
        catch (Exception e)
        {
            System.out.println("Invalid input please enter a valid number");
        }
    }

    /**
     * Ends the application
     */
    public void quitChoice()
    {
        this.continueMenu = false;
        System.exit(0);
    }

}
