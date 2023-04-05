package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import model.Animals;
import model.BoardGames;
import model.Figures;
import model.Puzzles;
import model.Toy;
import exceptions.MinGreaterThanMax;
import exceptions.PriceNotPositive;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import view.AppMenu;
import view.Logging;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * This is the manager class that controls everything. 
 * It consists of event handlers for buttons as well
 * @author dylan, raph
 *
 */
public class Manager implements Initializable{

	/**
	 * This is the serial number radio button
	 */
	@FXML
	private RadioButton snRadioButton = new RadioButton();

	/**
	 * This is the name radio button
	 */
	@FXML
	private RadioButton nameRadioButton = new RadioButton();

	/**
	 * This is the type radio button
	 */
	@FXML
	private RadioButton typeRadioButton = new RadioButton();

	/**
	 * This is the serial number text field
	 */
	@FXML
	private TextField snTextField = new TextField();

	/**
	 * This is the name text field
	 */
	@FXML
	private TextField nameTextField = new TextField();

	/**
	 * This is the type text field
	 */
	@FXML
	private TextField typeTextField = new TextField();

	/**
	 * This is the remove toy serial number text field
	 */
	@FXML
	private TextField removeToyTextField = new TextField();

	/**
	 * This is the search button
	 */
	@FXML
	private Button searchButton = new Button();

	/**
	 * This is the remove button
	 */
	@FXML
	private Button removeButton = new Button();
	
	/**
	 * This is the button for buying the selected toy
	 */
	@FXML
	private Label purchasedToyLabel = new Label();

	/**
	 * This is the error label in the remove toy tab
	 */
	@FXML
	private Label removeToyError = new Label();

	/**
	 * This is the removed toy label
	 */
	@FXML
	private Label removedToyLabel = new Label();

	/**
	 * This is the error label for the search tab
	 */
	@FXML
	private Label searchErrorLabel = new Label();

	/**
	 * This is the list view for the searched toys
	 */
	@FXML
	private ListView<Toy> lvToys = new ListView<Toy>();;

	/**
	 * This is the list view for the searched toys in the remove toy
	 */
	@FXML
	private ListView<Toy> lvRemovedToys = new ListView<Toy>();
	
	/**
	 * This is the choice box for which category is wished to be added
	 */
	@FXML
    private ChoiceBox<String> toyCategory;
	
	/**
	 * This is the String list for the toy categories
	 */
    private String[] toyCat = {"Animals", "Board Games", "Figures", "Puzzles"};

    /**
     * This is the text field for adding serial number
     */
    @FXML
    private TextField addSNText = new TextField();

    /**
     * This is the text field for adding toy name
     */
    @FXML
    private TextField addNameText = new TextField();

    /**
     * This is the text field for adding toy brand
     */
    @FXML
    private TextField addBrandText = new TextField();

    /**
     * This is the text field for adding toy price
     */
    @FXML
    private TextField addPriceText = new TextField();

    /**
     * This is the text field for adding toy stock amount
     */
    @FXML
    private TextField addCountText = new TextField();

    /**
     * This is the text field for adding age appropriate for toy
     */
    @FXML
    private TextField addAgeText = new TextField();

    /**
     * This is the text field for adding toy classification
     */
    @FXML
    private TextField toyClassification = new TextField();

    /**
     * This is the text field for adding puzzle type
     */
    @FXML
    private TextField puzzleType = new TextField();

    /**
     * This is the text field for adding toy size
     */
    @FXML
    private TextField toySize = new TextField();

    /**
     * This is the text field for adding toy material
     */
    @FXML
    private TextField toyMaterialText = new TextField();

    /**
     * This is the text field for adding minimum amount of player
     */
    @FXML
    private TextField toyMinText = new TextField();

    /**
     * This is the text field for adding maximum amount of player
     */
    @FXML
    private TextField toyMaxText = new TextField();

    /**
     * This is the text field for adding toy designer
     */
    @FXML
    private TextField toyDesignerText = new TextField();

    /**
     * This is the dialog pane for figure
     */
    @FXML
    private DialogPane figurePane = new DialogPane();

