import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class for selecting numbers using a number of criteria.
 */
public class NumberSelector {

    /**
     * Selects numbers that match the given criteria and returns the result.<br>
     * 
     * Example:<br>
     * numbers: 22, 11, 6, 43, 13, 7, 9<br>
     * value: 9<br>
     * lessThan: true<br>
     * equal: true<br>
     * moreThan: false<br>
     * returns a ArrayList that contains: 6, 7, 9<br>
     * 
     * @param numbers the numbers we are matching the criteria against 
     * @param value the number we are matching the other numbers against
     * @param lessThan true if all numbers less than value should be returned 
     * @param equal true if all numbers equal to value should be returned
     * @param moreThan true if all numbers more than value should be returned
     * @return all numbers that match the criteria
     */
    public ArrayList<Integer> selectNumbers(ArrayList<Integer> numbers, int value, boolean lessThan, boolean equal, boolean moreThan) 
    {
        //Skapar en array för att lagra numrena som ittereras igenom
        ArrayList<Integer> storedNumbers = new ArrayList<Integer>();
        
        //Skapar en iterator som skall iterera igenom numbersArrayList
        Iterator<Integer> iteratingNumbers = numbers.iterator();
        
        //skapar en integer vairabel
        Integer currentNumber;     
        
        //while loopen går så länge hasNext är true, att det fortfarande finns element i arrayListan
        while(iteratingNumbers.hasNext())
        {   
            //.next säger till att gå vidare till nästa i vårt fall nästa element. .next returnerar även värdet 
            // Detta väarde sparar vi i variablen currentNumber
            currentNumber = iteratingNumbers.next();
            
            // Om boolean värdet i lessThan blir true och att det finns nummer i currentNumber som är mindre än value.
            // så lagra dessa nummer i storedNumbers arrayListan.
            // Vi returnar storedNumbers.
            if (lessThan && currentNumber < value)
            {
             storedNumbers.add(currentNumber);    
            }          
            else if(equal && currentNumber == value)
            {
              storedNumbers.add(currentNumber);     
            }
            else if(moreThan && currentNumber > value)
            {
              storedNumbers.add(currentNumber);        
            }
        }
        return storedNumbers;
    }
}