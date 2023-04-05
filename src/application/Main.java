package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * This is the main class of the program
 * @author dylan, raphdejesus
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Scene1.fxml"));
			Scene scene = new Scene(root);
			String css = this.getClass().getResource("../view/application.css").toExternalForm();
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This public static void main method launches the GUI
	 * @param args lets any parameters pass as a list of String
	 */
	public static void main(String[] args) {
		launch(args);
	}
}