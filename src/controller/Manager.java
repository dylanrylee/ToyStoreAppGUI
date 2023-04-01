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
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import view.AppMenu;

/**
 * 
 * @author dylan, raph
 *
 */
public class Manager {
	
	@FXML
	private ChoiceBox toyCategory;

	
	@FXML
	private RadioButton snRadioButton = new RadioButton();
	
	@FXML
	private RadioButton nameRadioButton = new RadioButton();
	
	@FXML
	private RadioButton typeRadioButton = new RadioButton();
	
	
	
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
	
	
	public Manager() {
		toys = new ArrayList<Toy>();
		appMenu = new AppMenu();
		loadData();
	}
	
	/**
	 * This public void method goes through the file txt database and creates a new
	 * Toy object with the information given for the toys in the file. It creates a
	 * new object depending on the kind of toy it is and it does so through
	 * Polymorphism. It then adds the toy within the array list.
	 */
	public void loadData() {
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
			System.out.println("The txt file database has not been found");
		}

	}
	
	
}
