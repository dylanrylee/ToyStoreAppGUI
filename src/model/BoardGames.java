package model;

/**
 * Board game subclass
 * @author raphaeldejesus, dylan
 *
 */
public class BoardGames extends Toy {

	/**
	 * This is the number of players
	 */
    private String numOfPlayers; 
    
    /**
     * This is the designer(s) of the toy
     */
    private String designer; 

    /**
     * Initializes various fields and creates instance of the class
     * @param serial serial number of toy
     * @param name name of toy
     * @param brand brand name of toy
     * @param price price of toy
     * @param count count of toy
     * @param minAge minimum age of toy
     * @param numOfPlayers number of players of toy
     * @param designer designer(s) of toy
     */
    public BoardGames(String serial, String name, String brand, double price, int count, int minAge, String numOfPlayers, String designer) {
        super(serial, name, brand, price, count, minAge); 
        setDesigner(designer); 
        setNumOfPlayers(numOfPlayers);
    }

    /**
     * Setter for number of players
     * @param numOfPlayers number of players
     */
    public void setNumOfPlayers(String numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    /**
     * Getter for number of players 
     * @return returns current value of numOfPlayers
     */
    public String getNumOfPlayers() {
        return this.numOfPlayers;
    }

    /**
     * Setter for designer
     * @param designer is the designer(s) of the toy
     */
    public void setDesigner(String designer) {
        this.designer = designer;
    }

    /**
     * Getter for designer
     * @return returns current value of designer
     */
    public String getDesigner() {
        return designer;
    }

    /**
     * Converts instance of the class into a string
     */
    public String toString() {
        String result = "";

        if (numOfPlayers.contains("-")) {
        	String[] splittedLine = numOfPlayers.split("-");
            result = " Type: Board Game" + super.toString() + " Min: " + splittedLine[0] + " Max: " + splittedLine[1] + " Designer: " + designer;
        }
        else if (!numOfPlayers.contains("-")) {
            result = " Type: Board Game" + super.toString() + " Min: " + numOfPlayers + " Designer: " + designer;
        }
		return result;
    }

    /**
     * Converts string into txt file format
     * @return formatted string
     */
    public String formatString() {
        return super.formatString() + this.numOfPlayers+';'+this.designer;
    }

}