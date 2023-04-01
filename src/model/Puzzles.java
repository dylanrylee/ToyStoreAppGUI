package model;

/**
 * Puzzles subclass
 * @author raphaeldejesus, dylan
 *
 */
public class Puzzles extends Toy {

	/**
	 * This is the puzzle type
	 */
	private char puzzleType; 

	/**
	 * Initializes various fields and creates instance of class
	 * @param serial serial number of toy
	 * @param name name of toy
	 * @param brand brand name of toy
	 * @param price price of toy
	 * @param count stock count of toy
	 * @param minAge minimum age of toy
	 * @param puzzleType puzzle type of toy
	 */
    public Puzzles(String serial, String name, String brand, double price, int count, int minAge, char puzzleType) {
        super(serial, name, brand, price, count, minAge);
        setPuzzleType(puzzleType);
    }

    /**
     * Setter of puzzleType variable
     * @param puzzleType puzzle type of toy
     */
    public void setPuzzleType(char puzzleType) {
        this.puzzleType = puzzleType;
    }

    /**
     * Getter of puzzleType variable
     * @return returns current value of puzzleType variable
     */
    public char getPuzzleType() {
        return puzzleType;
    }


    /**
     * Converts instance of class into a string
     * @return instance of class as a string
     */
    public String toString() {
        return super.toString() + " Puzzle Type: " + puzzleType;
    }

    /**
     * Formats string into txt format
     * @return formatted string
     */
    public String formatString() {
        return super.formatString() + this.puzzleType;
    }

}