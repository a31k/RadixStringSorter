package radixproject;

/**
 * A Queue abstract data type which allows the client to enqueue Entries,
 * dequeue Entries, get the number of Entries, and see if the Queue is
 * empty.
 * 
 * @author Drake Doss
 * @version 2018.06.12
 */
public class Queue {
	
	private Entry<String, String> firstEntry;
	private Entry<String, String> lastEntry;
	private int numElements;
	
	/**
	 * Constructs a Queue object, setting the first entry to null and the
	 * last entry as a reference to the first entry as an initial state.
	 * The initial number of elements in the Queue, naturally, is 0.
	 */
	public Queue() {
		firstEntry = null;
		lastEntry = firstEntry;
		numElements = 0;
	}
	
	/**
	 * Places an Entry at the "front" of the Queue. If the Queue is empty,
	 * the first and last Entry reference fields point to the new Entry.
	 * Otherwise, the lastEntry's nextEntry reference field is set to
	 * the new Entry; then, lastEntry is set to reference the new Entry.
	 * In both cases, the number of elements is incremented.
	 * 
	 * @param newEntry The new Entry to be added to the Queue.
	 */
	public void enqueue(Entry<String, String> newEntry) {
		if (isEmpty()) {
			firstEntry = newEntry;
			lastEntry = firstEntry;
		}
		else {
		    lastEntry.setNext(newEntry);
		    lastEntry = newEntry;
		}
		numElements++;
	}
	
	/**
	 * Removes an entry from the "front" of the Queue. If the Queue is empty,
	 * an IllegalStateException is thrown.
	 * 
	 * @return Returns the dequeued Entry.
	 */
	public Entry<String, String> dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("No elements in queue");
		}
		Entry<String, String> removedEntry = firstEntry;
		firstEntry = firstEntry.getNext();
		numElements--;
		return removedEntry;
	}
	
	/**
	 * Returns true or false if this Queue is empty or not.
	 * @return True if the number of Elements is 0, false otherwise.
	 */
	public boolean isEmpty() {
		return numElements == 0;
	}
	
	/**
	 * Gives the client access to the number of elements in this Queue.
	 * @return Returns the number of elements in this Queue.
	 */
	public int getNumElements() {
		return numElements;
	}
	
	
}
