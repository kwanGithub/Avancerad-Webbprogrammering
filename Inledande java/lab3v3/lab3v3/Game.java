package lab3v3;

import java.util.Scanner;

/**
 * Write a description of class Game here.
 * This class Starts the quiz game and measure stats
 * 
 * @author (Kevin Truong)
 * @version (1.3)
 */
public class Game 
{
    //If it happend that we ended up in endles loop this would stop it 
    private static final int MAX_NB_OF_GAMES = 10;
    private QuestionData questions = new QuestionData();
    private UserInteraction user = new UserInteraction();
    private Scanner scan = new Scanner(System.in);
    
    /**
     * Staring message
    */
    private void printWelcome() 
    {
        String welcome = "\t\t********************************************\n";
        welcome += "\t\t********************************************\n";
        welcome += "\t\t***** Welcome 2 Country And Captial*********\n";
        welcome += "\t\t********************************************\n";
        welcome += "\t\t********************************************\n\n";

        System.out.println(welcome);
    }

    /**
     * This is method starts the game process 
     */
    public void start() 
    {
        printWelcome();
        //While this is ture the game will contiure in the while loop
        boolean continueGame = true;

        int nbOfGame = 0;

        while (continueGame && nbOfGame <= MAX_NB_OF_GAMES) 
        {
            user.userNumberOfQuestions();
            stats();
            System.out.println("Do want another game?\nEnter: \n'Yes' to Continure \nor just press a key to Quit");
            String play = scan.nextLine().toLowerCase();
            if (play.equalsIgnoreCase("yes"))
            {
                continueGame = true;
                System.out.println("W00t you dare again!");
            }
            else
            {
                continueGame = false; 
                System.out.println("Cya Next time");
            }
        }
    }

    /**
     * To analyzes the game session.
     */
    private void stats() 
    {
        int correctAnswers = user.getNbCorrectAnswers();
        float percent = (correctAnswers * 100.0f) / user.getnbOfQuestions();       
        System.out.println("\nYou had " + percent + "% Correct answers\n");
    }

    
}