    /**
     * This is the dialog pane for animal
     */
    @FXML
    private DialogPane animalPane = new DialogPane();

    /**
     * This is the dialog pane for board game
     */
    @FXML
    private DialogPane boardGamePane = new DialogPane();

    /**
     * This is the dialog pane for puzzle
     */
    @FXML
    private DialogPane puzzlePane = new DialogPane();

    /**
     * This is the Label to show the addition of toy is successful
     */
    @FXML
    private Label addSuccessLabel = new Label();

	/**
	 * This is the file path of the program
	 */
	private final String FILE_PATH = "res/toys.txt"; // file path

	/**
	 * This initializes the appMenu object
	 */
	private AppMenu appMenu;

	/**
	 * This initializes new array list for the toys
	 */
	private ArrayList<Toy> toys; // toys array list

	/**
	 * This is the array list is for the searched up toys thats viewed in the list view
	 */
	private ArrayList<Toy> searchedToys;

	/**
	 * This is the array list for the searched up toys to remove
	 */
	private ArrayList<Toy> searchRemoveToys;
	/**
	 * This initializes the Logging object
	 */
	private Logging log;

	/**
	 * This is the manager constructor 
	 */
	public Manager() {
		toys = new ArrayList<Toy>();
		searchedToys = new ArrayList<Toy>();
		searchRemoveToys = new ArrayList<Toy>();
		appMenu = new AppMenu();
		log = new Logging();
		loadData();
		log.loadLog();

	}

	/**
	 * This public void method goes through the file txt database and creates a new
	 * Toy object with the information given for the toys in the file. It creates a
	 * new object depending on the kind of toy it is and it does so through
	 * Polymorphism. It then adds the toy within the array list.
	 */
	private void loadData() {
		String currentLine;
		String[] splittedLine;

		try {
			File db = new File(FILE_PATH);

			if (db.exists()) {
				Scanner fileReader = new Scanner(db);

				while (fileReader.hasNextLine()) {
					currentLine = fileReader.nextLine();
					splittedLine = currentLine.split(";");

					String serialNumber = splittedLine[0];
					char digit = serialNumber.charAt(0);

					if (digit == '0' || digit == '1') {
						String figureName = splittedLine[1];
						String figureBrand = splittedLine[2];
						double figurePrice = Double.parseDouble(splittedLine[3]);
						int figureCounts = Integer.parseInt(splittedLine[4]);
						int figureAge = Integer.parseInt(splittedLine[5]);
						char figureClassification = splittedLine[6].charAt(0);
						Toy f = new Figures(serialNumber, figureName, figureBrand, figurePrice, figureCounts, figureAge,
								figureClassification);
						toys.add(f);

					} else if (digit == '2' || digit == '3') {
						String animalName = splittedLine[1];
						String animalBrand = splittedLine[2];
						double animalPrice = Double.parseDouble(splittedLine[3]);
						int animalCounts = Integer.parseInt(splittedLine[4]);
						int animalAge = Integer.parseInt(splittedLine[5]);
						String animalMaterial = splittedLine[6];
						char animalSize = splittedLine[7].charAt(0);
						Toy a = new Animals(serialNumber, animalName, animalBrand, animalPrice, animalCounts, animalAge,
								animalMaterial, animalSize);
						toys.add(a);
					} else if (digit == '4' || digit == '5' || digit == '6') {
						String puzzleName = splittedLine[1];
						String puzzleBrand = splittedLine[2];
						double puzzlePrice = Double.parseDouble(splittedLine[3]);
						int puzzleCounts = Integer.parseInt(splittedLine[4]);
						int puzzleAge = Integer.parseInt(splittedLine[5]);
						char puzzleType = splittedLine[6].charAt(0);
						Toy p = new Puzzles(serialNumber, puzzleName, puzzleBrand, puzzlePrice, puzzleCounts, puzzleAge,
								puzzleType);
						toys.add(p);
					} else if (digit == '7' || digit == '8' || digit == '9') {
						String bgName = splittedLine[1];
						String bgBrand = splittedLine[2];
						double bgPrice = Double.parseDouble(splittedLine[3]);
						int bgCounts = Integer.parseInt(splittedLine[4]);
						int bgAge = Integer.parseInt(splittedLine[5]);
						String bgNum = splittedLine[6];
						String bgDesigners = splittedLine[7];
						Toy bg = new BoardGames(serialNumber, bgName, bgBrand, bgPrice, bgCounts, bgAge, bgNum,
								bgDesigners);
						toys.add(bg);
					}
				}
				fileReader.close();

			}

		} catch (FileNotFoundException e) {
			e.getMessage();
		}

	}
	
