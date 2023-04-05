package exceptions;

/**
 * The MinGreaterThanMax class represents an exception that is thrown when the minimum amount of players is greater
 * than the maximum amount of players
 * @author raphaeldejesus
 *
 */
public class MinGreaterThanMax extends Exception {
	
	/**
	 * Creates a MinGreatThanMax object with a default error message
	 */
	public MinGreaterThanMax() {
		super("Error: Minimum players cannot be greater than Maximum!");
	}
	
	/**
	 * Creates a MinGreaterThanMax object with a specific error message containing the minimum number of players
	 * @param num minimum number of players
	 */
	public MinGreaterThanMax(String num) {
		super("Error: Minimum players is " + num);
	}
	
	/**
	 * Returns the error message associated with the MinGreaterThanMax object
	 * @return returns error message
	 */
	public String getMessage() {
		return super.getMessage();
	}

}