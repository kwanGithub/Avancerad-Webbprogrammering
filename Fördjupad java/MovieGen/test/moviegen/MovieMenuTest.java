/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviegen;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kevin
 */
public class MovieMenuTest
{

    private MovieMenu instance;

    public MovieMenuTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
        MovieMenu instance = new MovieMenu();
    }

    /**
     * Test of printMovieList method, of class MovieMenu.
     */
    @Test
    public void testPrintMenuist()
    {
        System.out.println("printMenu");
        instance.printMenu();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * User choice
     */
    @Test
    public void testUserChoice()
    {

    }

    @After
    public void tearDown()
    {
    }

}