	/**
	 * This public void method initializes the toy category, making the choice box to be able to run
	 */
	public void initialize(URL arg0, ResourceBundle arg1) {
        toyCategory.getItems().addAll(toyCat);
        toyCategory.setOnAction(this::pickToy);
    }

	/**
	 * This private method searches the toy type. It creates a substitute array list
	 * type Toy that stores the matching searched toy type within this list.
	 */
	private void searchToyType() {
		lvToys.getItems().clear();
		char toyType = typeTextField.getText().charAt(0); // This prompts the toy type input

		int toyCounter = 0; // this initializes the toy counter for numbering how many toys there are
		for (int i = 0; i <= toys.size() - 1; i++) { // this for loop adds the toys depending on their type in to the //
														// list
			if (toys.get(i) instanceof Animals && toyType == 'a') {
				searchedToys.add(toys.get(i));
				toyCounter++;
			} else if (toys.get(i) instanceof BoardGames && toyType == 'b') {
				searchedToys.add(toys.get(i));
				toyCounter++;
			}

			else if (toys.get(i) instanceof Figures && toyType == 'f') {
				searchedToys.add(toys.get(i));
				toyCounter++;
			}

			else if (toys.get(i) instanceof Puzzles && toyType == 'p') {
				searchedToys.add(toys.get(i));
				toyCounter++;
			}
		}

		if (toyCounter == 0 && toyType != 'a' && toyType != 'b' && toyType != 'f' && toyType != 'p') {
			searchErrorLabel.setText(appMenu.displayError(3));
		}

		ObservableList<Toy> ol = FXCollections.observableArrayList(searchedToys);
		lvToys.getItems().addAll(ol);

	}

	/**
	 * This private void method searches the toy based on the name inputed in the
	 * promptToyName method.
	 */
	private void searchToyName() {
		lvToys.getItems().clear();

		int toyCounter = 0; // this initializes the toy counter for numbering how many toys there are

		String toyName = nameTextField.getText(); // this prompts the toy name to search in the database

		for (int i = 0; i <= toys.size() - 1; i++) { // this for loop increments the amount of toys there are that
														// matches the searched name, and it also adds it into the
														// created array list
			if (toys.get(i).getName().toLowerCase().contains(toyName.toLowerCase())) {
				searchedToys.add(toys.get(i));
				toyCounter++;
			}
		}
		if (toyCounter == 0) {
			searchErrorLabel.setText(appMenu.displayError(2));
		}

		ObservableList<Toy> ol = FXCollections.observableArrayList(searchedToys);
		lvToys.getItems().addAll(ol);

	}

	/**
	 * This private void method searches a toy based on their serial number prompted
	 * in the promptToySerial method
	 */
	private void searchSerialNumber() {
		lvToys.getItems().clear();
		String toySerial = snTextField.getText(); // this prompts the toy serial that the user is searching for
		int toyCounter = 0; // this initializes the toy counter for numbering how many toys there are
		char[] chars = toySerial.toCharArray();
		
		for (int i = 0; i <= toys.size() - 1; i++) { // this adds the matched toys into the array list, while
														// incrementing the amountOfToys variable
			if (toys.get(i).getSerial().contains(toySerial)) {
				searchedToys.add(toys.get(i));
				toyCounter++;
			}
		}

		for (char c : chars) {
			if (!Character.isDigit(c) && toyCounter == 0) {
				searchErrorLabel.setText(appMenu.displayError(4));
			} else if (Character.isDigit(c) && toyCounter == 0) {
				searchErrorLabel.setText(appMenu.displayError(2));
			}
		}
		

		ObservableList<Toy> ol = FXCollections.observableArrayList(searchedToys);
		lvToys.getItems().addAll(ol);

	}

