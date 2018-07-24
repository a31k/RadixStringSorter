package radixproject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Entry class to ensure that it functions properly.
 * @author Drake Doss
 * @version 2018.07.24
 */
class EntryTest {
    
    private Entry<String, String> e;

    @BeforeEach
    /**
     * Sets up each test case.
     * @throws Exception Potential exception thrown by the method call.
     */
    void setUp() throws Exception {
        e = new Entry<String, String>();
    }


    @Test
    /**
     * Ensures that the Entry can set its key.
     */
    void testSetKey() {
        e.setKey("John");
        assertEquals(e.getKey(), "John");
    }
    
    @Test
    /**
     * Ensures that the Entry can set its value.
     */
    void testSetValue() {
        e.setValue("Smith");
        assertEquals(e.getValue(), "Smith");
    }
    
    @Test
    /**
     * Ensures that the Entry can provide its key to the client.
     */
    void testGetKey() {
        e.setKey("John");
        assertEquals(e.getKey(), "John");
    }
    
    @Test
    /**
     * Ensures that the Entry can provide its value to the client.
     */
    void testGetValue() {
        e.setValue("Smith");
        assertEquals(e.getValue(), "Smith");
    }
    
    @Test
    /**
     * Ensures that the Entry can set its next reference.
     */
    void testSetNext() {
        Entry<String, String> nextEntry = new Entry<String, String>();
        e.setNext(nextEntry);
        assertEquals(nextEntry, e.getNext());
    }
    
    @Test
    /*
     * Ensures that the Entry can provide its next reference to the client.
     */
    void testGetNext() {
        Entry<String, String> nextEntry = new Entry<String, String>();
        e.setNext(nextEntry);
        assertEquals(nextEntry, e.getNext());
    }

}
