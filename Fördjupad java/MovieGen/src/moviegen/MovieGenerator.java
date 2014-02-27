package moviegen;

/**
 *
 * This class starts the applikation, main is setup in this class
 *
 * @author kevin
 * @version 0.1
 */
public class MovieGenerator
{

    public MovieGenerator()
    {
        MovieMenu menu = new MovieMenu();

        printeWelcomeMessage();
        menu.printMenu();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args)
    {
        MovieGenerator moviegenerator = new MovieGenerator();
    }

    /**
     * Prints a welcome message
     */
    public void printeWelcomeMessage()
    {
        String welcome = "HI and Weclome to MovieGenerator!\n";

        System.out.println(welcome);
    }

}