	/** 
	 * This private void method runs the search methods, depending on which radio button is pressed
	 * @param event is the event of the search button
	 */
	@FXML
	private void search(ActionEvent event) {
		searchErrorLabel.setText("");
		searchedToys.clear();
		if (typeRadioButton.isSelected()) {
			nameTextField.setEditable(false);
			snTextField.setEditable(false);
			typeTextField.setEditable(true);
			searchToyType();
		}
		if (nameRadioButton.isSelected()) {
			typeTextField.setEditable(false);
			snTextField.setEditable(false);
			nameTextField.setEditable(true);
			searchToyName();
		}
		if (snRadioButton.isSelected()) {
			typeTextField.setEditable(false);
			nameTextField.setEditable(false);
			snTextField.setEditable(true);
			searchSerialNumber();
		}

	}

	/**
	 * This private void method clears the text fields, and the list view and the 
	 * purchased toy label, and the error label in the search tab
	 * @param event is the event of the clear button
	 */ 
	@FXML
	private void clear(ActionEvent event) {
		lvToys.getItems().clear();
		typeTextField.clear();
		nameTextField.clear();
		snTextField.clear();
		searchErrorLabel.setText("");
		purchasedToyLabel.setText("");
	}

	/**
	 * This private void method sets the searchErrorLabel text field as empty.
	 * It collects the selected toy from the list view and checks if the toy
	 * matches any of the toys in the original Toy array list, and then it 
	 * subtracts the toy's stock by one.
	 * @param event is the event of the buy button in the search toy tab in the GUI
	 */
	@FXML
	private void purchase(ActionEvent event) {
		searchErrorLabel.setText("");
		int selectedToy = lvToys.getSelectionModel().getSelectedIndex();
		int newCount = searchedToys.get(selectedToy).getCount() - 1;

		if (searchedToys.get(selectedToy).getCount() == 0) {
			purchasedToyLabel.setText(appMenu.showNoToysLeft());

		} else if (searchedToys.get(selectedToy).getCount() > 0) {
			for (int i = 0; i <= toys.size() - 1; i++) {
				if (toys.get(i).formatString().equals(searchedToys.get(selectedToy).formatString())) {
					toys.get(i).setCount(newCount);
					log.logPurchase(searchedToys.get(selectedToy).getName());
				}
			}
			searchedToys.get(selectedToy).setCount(newCount);
			purchasedToyLabel.setText(appMenu.displayCompletedPurchase(searchedToys.get(selectedToy).getName()));
		}
		saveProgress();

	}

	/**
	 * This private void method will remove a toy from the database. It will require
	 * the exact serial number in order to find the toy to delete
	 */
	private void removeToy() {
		searchRemoveToys.clear();
		String toySerial = removeToyTextField.getText(); // this takes in the prompted serial number
		String serialNumberCollected = "";

		if (toySerial.length() != 10) {
			removeToyError.setText(appMenu.displayError(1));

		}
		for (int i = 0; i <= toys.size() - 1; i++) { // this for loop goes through the whole original toys list to
														// see
														// if the searched serial number is equal to any of them
			if (toys.get(i).getSerial().equals(toySerial)) {
				searchRemoveToys.add(toys.get(i));
				serialNumberCollected = toys.get(i).getSerial();

				ObservableList<Toy> ol = FXCollections.observableArrayList(searchRemoveToys);
				lvRemovedToys.getItems().addAll(ol);
			}

		}

		if (toySerial.length() == 10 && !serialNumberCollected.equals(toySerial)) { // this checks if the serial
																					// number// the database
			removeToyError.setText(appMenu.displayError(2));
			return;
		}
	}

	/**
	 * This private void method clears the searchRemoveToys array list
	 * and it calls the removeToy() method
	 * @param event is the event of the search button in the remove toy tab in the GUI
	 */
	@FXML
	private void searchToRemove(ActionEvent event) {
		searchRemoveToys.clear();
		lvRemovedToys.getItems().clear();
		removeToyError.setText("");
		removeToy();
	}

