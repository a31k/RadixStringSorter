package radixproject;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Sorter class to ensure it functions
 * properly.
 * @author Drake
 * @version 2018.07.23
 */
class SorterTest {

    private Sorter sorter;
    private String testString;
    private String stringResult;
    
    @BeforeEach
    /**
     * Sets up each test case.
     * @throws Exception Potential exception thrown by the method call.
     */
    void setUp() throws Exception {
        testString = "Lopadotemachoselachogaleokranioleipsanodrimhypotrimmatosi"
            + "lphioparaomelitokatakechymenokichlepikossyphophattoperister is "
            + "a very fun string to sort, just like supercalifragilisticexpialidocious.";
        sorter = new Sorter(testString, "Whitespace");
        stringResult = "a is to fun very just like sort, string "
            + "supercalifragilisticexpialidocious. Lopadotemachosela"
            + "chogaleokranioleipsanodrimhypotrimmatosilphiopara"
            + "omelitokatakechymenokichlepikossyphophattoperister";
    }


    @Test
    /**
     * Ensures that the getAnalyzer method functions properly.
     */
    void testGetAnalyzer() {
        InputAnalyzer ia = new InputAnalyzer(new Scanner(""), " ");
        assertNotNull(sorter.getAnalyzer());
        assertEquals(sorter.getAnalyzer().getClass(), ia.getClass());
    }
    
    @Test
    /**
     * Ensures that the sort method sorts the string by wordlength using the
     * radix sort algorithm.
     */
    void testSort() {
        InputAnalyzer analyzer = sorter.getAnalyzer();
        Queue[] q = sorter.sort(analyzer.getNumPlaces());
        String sorted = "";
        
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                sorted += q[0].dequeue().getValue();
            }
            sorted += " " + q[0].dequeue().getValue();
        }
        sorted += " " + q[1].dequeue().getValue();
        String sortedString = "a is to fun very just like sort, string "
            + "supercalifragilisticexpialidocious. Lopadotemachosela"
            + "chogaleokranioleipsanodrimhypotrimmatosilphiopara"
            + "omelitokatakechymenokichlepikossyphophattoperister";
        assertEquals(sorted, sortedString);
    }
    
    @Test
    /**
     * Ensures that the sorter will provide a sorted string delimited by
     * whitespace.
     */
    void testPrintOut() {
        sorter.sort(sorter.getAnalyzer().getNumPlaces());
        String sorted = sorter.printOut();
        assertEquals(sorted, stringResult);
    }
    
    @Test
    /**
     * Ensures that the sorter will provide a sorted string delimited by
     * new lines.
     */
    void testPrintOutWithNewLine() {
        sorter.sort(sorter.getAnalyzer().getNumPlaces());
        String sorted = "a\nis\nto\nfun\nvery\njust\nlike\nsort,\nstring\n"
            + "supercalifragilisticexpialidocious.\nLopadotemachosela"
            + "chogaleokranioleipsanodrimhypotrimmatosilphiopara"
            + "omelitokatakechymenokichlepikossyphophattoperister";
        String sortedNewLine = sorter.printOutWithNewLine();
        assertEquals(sorted, sortedNewLine);
    }

}
