package radixproject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

/**
 *  This class tests the InputAnalyzer object to ensure that it functions
 *  properly.
 * @author Drake Doss
 * @version 07.23.2018
 *
 */
class InputAnalyzerTest {

    private InputAnalyzer analyzer;
    private String testString;
    
    
    @BeforeEach
    /**
     * Sets up each test case.
     * @throws Exception Potential exception thrown by the method call.
     */
    void setUp() throws Exception {
        
        testString = "Lopadotemachoselachogaleokranioleipsanodrimhypotrimmatosi"
            + "lphioparaomelitokatakechymenokichlepikossyphophattoperister is "
            + "a very fun string to sort, just like supercalifragilisticexpialidocious.";
        
        analyzer = new InputAnalyzer(new Scanner(testString), " ");
        
    }


    @Test
    /**
     * Tests the constructor, ensuring that it parses the input properly and
     * analyzes it correctly for the number of string elements, the greatest
     * number of places for each entry's key, and the entry keys themselves.
     * Tests each method of the InputAnalyzer class in one sweep, removing
     * the need for more test cases.
     */
    void testInputAnalyzer() {
        assertEquals(analyzer.getNumStrings(), 11);
        assertEquals(analyzer.getNumPlaces(), 3);
        assertEquals(analyzer.setKeyString(2), "002");
        assertEquals(analyzer.setKeyString(32), "032");
        assertEquals(analyzer.setKeyString(132), "132");
        
        try {
            new InputAnalyzer(null, " ");
        }
        catch (Exception e) {
            Exception exception = new IllegalArgumentException("No scanner found");
            assertEquals(e.getClass(), exception.getClass());
        }
        
        try {
            new InputAnalyzer(new Scanner("Hi"), null);
        }
        catch(Exception e) {
            Exception exception = new IllegalArgumentException("No delimiter found");
            assertEquals(e.getClass(), exception.getClass());
        }
    }

}