	/**
	 * This private void method removes the toy from the original 
	 * Toy array list, and then updates the database with the
	 * new changes afterwards
	 * @param event is the event of the remove button in the remove toy tab in the GUI
	 */
	@FXML
	private void remove(ActionEvent event) {
		String name = "";
		int selectedToy = lvToys.getSelectionModel().getSelectedIndex();

		for (int i = 0; i <= toys.size() - 1; i++) {
			if (toys.get(i).equals(searchRemoveToys.get(selectedToy + 1))) {
				removedToyLabel.setText(appMenu.displayRemovedToy(toys.get(i).getName()));
				name = appMenu.displayRemovedToy(toys.get(i).getName());
				toys.remove(i);
			}
		}
		saveProgress();
		log.logRemove(name);
	}
	
	/**
	 * This private void method adds a brand new toy into the 
	 * database, and it takes in every textfield input to create
	 * the toy info
	 * @param e is the event handle of the save button in add toy tab in GUI
	 */

	@FXML
	private void addToy(ActionEvent e) {
		
		try {
			
			String myToyCategory = toyCategory.getValue();
			String serialNum = addSNText.getText();
			String name = addNameText.getText();
			String brand = addBrandText.getText();
			String p = addPriceText.getText();
			String c = addCountText.getText();
			String a = addAgeText.getText();
			double price = Double.parseDouble(p);
			int count = Integer.parseInt(c);
			int age = Integer.parseInt(a);
			
			boolean isValidSerial = true;
			
			if (price < 0) {
				throw new PriceNotPositive();
			}
			
			if (count <0) {
				addSuccessLabel.setText("");
				addSuccessLabel.setText("Error: Stock amount is less than 0");
				addSuccessLabel.setStyle("-fx-text-fill: red;");
				return;
			}
			
			if (age <0) {
				addSuccessLabel.setText("");
				addSuccessLabel.setText("Error: Minimum age is less than 0");
				addSuccessLabel.setStyle("-fx-text-fill: red;");
				return;
			}
			
			if (serialNum.isEmpty()) {
				addSuccessLabel.setText("");
				addSuccessLabel.setText("Error: Serial number cannot be blank");
				addSuccessLabel.setStyle("-fx-text-fill: red;");
				addSNText.clear();
			}
			
			if (myToyCategory.equals("Figures") && (serialNum.charAt(0) == '0' || serialNum.charAt(0) == '1')) {
				
				if (serialNum.length() != 10) {
				    addSuccessLabel.setText("");
				    addSuccessLabel.setText("That is not a 10 digit serial number!");
				    addSuccessLabel.setStyle("-fx-text-fill: red;");
				    return;
				}
	
				if (!serialNum.matches("[0-9]+")) {
				    addSuccessLabel.setText("");
				    addSuccessLabel.setText("The serial number cannot contain letters.");
				    addSuccessLabel.setStyle("-fx-text-fill: red;");
				    return;
				}
	
				for (int i = 0; i < toys.size(); i++) {
				    if (toys.get(i).getSerial().equals(serialNum)) {
				        addSuccessLabel.setText("");
				        addSuccessLabel.setText("That serial number is already being used!");
				        addSuccessLabel.setStyle("-fx-text-fill: red;");
				        return;
				    }
				}
				
				char toyClass = toyClassification.getText().toUpperCase().charAt(0);
				Figures figureToy = new Figures(serialNum, name, brand, price, count, age, toyClass);
				toys.add(figureToy);
				log.logAdd(figureToy.getName());

				
			}
			
			else if (myToyCategory.equals("Animals") && (serialNum.charAt(0) == '2' || serialNum.charAt(0) == '3')) {
				
				if (serialNum.length() != 10) {
				    addSuccessLabel.setText("");
				    addSuccessLabel.setText("That is not a 10 digit serial number!");
				    addSuccessLabel.setStyle("-fx-text-fill: red;");
				    return;
				}
	
				if (!serialNum.matches("[0-9]+")) {
				    addSuccessLabel.setText("");
				    addSuccessLabel.setText("The serial number cannot contain letters.");
				    addSuccessLabel.setStyle("-fx-text-fill: red;");
				    return;
				}
	
				for (int i = 0; i < toys.size(); i++) {
				    if (toys.get(i).getSerial().equals(serialNum)) {
				        addSuccessLabel.setText("");
				        addSuccessLabel.setText("That serial number is already being used!");
				        addSuccessLabel.setStyle("-fx-text-fill: red;");
				        return;
				    }
				}
				
				String material = toyMaterialText.getText();
				char size = toySize.getText().toUpperCase().charAt(0);
				Animals animalToy = new Animals(serialNum, name, brand, price, count, age, material, size);
				toys.add(animalToy);
				log.logAdd(animalToy.getName());

			}
			
			else if (myToyCategory.equals("Puzzles") && (serialNum.charAt(0) == '4' || serialNum.charAt(0) == '5' || serialNum.charAt(0) == '6')) {
	
				if (serialNum.length() != 10) {
				    addSuccessLabel.setText("");
				    addSuccessLabel.setText("That is not a 10 digit serial number!");
				    addSuccessLabel.setStyle("-fx-text-fill: red;");
				    return;
				}
	
				if (!serialNum.matches("[0-9]+")) {
				    addSuccessLabel.setText("");
				    addSuccessLabel.setText("The serial number cannot contain letters.");
				    addSuccessLabel.setStyle("-fx-text-fill: red;");
				    return;
				}
	
				for (int i = 0; i < toys.size(); i++) {
				    if (toys.get(i).getSerial().equals(serialNum)) {
				        addSuccessLabel.setText("");
				        addSuccessLabel.setText("That serial number is already being used!");
				        addSuccessLabel.setStyle("-fx-text-fill: red;");
				        return;
				    }
				}
				
				char puzzleT = puzzleType.getText().toUpperCase().charAt(0);
				Puzzles puzzleToy = new Puzzles(serialNum, name, brand, price, count, age, puzzleT);
				toys.add(puzzleToy);
				log.logAdd(puzzleToy.getName());

			}
			
			else if (myToyCategory.equals("Board Games") && (serialNum.charAt(0) == '7' || serialNum.charAt(0) == '8' || serialNum.charAt(0) == '9')) {
	
				if (serialNum.length() != 10) {
				    addSuccessLabel.setText("");
				    addSuccessLabel.setText("That is not a 10 digit serial number!");
				    addSuccessLabel.setStyle("-fx-text-fill: red;");
				    return;
				}
	
				if (!serialNum.matches("[0-9]+")) {
				    addSuccessLabel.setText("");
				    addSuccessLabel.setText("The serial number cannot contain letters.");
				    addSuccessLabel.setStyle("-fx-text-fill: red;");
				    return;
				}
	
				for (int i = 0; i < toys.size(); i++) {
				    if (toys.get(i).getSerial().equals(serialNum)) {
				        addSuccessLabel.setText("");
				        addSuccessLabel.setText("That serial number is already being used!");
				        addSuccessLabel.setStyle("-fx-text-fill: red;");
				        return;
				    }
				}
				
				int minPlayers = Integer.parseInt(toyMinText.getText());
				int maxPlayers = Integer.parseInt(toyMaxText.getText());
				
				if (minPlayers > maxPlayers) {
					throw new MinGreaterThanMax();
				}
		
				String designer = toyDesignerText.getText();
				String toyMinMax = minPlayers + "-" + maxPlayers;
				BoardGames boardGameToy = new BoardGames(serialNum, name, brand, price, count, age, toyMinMax, designer);
				
				toys.add(boardGameToy);
				log.logAdd(boardGameToy.getName());
				
			} else {
				isValidSerial= false;
			}
			
			if (isValidSerial) {
				addSuccessLabel.setText("");
				addSuccessLabel.setText("You have successfully added: " + name);
				addSuccessLabel.setStyle("-fx-text-fill: green;");
			} else {
				addSuccessLabel.setText("");
		        addSuccessLabel.setText("Error: Serial number and category do not match");
		        addSuccessLabel.setStyle("-fx-text-fill: red;");
			}
			
		} catch (PriceNotPositive ex) {
			addSuccessLabel.setText("");
	        addSuccessLabel.setText(ex.getMessage());
	        addSuccessLabel.setStyle("-fx-text-fill: red;");
	        
		} catch (MinGreaterThanMax ex) {
			addSuccessLabel.setText("");
	        addSuccessLabel.setText(ex.getMessage());
	        addSuccessLabel.setStyle("-fx-text-fill: red;");
		} catch (NumberFormatException ex) {
	        addSuccessLabel.setText("");
	        addSuccessLabel.setText("Error: Price/count/age must be numbers or they cannot be empty.");
	        addSuccessLabel.setStyle("-fx-text-fill: red;");
	        
		} 
		catch (StringIndexOutOfBoundsException ex) {
            addSuccessLabel.setText("");
            addSuccessLabel.setText("Error: One or more toy attributes are missing.");
            addSuccessLabel.setStyle("-fx-text-fill: red;");
        }
		saveProgress();
	}
	
