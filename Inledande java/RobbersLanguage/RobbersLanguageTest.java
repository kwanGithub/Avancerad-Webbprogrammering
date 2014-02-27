

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * The test class RobbersLanguageTest.
 *
 * @author  Kevin Truong
 * @version 2013-10-06
 */
public class RobbersLanguageTest
{
    /**
     * Default constructor for test class RobbersLanguageTest
     */
    public RobbersLanguageTest()
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
     * Testing diffrent words/characters on the method
     */
    @Test
    public void VerifyTranslateAlphabet()
    {
        for(int i = 0; i < 50; i++)
        {
            RobbersLanguage robbersL1 = new RobbersLanguage();
            assertEquals("abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovwowxoxyzoz", 
            robbersL1.translate("abcdefghijklmnopqrstuvwxyz"));
            assertEquals("bob", robbersL1.translate("b"));
            
        }
    }
    
    /**
     * Testing that it doesnt translate swedish ö
     */
    @Test
    public void VerifySpecialCharacters()
    {
        for(int i = 0; i < 50; i++)
        {  
            RobbersLanguage robbersL1 = new RobbersLanguage();
            assertEquals("åöä!#¤%&/()=?", robbersL1.translate("åöä!#¤%&/()=?"));
        }
    }
    
    /**
     * Testing that its not null
     */
    @Test
    public void VerifyNotNull()
    {
        for(int i = 0; i < 50; i++)
        {
         RobbersLanguage robbersL2 = new RobbersLanguage();
         assertNotNull(robbersL2.translate("r"));
        }
    }
    
    /**
     * Testing to see if it translates numbers
     */
    @Test
    public void VerifyPossbleToSendNumbers()
    {   for(int i = 0; i < 50; i++)
        {
            RobbersLanguage robbersL2 = new RobbersLanguage();
            assertEquals("0123456789", robbersL2.translate("0123456789"));
        }
    }  
       
    @After
    public void teardown()
    {    
    }

}







