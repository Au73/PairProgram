package Au73.PairProgram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
        String[] test= {"-n","10","-r","30"};
    	PairPro.main(test);
    }
    
    public void test1() {
    	System.out.println("test");
        String[] test= {"-e","10","-a","30"};
    	PairPro.main(test);
    }

    public void test2() {
    	System.out.println("test");
        String[] test= {"-e","10000"};
    	PairPro.main(test);
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
}
