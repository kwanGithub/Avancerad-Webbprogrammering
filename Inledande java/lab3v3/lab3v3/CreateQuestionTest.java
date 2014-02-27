package lab3v3;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CreateQuestionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CreateQuestionTest
{
    /**
     * Default constructor for test class CreateQuestionTest
     */
    public CreateQuestionTest()
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
    public void testgetCaptial()
    {
        lab3v3.CreateQuestion createQu1 = new lab3v3.CreateQuestion("Japan", "TOKYO");
        assertEquals("TOKYO", createQu1.getCapital());
    }

    @Test
    public void testgetCountry()
    {
        lab3v3.CreateQuestion createQu1 = new lab3v3.CreateQuestion("Norway", "OSLO");
        assertEquals("Norway", createQu1.getCountry());
    }
}


