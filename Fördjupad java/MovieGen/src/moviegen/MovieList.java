package moviegen;

import java.util.ArrayList;

/**
 *
 * This class handles the list it adds, removes and fills the list with content
 *
 * @author kevin truong
 * @version 0.1
 */
public class MovieList
{

    private ArrayList<Movie> movies = new ArrayList<Movie>();

    /**
     * Prints out the movies in the moviesList
     */
    public MovieList()
    {
        fillMovies();
    }

    /**
     * Iterates through the movies list and pick out each elemnt to print
     */
    public void printMovie()
    {
        for (Movie movie : movies)
        {
            System.out.println(movie);
        }
    }

    /**
     *
     * @param title Creates the movie title
     * @param time Sets the playtime for the movie
     * @param genre Sets the move genre
     * @param director Sets the director of the movie
     * @param age Sets the minium age for watching the movie
     */
    public void addMovie(String title, int time, String genre, String director, int age)
    {
        movies.add(new Movie(title, time, genre, director, age));
    }

    public void getmovieTitle()
    {
        for (int i = 0; i < movies.size(); i++)
        {
            System.out.println("----------- " + "Movie number: " + i + " ------------\n" + "Title: "
                    + movies.get(i).getTitle());
        }
    }

    /**
     *
     * @return returns the arraylist size
     */
    public int listSize()
    {
        return movies.size();
    }

    /**
     *
     * @param nr2remove is the movie whom the user have decided to delete
     */
    public void removeMovie(int nr2remove)
    {
        movies.remove(nr2remove);

    }

    /**
     * Purpose for this method is to fill our list with content
     */
    private void fillMovies()
    {
        movies.add(new Movie("Thor: The Dark World", 112, "Adventure", "Alan Taylor", 12));
        movies.add(new Movie("jOBS", 128, "Drama", "Joshua Michael Stern", 5));
        movies.add(new Movie("Gravity", 91, "Thriller", "Alfonso Cuarón", 11));
        movies.add(new Movie("The Hunger Games: Catching Fire", 146, "Action", "Francis Lawrence", 11));
        movies.add(new Movie("Enders´s Game", 112, "Sci-Fi", "Gavin Hood", 11));
    }

}
