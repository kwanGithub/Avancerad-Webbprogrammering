package moviegen;

/**
 *
 * This class defines how a movie object should look like
 *
 * @author kevin
 * @version 0.1
 *
 */
public class Movie
{

    private int time;
    private int age;

    private String title;
    private String genre;
    private String director;

    public Movie()
    {
        this.time = 0;
        this.age = 0;
        this.title = "";
        this.genre = "";
        this.director = "";
    }

    /**
     * To create a movie these parameters must be associated
     *
     * @param title Creates the movie title
     * @param time Sets the playtime for the movie
     * @param genre Sets the move genre
     * @param director Sets the director of the movie
     * @param age Sets the minium age for watching the movie
     */
    public Movie(String title, int time, String genre, String director, int age)
    {
        this.title = title;
        this.time = time;
        this.genre = genre;
        this.director = director;
        this.age = age;
    }

    /**
     *
     * @return returns string format for the object
     */
    public String toString()
    {
        String mtitle = "Title:\t  " + title;
        String mtime = "\nTime:\t  " + time + " minutes";
        String mgenre = "\nGenre:\t  " + genre;
        String mdirector = "\nDirector: " + director;
        String mage = "\nage:\t  " + "From " + age + " years";
        mage += "\n------------------------------------------------";
        return mtitle + mtime + mgenre + mdirector + mage;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String gentre)
    {
        this.genre = gentre;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

}
