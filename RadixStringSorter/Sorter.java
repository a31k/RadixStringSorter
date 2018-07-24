package radixproject;

import java.util.Scanner;

/**
 * Sorter objects utilize and depend on InputAnalyzer objects to calculate
 * the largest String and the corresponding maximum number of places. Then,
 * the Sorter gives the client the ability to "initialize the buckets" of the radix
 * sort, complete the radix sort, and obtain the final result of the radix sort as
 * a String.
 * 
 * @author Drake Doss
 * @version 2018.07.24
 *
 */
public class Sorter {
	
	private Queue[] buckets;
	private InputAnalyzer analyzer;
	private Scanner sc;

	/**
	 * Constructs a new Sorter object which takes two Strings as parameters:
	 * one being the text a client wants to sort, the other being the delimiter
	 * the client would like to separate the sorting by.
	 * 
	 * @param textToSort The String sequence that is to be sorted.
	 * @param delimiter The delimiter to separate each String value.
	 */
	public Sorter(String textToSort, String delimiter) {
		buckets = new Queue[10];
		
		for (int i = 0; i < 10; i++) {
			buckets[i] = new Queue();
		}
		
		delimiter = parseDelimiterChoice(delimiter);
		analyzer = new InputAnalyzer(new Scanner(textToSort), delimiter);
		sc = new Scanner(textToSort);
		sc.useDelimiter(delimiter);
		if (delimiter == "Whitespace") {
		    sc.reset();
		}
		initializeBuckets();
	}
	
	/**
	 * Sorts all entries in each Queue of the array via the radix sort algorithm.
	 * Is recursively called for each place of the longest word, i.e. 3 times
	 * for a given input with a maximum length of 100 characters. The base case
	 * is defined as when there are no more sorting passes to make. A sorted
	 * array of Queue objects is returned for client access and output of results.
	 * @param numPlace The number of passes to make in the sorting process.
	 * @return Returns an array of Queues. Dequeuing from Queue 0-9 will provide
	 *         a completely sorted data set.
	 */
	public Queue[] sort(int numPlace) {
        
        while (numPlace != 0) {
        
            Queue[] temp = new Queue[10];
            
            for (int i = 0; i < 10; i++) {
                temp[i] = new Queue();
            }
        
            for (int i = 0; i <= 9; i++) {
                Queue cur = buckets[i];
                int numQueueElements = cur.getNumElements();
                
                for (int j = 0; j < numQueueElements; j++) {
                    Entry<String, String> entry = cur.dequeue();
                    String number = "" + entry.getKey().charAt(numPlace - 1);
                    Integer num = Integer.parseInt(number);
                   
                    temp[num].enqueue(entry);
                }
            }
            
            buckets = temp; // Make buckets reference temp for next pass.
            numPlace--;
        }
        return buckets;
    }
	
	/**
	 * Provides the client with a String representation of the sorted data,
	 * separated by a single space character.
	 * @return Returns a String of the sorted data.
	 */
	public String printOut() {
	    String result = "";
	    
		for (int i = 0; i <= 9; i++) {
			int numStrings = buckets[i].getNumElements();
			
			for (int j = 0; j < numStrings; j++) {
				String currentElement = buckets[i].dequeue().getValue();
				
				if (result == "") {
				    result += currentElement;
				}
				else {
				result += " " + currentElement;
				}
			}
		}
		return result;
	}
	
	/**
	 * Provides the client with a String representation of the sorted data,
	 * separated by newlines ("\n").
	 * @return
	 */
	public String printOutWithNewLine() {
	    String result = "";
	    
	    for (int i = 0; i <= 9; i++) {
	        int numStrings = buckets[i].getNumElements();
	        
	        for (int j = 0; j < numStrings; j++) {
	            String currentElement = buckets[i].dequeue().getValue();
	            
	            if (result == "") {
	                result += currentElement;
	            }
	            else {
	                result += "\n" + currentElement;
	            }
	        }
	    }
	    return result;
	}
	
	/**
	 * Gives the client access to the Sorter's InputAnalyzer.
	 * @return Returns the Sorter object's InputAnalyzer.
	 */
	public InputAnalyzer getAnalyzer() {
	    return analyzer;
	}
	
	/**
	 * Must be called before any other sorting activity save for accessing the
	 * Sorter's InputAnalyzer. Places the analyzer's Strings in the Queue of 
	 * index 0 in their original order as Entry objects. 
	 */
	private void initializeBuckets() {
		int numWords = analyzer.getNumStrings();
		for (int i = 0; i < numWords; i++) {
		    
			Entry<String, String> newEntry = new Entry<String, String>();
			String nextWord = sc.next();
			String wordLength = analyzer.setKeyString(nextWord.length());
			
			newEntry.setKey(wordLength);
			newEntry.setValue(nextWord);
			buckets[0].enqueue(newEntry);
		}
	}
	
	/**
	 * Allows the GUI to prompt the user for a delimiter which is not
	 * provided in a character set. The delimiter will be assigned in a
	 * character set to prevent odd behavior by the scanner.
	 */
	private String parseDelimiterChoice(String delimiter) {
	    String result = "";
	    
	    // Check if the delimiter is whitespace
	    boolean isWhitespace = delimiter == "Whitespace" ? true: false;
	    if (isWhitespace)
	        return delimiter;
	    
	    // Check if the delimiter is a symbol + whitespace
	    switch (delimiter) {
	        case ". *": result += "[. *]";
            break;
            case "\\ *": result += "[\" *]";
            break;
            case ", *": result += ", *";
            break;
            case "| *": result += "[| *]";
            break;
	    }
	    
	    // Check if the delimiter is a symbol with no whitespace
	    switch(delimiter) {
	        case ".": result += "[.]";
	        break;
	        case "\\": result += "\\\\";
	        break;
	        case ",": result += ",";
	        break;
	        case "|": result += "[|]";
	        break;
	    }
	    
	    return result;
	}
}
