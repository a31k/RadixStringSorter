package radixproject;

/**
 * Entry objects provide the client the ability to create a "node-based" 
 * abstract data type with each Entry node containing a reference to the 
 * next Entry, key data, and value data.
 * 
 * @author Drake Doss
 * @version 2018.06.12
 *
 * @param <K> The key type of this Entry.
 * @param <V> The value type of this Entry.
 */
public class Entry<K, V> {
	private Entry<K, V> nextEntry;
	private K key;
	private V value;
	
	/**
	 * Constructs a new Entry object with null values for all data fields.
	 */
	public Entry() {
		nextEntry = null;
		key = null;
		value = null;
	}
	
	/**
	 * Sets the key for this Entry.
	 * @param key The key data to be stored in this Entry.
	 */
	public void setKey(K key) {
		this.key = key;
	}
	
	/**
	 * Sets the value for this Entry.
	 * @param value The value data to be stored in this Entry.
	 */
	public void setValue(V value) {
		this.value = value;
	}
	
	/**
	 * Gets the key from this Entry.
	 * @return Returns the key data stored in this Entry.
	 */
	public K getKey() {
		return this.key;
	}
	
	/**
	 * Gets the value from this Entry.
	 * @return Returns the value data stored in this Entry.
	 */
	public V getValue() {
		return this.value;
	}
	
	/**
	 * Sets the nextEntry reference for this Entry.
	 * @param newEntry The next Entry object to be referenced by this
	 * Entry.
	 */
	public void setNext(Entry<K, V> newEntry) {
		nextEntry = newEntry;
	}
	
	/**
	 * Gets the nextEntry reference for this Entry.
	 * @return Returns the reference to the nextEntry of this Entry.
	 */
	public Entry<K, V> getNext() {
		return nextEntry;
	}
}
