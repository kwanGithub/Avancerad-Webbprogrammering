package lab3v3;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class QuestionDataTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class QuestionDataTest
{
    /**
     * Default constructor for test class QuestionDataTest
     */
    public QuestionDataTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testgetCountryListSize()
    {
        lab3v3.QuestionData question1 = new lab3v3.QuestionData();
        assertEquals(10, question1.getcountryCapital());
    }

    @Test
    public void testshufflecountryCapital()
    {
        lab3v3.QuestionData question1 = new lab3v3.QuestionData();
        question1.shufflecountryCaptial();
    }
}


