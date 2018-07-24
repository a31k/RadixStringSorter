package radixproject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Drake Doss
 * @version 2018.07.24
 */
class QueueTest {
    
    private Queue q;
    private Entry<String, String> e;

    @BeforeEach
    /**
     * Sets up each test case.
     * @throws Exception Potential exception thrown by the method call.
     */
    void setUp() throws Exception {
        q = new Queue();
        e = new Entry<String, String>();
    }


    @Test
    /**
     * Ensures that the enqueue method functions properly.
     */
    void testEnqueue() {
        q.enqueue(e);
        assertFalse(q.isEmpty());
        assertEquals(q.getNumElements(), 1);
        assertEquals(e, q.dequeue());
    }
    
    @Test
    /**
     * Ensures that the queue understands what it means to be empty.
     */
    void testIsEmpty() {
        assertTrue(q.isEmpty());
       q.enqueue(e);
       assertFalse(q.isEmpty());
    }
    
    @Test
    /**
     * Ensures that the getNumElements method functions properly.
     */
    void testGetNumElements() {
        for (int i = 0; i < 10; i++) {
            q.enqueue(new Entry<String, String>());
        }
        assertEquals(q.getNumElements(), 10);
    }
    
    @Test
    /**
     * Ensures that the dequeue method functions properly.
     */
    void testDequeue() {
        q.enqueue(new Entry<String, String>());
        q.enqueue(new Entry<String, String>());
        Entry<String, String> e1 = q.dequeue();
        Entry<String, String> e2 = q.dequeue();
        assertNotNull(e1);
        assertNotNull(e2);
    }

}
