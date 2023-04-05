package view;

import java.io.IOException;

import java.util.logging.*;

/**
 * This is the logging class for the program
 * @author dylan
 *
 */

public class Logging {
	
	/**
	 * This private final static variable is a Logger object
	 */
	private final static Logger LOGR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * This public void method loads the log file and updates it 
	 * if there are new updates
	 */
	public void loadLog() {
		try {
			FileHandler fh = new FileHandler("res/log.log", true);
			fh.setLevel(Level.ALL);
			LOGR.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	/**
	 * This public void method updates the log file and the console if a toy has
	 * been purchased
	 * @param toyName is the name of the toy
	 */
	public void logPurchase(String toyName) {
		String update = "One of " + toyName + " has been purchased";
		LOGR.info(update);
	}

	/**
	 * This public void method updates the log file and the console if a toy has
	 * been removed
	 * @param toyName is the name of the toy
	 */
	public void logRemove(String toyName) {
		String update = toyName + " has been removed from the database";
		LOGR.info(update);
	}

	/**
	 * This public void method updates the log file and the console if a toy has
	 * been added
	 * @param toyName is the name of the toy
	 */
	public void logAdd(String toyName) {
		String update = toyName + " has been added into the database";
		LOGR.info(update);
	}
}
