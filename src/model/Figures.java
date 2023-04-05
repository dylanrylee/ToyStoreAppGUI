package model;

/**
 * Figures subclass
 * @author raphaeldejesus, dylan
 *
 */
public class Figures extends Toy {

	/**
	 * Classification of toy
	 */
    private char classification;

    /**
     * Initializes various fields and creates instance of class
     * @param serial serial number of toy
     * @param name name of toy
     * @param brand brand name of toy
     * @param price price of toy
     * @param count stock count of toy
     * @param minAge minimum age of toy 
     * @param classification classification of toy
     */
    public Figures(String serial, String name, String brand, double price, int count, int minAge, char classification) {
        super(serial, name, brand, price, count, minAge);
        setClassification(classification);
    }

    /**
     * Setter for classification variable 
     * @param classification classification of toy 
     */
    public void setClassification(char classification) {
        this.classification = classification;
    }

    /**
     * Getter for classification variable 
     * @return returns current value of classification variable
     */
    public char getClassification() {
        return classification;
    }

    /**
     * Converts instance of class to string
     * @return returns instance coverted to string
     */
    public String toString() {
        return " Type: Figures" + super.toString() + " Classification: " + classification;
    }

    /**
     * Formats instance of class into txt file format
     * @return returns formatted string
     */
    public String formatString() {
        return super.formatString() + this.classification;
    }
}