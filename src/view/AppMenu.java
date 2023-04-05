package view;

/**
 * This is where we print and output in the console
 * 
 * @author dylan, raph
 *
 */
public class AppMenu {
	
	/**
	 * This public string method displays which toy is purchased
	 * @param toyName is the name of the toy
	 * @return he string that says you have purchased the toy
	 */
	public String displayCompletedPurchase(String toyName) {
		return "You have purchased: " + toyName;
	}
	
	/**
	 * This public string method displays which toy is removed in the GUI.
	 * @param toyName is the name of the toy
	 * @return the string that says you have removed the toy
	 */
	public String displayRemovedToy(String toyName) {
		return "You have removed: " + toyName;
	}
	
	/**
	 * This public string method displays certain types of errors into the GUI.
	 * @param errorNum is the erorr number chosen for the specific type of error
	 * @return the error string 
	 */
	public String displayError(int errorNum) {
		String error = "";
		switch (errorNum) {
		case 1: 
			error = "The length of the Serial Number\nhas to be 10";
			break;
		case 2:
			error = "This toy does not exist in the database";
			break;
		case 3: 
			error = "This is not one of the toy types";
			break;
		case 4: 
			error = "The serial number should\nnot consist of any letters";
			break;
		case 5: 
			error = "The serial number cannot be empty";
			break;
		
		}

		return error;
	}
	
	/**
	 * This public String method displays that there are no more stock for the toy
	 * @return the string that displays that there are no more stock for the toy
	 */
	public String showNoToysLeft() {
		return "Sorry, unfortunately we are\nout of stock for this toy";
	}

}
