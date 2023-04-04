package exceptions;

/**
 * The PriceNotPositive class represents an exception that is thrown when the input price
 * is a negative
 * @author raphaeldejesus
 *
 */
public class PriceNotPositive extends Exception {
	
	/**
	 * Creates a PriceNotPositive object with a default error message
	 */
	public PriceNotPositive() {
		super("Error: Number cannot be negative");
	}
	
	/**
	 * Creates a PriceNotPositive object with an error message containing the number input
	 * @param num price number input
	 */
	public PriceNotPositive(String num) {
		super("Error: Number is: " + num);
		
	}
	
	/**
	 * Returns the error message associated with the PriceNotPositive object
	 * @return error message
	 */
	public String getMessage() {
		return super.getMessage();
	}
}