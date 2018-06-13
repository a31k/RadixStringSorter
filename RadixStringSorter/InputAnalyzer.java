package radixproject;

import java.util.Scanner;

/**
 * InputAnalyzer objects find the largest string in a given input,
 * then calculate the number of passes required for a least-significant
 * digit (LSD) radix sort. The number of passes is equal to the number
 * of places for each string. 
 * @author Drake Doss
 * @version 2018.06.12
 *
 */
public class InputAnalyzer {
	
	private int longest;
	private String input;
	private int numPlaces;
	private int numStrings;
	
	/**
	 * Constructs a new InputAnalyzer object which takes a Scanner object
	 * containing the data to be parsed as well as the scanner's desired
	 * delimiter.
	 * @param sc The Scanner object containing the data to be parsed.
	 * @param delimiter The delimiter to be used in conjunction with the Scanner.
	 */
	public InputAnalyzer(Scanner sc, String delimiter) {
		if (sc == null) {
			throw new IllegalArgumentException("No input found");
		}
		input = "";
		sc.useDelimiter(delimiter);
		if (delimiter == "Whitespace") {
            sc.reset();
        }
		parseInput(sc);
		numPlaces = calculateNumPlaces(longest);
	}
	
	/**
	 * Obtains a full string representation of the given text
	 * through a Scanner. Also counts the total number of strings within
	 * the text separated by whitespace (e.g., "Hi, hello" -> numStrings = 2)
	 * @param sc The Scanner object containing data to be parsed.
	 */
	private void parseInput(Scanner sc) {
		while (sc.hasNext()) {
			String next = sc.next();
			numStrings++;
			
			if (next.length() > longest) {
				longest = next.length();
			}
			
			input += next;
		}
	}
	
	/**
	 * Gives the client access to the input text.
	 * @return The input text.
	 */
	public String getString() {
		return input;
	}
	
	/**
	 * Gives the client access to the total number of string elements.
	 * @return The total number of strings from the given text.
	 */
	public int getNumStrings() {
		return numStrings;
	}
	
	/**
	 * Gives the client access to the number of places (or "word length")
	 * each string's length key should have.
	 * @return Returns the number of places for each key.
	 */
	public int getNumPlaces() {
	    return numPlaces;
	}
	
	/**
	 * Prepares each string's length key for radix sorting by appending the
	 * appropriate number of zeros before each length value, i.e...
	 * 
	 * longestString = "baby" -> length 4
	 * string = "got" -> length 3 --> numPlaces = 0, therefore string's length
	 * is still 3.
	 * 
	 * longestString = "a hundred million" -> length 17
	 * string = "back" -> length 4 --> numPlaces = 1, therefore string's length
	 * is modified to be 2 ("04").
	 * 
	 * longestString = [100 character string] -> length 100
	 * string = "fast racecar" -> length 12 -> length 12 --> numPlaces = 2,
	 * therefore string's length is modified to be 4 ("0012"). However, since
	 * we only can use radix sort for keys with the same number of places,
	 * "0012" must be reduced to "012" so that it can have three corresponding
	 * sorting passes with "100".
	 * 
	 * @param key The key to be evaluated for the correct number of places.
	 * @return Returns the key with the correct number of places so that it
	 * may be placed in the map.
	 */
	public String setKeyString(int key) {
		if (key == longest) {
			return key + ""; //this is the longest string, no need for further calc.
		}
		
		StringBuilder result = new StringBuilder(); //uses less memory
		for (int i = 1; i < numPlaces; i++) {
			result.append("0");
		}
		
		result.append(key);
		String str = result.toString();
		String biggest = "" + longest;
		if (str.length() > biggest.length()) {
		    int diff = str.length() - biggest.length();
		    return str.substring(diff);
		}
		return str;
	}
	
	/**
	 * Gives the client access to the maximum number of
	 * digits each string's key should have. For example,
	 * if the largest string has 34 characters, then a
	 * string of length 4 will be assigned a key of 04.
	 * @return Returns the maximum number of places each string's
	 *         key should have.
	 * @param length The length of the longest String given by the Scanner.
	 */
	public int calculateNumPlaces(int length) {
		if (length < 10) {
			return 1;
		}
		else {
			length = length - (length % 10);
			return calculateNumPlaces(length / 10) + 1;
		}
	}
	
}
