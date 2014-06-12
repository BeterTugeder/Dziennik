package pl.projekt5.dziennik;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.projekt5.models.Uczen;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void TestNauczyciel(){
        Uczen uczenTest = new Uczen(1, "asd", "asd");
        assertEquals(uczenTest.imie,"asd");
        assertEquals(uczenTest.id, 1);
    }
}