	/**
	 * This disables the access to some of the additional information
	 * depending on what time of toy is picked in the category
	 * @param event is the event of the choice box
	 */
	
	private void pickToy(ActionEvent event) {

        String myToyCategory = toyCategory.getValue();

        if (myToyCategory == "Animals") {
            toyClassification.setEditable(false);
            puzzleType.setEditable(false);
            toyMaterialText.setEditable(true);
            toySize.setEditable(true);
            toyMinText.setEditable(false);
            toyMaxText.setEditable(false);
            toyDesignerText.setEditable(false);
        }
        else if (myToyCategory == "Board Games") {
            toyClassification.setEditable(false);
            puzzleType.setEditable(false);
            toyMaterialText.setEditable(false);
            toySize.setEditable(false);
            toyMinText.setEditable(true);
            toyMaxText.setEditable(true);
            toyDesignerText.setEditable(true);
        }
        else if (myToyCategory == "Figures") {
            toyClassification.setEditable(true);
            puzzleType.setEditable(false);
            toyMaterialText.setEditable(false);
            toySize.setEditable(false);
            toyMinText.setEditable(false);
            toyMaxText.setEditable(false);
            toyDesignerText.setEditable(false);
        }
        else if (myToyCategory == "Puzzles") {
            toyClassification.setEditable(false);
            puzzleType.setEditable(true);
            toyMaterialText.setEditable(false);
            toySize.setEditable(false);
            toyMinText.setEditable(false);
            toyMaxText.setEditable(false);
            toyDesignerText.setEditable(false);
        }

    }
	
