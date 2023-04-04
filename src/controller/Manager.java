package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import view.AppMenu;
import view.Logging;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * 
 * @author dylan, raph
 *
 */
public class Manager {

	@FXML
	private RadioButton snRadioButton = new RadioButton();

	@FXML
	private RadioButton nameRadioButton = new RadioButton();

	@FXML
	private RadioButton typeRadioButton = new RadioButton();

	@FXML
	private TextField snTextField = new TextField();

	@FXML
	private TextField nameTextField = new TextField();

	@FXML
	private TextField typeTextField = new TextField();

	@FXML
	private TextField removeToyTextField = new TextField();

	@FXML
	private Button searchButton = new Button();

	@FXML
	private Button removeButton = new Button();

	@FXML
	private Label purchasedToyLabel = new Label();

	@FXML
	private Label removeToyError = new Label();

	@FXML
	private Label removedToyLabel = new Label();

	@FXML
	private Label searchErrorLabel = new Label();

	@FXML
	private ListView<Toy> lvToys = new ListView<Toy>();;

	@FXML
	private ListView<Toy> lvRemovedToys = new ListView<Toy>();

	/**
	 * This is the file path of the program
	 */
	private final String FILE_PATH = "res/toys.txt"; // file path

	/**
	 * This is the log path of the program
	 */
	private final String LOG_PATH = "res/log.txt";

	/**
	 * This initializes the appMenu object
	 */
	private AppMenu appMenu;

	/**
	 * This initializes new array list for the toys
	 */
	private ArrayList<Toy> toys; // toys array list

	private ArrayList<Toy> searchedToys;

	private ArrayList<String> logs;

	private Logging log;

	public Manager() {
		toys = new ArrayList<Toy>();
		searchedToys = new ArrayList<>();
		appMenu = new AppMenu();
		log = new Logging();
		logs = new ArrayList<String>();
		loadData();
		loadLog();
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

	private void loadLog() {
		String currentLine;
		
		try {
			File logDb = new File(LOG_PATH);
			
			if (logDb.exists()) {
				Scanner logReader = new Scanner(logDb);
				while(logReader.hasNextLine()) {
					currentLine = logReader.nextLine();
					logs.add(currentLine);
				}
				logReader.close();
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
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

	@FXML
	private void search(ActionEvent event) {
		searchErrorLabel.setText("");
		searchedToys.clear();
		if (typeRadioButton.isSelected()) {
			searchToyType();
		}
		if (nameRadioButton.isSelected()) {
			searchToyName();
		}
		if (snRadioButton.isSelected()) {
			searchSerialNumber();
		}

	}

	@FXML
	private void clear(ActionEvent event) {
		lvToys.getItems().clear();
		typeTextField.clear();
		nameTextField.clear();
		snTextField.clear();
		searchErrorLabel.setText("");
		purchasedToyLabel.setText("");
	}

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
					logs.add(log.logPurchase(toys.get(i).getName()));
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
		searchedToys.clear();
		String toySerial = removeToyTextField.getText(); // this takes in the prompted serial number
		String serialNumberCollected = "";

		if (toySerial.length() != 10) {
			removeToyError.setText(appMenu.displayError(1));

		}
		for (int i = 0; i <= toys.size() - 1; i++) { // this for loop goes through the whole original toys list to
														// see
														// if the searched serial number is equal to any of them
			if (toys.get(i).getSerial().equals(toySerial)) {
				searchedToys.add(toys.get(i));
				serialNumberCollected = toys.get(i).getSerial();

				ObservableList<Toy> ol = FXCollections.observableArrayList(searchedToys);
				lvRemovedToys.getItems().addAll(ol);
			}

		}

		if (toySerial.length() == 10 && !serialNumberCollected.equals(toySerial)) { // this checks if the serial
																					// number// the database
			removeToyError.setText(appMenu.displayError(2));
			return;
		}
	}

	@FXML
	private void searchToRemove(ActionEvent event) {
		lvRemovedToys.getItems().clear();
		removeToyError.setText("");
		removeToy();
	}

	@FXML
	private void remove(ActionEvent event) {
		int selectedToy = lvToys.getSelectionModel().getSelectedIndex();
		for (int i = 0; i <= toys.size() - 1; i++) {
			if (toys.get(i).equals(searchedToys.get(selectedToy + 1))) {
				removedToyLabel.setText(appMenu.displayRemovedToy(toys.get(i).getName()));
				logs.add(log.logRemove(toys.get(i).getName()));
				toys.remove(i);
			}
		}
		saveProgress();
	}

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

		try {
			FileWriter logfw = new FileWriter(LOG_PATH, false);
			PrintWriter appendLog = new PrintWriter(logfw);
			for (String log : logs) {
				String newLog = log;
				appendLog.println(newLog);
			}
			appendLog.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
