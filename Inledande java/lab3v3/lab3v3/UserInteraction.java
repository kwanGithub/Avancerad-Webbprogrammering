package lab3v3;

import java.util.Scanner;
/**
 * This is the core of the game where questions and user interacts.
 * 
 * @author (Kevin Truong) 
 * @version (1.3)
 */
public class UserInteraction
{
    private QuestionData questions = new QuestionData();
    //Nb of correct answers
    private int nbOfQuestions;
    //Nb of correctAnwers
    private int correctAnswers = 0;
    private Scanner scan = new Scanner(System.in);
    
     
    /**
     * 
     * Ask a question to the user.
     * @param i is same i from the for loop i > nbOfQuestions. 
     */
    private void askQuestion(int i) 
    {
        //Shuffles the list 
        questions.shufflecountryCaptial();
        //Generates a question
        CreateQuestion questionToAsk = questions.countryCapital.get(i);
        // Asks the user a question
        System.out.println("\nWhat's the capital of " + questionToAsk.getCountry() + " ?");                    
        Scanner scan = new Scanner(System.in);
        String userAnswer = scan.nextLine().toUpperCase();
            
        if (userAnswer.equals(questionToAsk.getCapital())) 
        {
            System.out.println(userAnswer + "\nThat´s Correct you actually know shit! ");
            correctAnswers++;
        }
        else 
        {
            System.out.println(userAnswer + "\nThat´s InCorrect ! The right answer should be " + questionToAsk.getCapital()+ "\n");
        }                      
    }  
    
    /**
     * To ask the user to choose the number of questions he would like.
     */
    protected void userNumberOfQuestions() 
    {
        int maxNbOfQuestions = questions.getcountryCapital();
        nbOfQuestions = 0;
        // Reset the number of correct answers
        resetNbCorrectAnswers();
        questions.shufflecountryCaptial();

        do 
        {
            System.out.println("How many Country Capital questions would you prefer 1 to " + maxNbOfQuestions + "?");
            nbOfQuestions = scan.nextInt();
            if (nbOfQuestions > 10 || nbOfQuestions <= 0)
            {
                System.out.println("Please choose a number betwwen 1 and 10\n");
            }
                        
        } while (nbOfQuestions > maxNbOfQuestions || nbOfQuestions <= 0);
        // Takes int i as a parameter to use as for iterating through the arrayList
        for (int i = 0; i < nbOfQuestions; i++) 
        {
            askQuestion(i);
        }
    }
   
    /**
     * @return the number of correct answers.
     */
    protected int getNbCorrectAnswers() 
    {
        return correctAnswers;
    }

    /**
     * This resets the number of correct answers.
     * This has to be called before starting a new game.
     */
    protected void resetNbCorrectAnswers() 
    {
        correctAnswers = 0;
    }
    
    /**
     * @reurn nbOfQuestions number of questions
     */
    public int getnbOfQuestions()
    {
        return nbOfQuestions;
    }
    
 }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


