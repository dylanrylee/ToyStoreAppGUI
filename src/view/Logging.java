package view;
import java.util.logging.*;

public class Logging {
	private final static Logger LOGR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public String logPurchase(String toyName) {
		String update = "One of " + toyName + " has been purchased";
		LOGR.log(Level.INFO, update);
		return update;
	}
	
	public String logRemove(String toyName) {
		String update = toyName + " has been removed from the database";
		LOGR.log(Level.INFO, update);
		return update;
	}
	
	public String logAdd(String toyName) {
		String update = toyName + " has been added into the database";
		LOGR.log(Level.INFO, update);
		return update;
	}
}
