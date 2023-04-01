package model;

/**
 * Toy parent class
 * @author raphaeldejesus, dylan
 *
 */
public class Toy {

	/**
	 * This is where the Serial number is stored
	 */
    private String serial; //serial number
    
    /**
     * This is where the name of toy is stored
     */
    private String name; //name of toy
    
    /**
     * This is where the brand of toy is stored
     */
    private String brand; //brand name of toy
    
    /**
     * This is where the price of toy is stored
     */
    private double price; //price of toy
    
    /**
     * This is where the stock amount of toy is stored
     */
    private int count; //stock count of toy
    
    /**
     * This is where the minimum age for toy is stored
     */
    private int minAge; //minimum age of toy

    /**
     * Initializes various fields and creates instance of the class
     * @param serial serial number of toy
     * @param name name of toy
     * @param brand brand name of toy
     * @param price price of toy
     * @param count stock count of toy
     * @param minAge minimum age of toy
     */
    public Toy(String serial, String name, String brand, double price, int count, int minAge) {
        setSerial(serial);
        setName(name);
        setBrand(brand);
        setPrice(price);
        setCount(count);
        setMinAge(minAge);
    }

    /**
     * Setter for serial number
     * @param serial serial number of toy
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * Getter for serial number
     * @return returns current value of serial 
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Setter for name
     * @param name name of toy
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for name
     * @return returns current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for brand name
     * @param brand brand name of toy
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter for brand name
     * @return returns current value of brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter for price
     * @param price is the price of they toy
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter for price
     * @return returns current value of price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for stock count
     * @param stockAmount stock count
     */
    public void setCount(int stockAmount) {
        this.count = stockAmount;
    }
    
    /**
     * Getter for stock count
     * @return returns current value of count
     */
    public int getCount() {
        return count;
    }

    /**
     * Setter for minimum age
     * @param minAge minimum age
     */
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    /**
     * Getter for minimum age
     * @return returns current value of minAge
     */
    public int getMinAge() {
        return minAge;
    }

    /**
     * Converts instance of class into a string
     */
    public String toString() {
        return " Serial: " + serial + " Name: " + name + " Brand: "
                + brand + " Price: " + price + " Amount: " + count + " Minimum age: " + minAge;
    }

    /**
     * Converts instance of class into txt format
     * @return returns formatted string
     */
    public String formatString() {
        return this.serial+';'+this.name+';'+this.brand+';'+this.price+';'+this.count+';'+this.minAge+';';
    }

}
		