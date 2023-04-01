package model;

/**
 * Animals subclass
 * @author raphaeldejesus, dylan
 *
 */
public class Animals extends Toy{

	/**
	 * This is the material of the toy
	 */
    private String material; 
    
    /**
     * This is the size of the toy
     */
    private char size; 

    /**
     * Initializes various fields and creates instance of class
     * @param serial serial number of toy 
     * @param name name of toy
     * @param brand brand name of toy
     * @param price price of toy
     * @param count stock count of toy
     * @param minAge minimum age of toy
     * @param material material of toy
     * @param size size of toy
     */
    public Animals(String serial, String name, String brand, double price, int count, int minAge, String material, char size) {
        super(serial, name, brand, price, count, minAge);
        setMaterial(material);
        setSize(size);
    }

    /**
     * Setter for material variable
     * @param material material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Getter for material variable
     * @return returns current value of material variable
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Setter for size variable
     * @param size size
     */
    public void setSize(char size) {
        this.size = size;
    }

    /**
     * Getter for size variable
     * @return returns current value of size variable
     */
    public char getSize() {
        return size;
    }

    /**
     * Converts instance of class into a string
     * @return instance of class into a string
     */
    public String toString() {
        return super.toString() + " Material: " + material + " Size: " + size;
    }

    /**
     * Formats instance of class into txt format
     * @return returns formatted string
     */
    public String formatString() {
        return super.formatString() + this.material+';'+this.size;
    }
}