package lab3v3;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is used to add Questions to the game
 * 
 * @author Kevin Truong
 * @version 1.3
 */
public class QuestionData
 {
    // List of questions
    protected ArrayList<CreateQuestion> countryCapital = new ArrayList<CreateQuestion>();
    /**
     * To initialized the questions utility.
     */
    public QuestionData() 
    {
        fillQuestions();
    }

    /**
     * To populate the List with questions.
     */
    private void fillQuestions() 
    {
        countryCapital.add(new CreateQuestion("Sweden", "STOCKHOLM"));
        countryCapital.add(new CreateQuestion("Spain", "MADRID"));
        countryCapital.add(new CreateQuestion("England", "LONDON"));
        countryCapital.add(new CreateQuestion("China", "BEIJING"));
        countryCapital.add(new CreateQuestion("U.S", "WASHINGTON"));
        countryCapital.add(new CreateQuestion("Norway", "OSLO"));
        countryCapital.add(new CreateQuestion("Italy", "ROME"));
        countryCapital.add(new CreateQuestion("Canada", "OTTAWA"));
        countryCapital.add(new CreateQuestion("Denmark", "COPENHAGEN"));
        countryCapital.add(new CreateQuestion("Holland", "AMSTERDAM"));
    }
    
    /**
     * Shuffles the ArrayList so that we may have random questions
     */
    protected void shufflecountryCaptial()
    {
        Collections.shuffle(countryCapital); 
    }
    
    /**
     * @return countryCaptil list size 
     */
    public int getcountryCapital()
    {
        return countryCapital.size();
    }
  
}