	/**
	 * This enables and disables certain text fields when
	 * the serial number radio button is clicked	
	 * @param event is the event of the radio button
	 */
	@FXML
    private void snSelected(ActionEvent event) {
        if (snRadioButton.isSelected()) {
            snTextField.setEditable(true);
            nameTextField.setEditable(false);
            typeTextField.setEditable(false);
    		typeTextField.clear();
    		nameTextField.clear();
    		searchErrorLabel.setText("");
        }
    }
	
	/**
	 * This enables and disables certain text fields when
	 * the name radio button is clicked	
	 * @param event is the event of the radio button
	 */
    @FXML
    private void nameSelected(ActionEvent event) {
        if (nameRadioButton.isSelected()) {
            snTextField.setEditable(false);
            nameTextField.setEditable(true);
            typeTextField.setEditable(false);
            typeTextField.clear();
    		snTextField.clear();
    		searchErrorLabel.setText("");
        }
    }

	/**
	 * This enables and disables certain text fields when
	 * the type radio button is clicked	
	 * @param event is the event of the radio button
	 */
    @FXML
    private void typeSelected(ActionEvent event) {
        if (typeRadioButton.isSelected()) {
            snTextField.setEditable(false);
            nameTextField.setEditable(false);
            typeTextField.setEditable(true);
            snTextField.clear();
    		nameTextField.clear();
    		searchErrorLabel.setText("");
        }
    }
	/**
	 * This private void method updates the database 
	 * with the new changes such as removing toy, purchasing toy, or 
	 * adding toy
	 */
	private void saveProgress() {
		try {
			FileWriter fw = new FileWriter(FILE_PATH, false);
			PrintWriter appendToy = new PrintWriter(fw);
			for (Toy toy : toys) {
				String newToy = toy.formatString();
				appendToy.println(newToy);
			}
			appendToy.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.loadLog();
	}
}
