package view;

import java.util.Scanner;

import controller.Manager;
import exceptions.MinGreaterThanMax;
import exceptions.PriceNotPositive;

/**
 * This is where we print and output in the console
 * 
 * @author dylan, raph
 *
 */
public class AppMenu {

	/**
	 * This instantiates a Scanner input for the user's input
	 */
	private Scanner input;

	/**
	 * This is the constructor of this class
	 */
	public AppMenu() {
		input = new Scanner(System.in);
	}

	/**
	 * This is the welcoming page of the app and this is the first thing that pops
	 * up when the program runs
	 * 
	 * @return the int option of the user
	 */
	public int showMainMenu() {
		int option = 0;
		boolean flag = true;
		System.out.println(welcomingPlayerInScreen());
		System.out.println("How May We Help You? \n");
		System.out.println("\t(1) Search Inventory and Purchase Toy");
		System.out.println("\t(2) Add a new toy");
		System.out.println("\t(3) Remove a toy");
		System.out.println("\t(4) Save & Exit\n");
		System.out.print("Enter Option: ");

		while (flag) { // this while loop has a try and catch that checks if the input consisted of
						// letters
			String in = input.nextLine();

			try {
				option = Integer.parseInt(in);
				if (option != 1 && option != 2 && option != 3 && option != 4) {
					System.out.print("\nError: That is not one of the options, Try again! ");
				} else {
					flag = false;
				}
			} catch (NumberFormatException e) {
				System.out.print("\nError: The input consisted of letters, Try again! ");
				System.out.print("\nEnter Option: ");
			}
		}
		return option;

	}

	/**
	 * This sub menu is called when it's time to search for a toy
	 * 
	 * @return the int option of the user
	 */
	public int showSearchMenu() {
		int option = 0;
		boolean flag = true;
		System.out.println("\n\nFind Toys With: \n");
		System.out.println("\t(1) Serial Number (SN)");
		System.out.println("\t(2) Toy Name");
		System.out.println("\t(3) Type");
		System.out.println("\t(4) Back to Main Menu\n");
		System.out.print("Enter Option: ");

		while (flag) { // this while loop has a try and catch that checks if the input consisted of
						// letters
			String in = input.nextLine();

			try {
				option = Integer.parseInt(in);
				if (option != 1 && option != 2 && option != 3 && option != 4) {
					System.out.print("\nError: That is not one of the options, Try again! ");
				} else {
					flag = false;
				}
			} catch (NumberFormatException e) {
				System.out.print("\nError: The input consisted of letters or it was blank, Try again! ");
				System.out.println("\nEnter Option: ");
			}
		}

		return option;
	}

	/**
	 * This sub menu is called when user selects to add a toy
	 * 
	 * @return the int option of the user
	 */
	public int showAddToyMenu() {
		int option = 0;
		boolean flag = true;
		System.out.println("\n\nSelect what type of toy you would like to add: \n");
		System.out.println("\t(1) Figures");
		System.out.println("\t(2) Animals");
		System.out.println("\t(3) Puzzles");
		System.out.println("\t(4) Board Games");
		System.out.println("\t(5) Back to Main Menu\n");
		System.out.println("\nEnter Option: ");

		while (flag) { // this while loop has a try and catch that checks if the input consisted of
						// letters
			String in = input.nextLine();

			try {
				option = Integer.parseInt(in);
				if (option != 1 && option != 2 && option != 3 && option != 4) {
					System.out.print("\nError: That is not one of the options, Try again! ");
				} else {
					flag = false;
				}
			} catch (NumberFormatException e) {
				System.out.print("\nError: The input consisted of letters or it was blank, Try again! ");
				System.out.println("\nEnter Option: ");
			}
		}
		return option;
	}

	/**
	 * This method prints out "Press enter to Continue" This method is created so
	 * that this code is not repeated
	 */
	public void enterToContinue() {
		boolean flag = true;
		System.out.print("\nPress Enter to Continue...");
		while (flag) {
			String decision = input.nextLine();
			if (decision.equals("")) {
				flag = false;
			} else {
				enterToContinue();
				return;
			}
		}
	}

	/**
	 * This public void method displays that there are no more stock for the toy
	 */
	public void showNoToysLeft() {
		System.out.println("Sorry, unfortunately we are out of stock for this toy");
		enterToContinue();

	}

	/**
	 * This private method's role is to welcome the user in a nice String format
	 * 
	 * @return a nice String message
	 */
	private String welcomingPlayerInScreen() {
		return "**********************************\n" + "* WELCOME TO TOY STORE COMPANY!  *\n"
				+ "**********************************\n";
	}

	/**
	 * This public void method shows that the transaction is completed
	 * 
	 * @param name is the name of the toy
	 */
	public void showTransactionComplete(String name) {
		System.out.println("You have purchased " + name);
		System.out.println("\nThe Transaction Successfully Terminated");
		enterToContinue();
	}

	/**
	 * This public String method asks for the toy name to search in the database
	 * 
	 * @return the toyName String variable
	 */
	public String promptToyName() {
		System.out.print("\nEnter Toy Name: ");
		String toyName = input.nextLine();

		return toyName;
	}

	/**
	 * This public int method asks for the toy name to search in the database
	 * 
	 * @return the toySerial int variable
	 */
	public String promptToySerial() {
		System.out.print("\nEnter Serial Number: ");
		String toySerial = input.nextLine();

		return toySerial;
	}

	/**
	 * This public int method asks to pick which toy out of everything that was
	 * searched to purchase
	 * 
	 * @return the option integer inputed
	 */
	public int promptOption() {
		int option = 0;
		System.out.print("\nEnter option: ");

		String in = input.nextLine();

		try {
			option = Integer.parseInt(in);
		} catch (NumberFormatException e) {
			System.out.print("\nError: The input consisted of letters, Try again! ");
		}

		return option;
	}

	/**
	 * This public char method asks to pick which toy type to search in the database
	 * 
	 * @return toyType string variable
	 */
	public char promptToyType() {
		System.out.print("Enter Toy Type (F) for Figures, (A) for Animals, (P) for Puzzles, (B) for BoardGames: ");
		String toyType = input.nextLine();
		char option = toyType.toLowerCase().charAt(0);
		return option;
	}

	/**
	 * This public String method prompts the toy brand of the toy
	 * 
	 * @return the toy brand of the toy
	 */
	public String promptToyBrand() {
		System.out.print("\nEnter Toy Brand: ");
		String toyBrand = input.nextLine();

		return toyBrand;
	}

	/**
	 * This public double method asks for the price of the toy, and only asks for it
	 * again if the price inputed is less than 0
	 * 
	 * @return the price of the toy
	 * @throws PriceNotPositive which is the exception created to throw the negative
	 *                          inputs
	 */
	public double promptToyPrice() {
		boolean flag = true;
		double toyPrice = 0;
		while (flag) {
			System.out.print("\nEnter Toy Price: ");
			try {
				toyPrice = input.nextDouble();
				if (toyPrice < 0) {
					throw new PriceNotPositive();
				} else {
					flag = false;
				}
			} catch (PriceNotPositive e) {
				System.out.println(e.getMessage());
			}

		}

		return toyPrice;
	}

	/**
	 * This public int method prompts the amount of stock for the toy
	 * 
	 * @return the stock amount of toys inputed
	 */
	public int promptToyStock() {
		System.out.print("\nEnter Toy Stock: ");
		int toyStock = input.nextInt();

		return toyStock;
	}

	/**
	 * This public int prompts the minimum age group allowed for the toy
	 * 
	 * @return the minimum age inputed
	 */
	public int promptToyMinAge() {
		System.out.print("\nEnter Toy Minimum Age: ");
		int toyMinAge = input.nextInt();
		input.nextLine();

		return toyMinAge;
	}

	/**
	 * This prompts the classification of the toy
	 * 
	 * @return the toyClass inputed by the user
	 */
	public char promptToyClass() {
		System.out.print("\nToy Classifications: \n");
		System.out.println("\t(A) Action");
		System.out.println("\t(D) Doll");
		System.out.println("\t(H) Historic");
		System.out.print("Choice: ");
		char toyClass = input.nextLine().toUpperCase().charAt(0);

		return toyClass;
	}

	/**
	 * This public String method prompts the toy material of the toy
	 * 
	 * @return the toy material
	 */
	public String promptToyMaterial() {
		System.out.print("\nDescription of Toy Material: ");
		String toyMaterial = input.nextLine();

		return toyMaterial;
	}

	/**
	 * This public char method prompts the toy size
	 * 
	 * @return the toy size
	 */
	public char promptToySize() {
		System.out.println("\nToy Sizes: ");
		System.out.println("\n\t(S) Small");
		System.out.println("\t(M) Medium");
		System.out.println("\t(L) Large");
		System.out.print("Choice: ");
		char toySize = input.nextLine().toUpperCase().charAt(0);

		return toySize;
	}

	/**
	 * This public char method prompts the puzzle type of the toy
	 * 
	 * @return the inputed puzzle type
	 */
	public char promptPuzzleType() {

		System.out.print("\nPuzzle Type: \n");
		System.out.println("\t(M) Mechanical");
		System.out.println("\t(C) Cryptic");
		System.out.println("\t(L) Logic");
		System.out.println("\t(T) Trivia");
		System.out.println("\t(R) Riddle");
		System.out.print("Choice: ");
		char toyPuzzleType = input.nextLine().toUpperCase().charAt(0);

		return toyPuzzleType;
	}

	/**
	 * This prompts the min and max players
	 * 
	 * @return the min and max players in "min-max" format
	 * @throws MinGreaterThanMax exception that we created
	 */
	public String promptToyMinMaxPlayers() {

		boolean flag = true;
		System.out.print("\nEnter Minimum Number of Players: ");
		int toyMinPlayers = input.nextInt();
		int toyMaxPlayers = 0;
		while (flag) {
			System.out.print("\nEnter Maximum Number of Players: ");
			try {

				toyMaxPlayers = input.nextInt();
				if (toyMinPlayers > toyMaxPlayers) {
					throw new MinGreaterThanMax();
				}
				flag = false;
			} catch (MinGreaterThanMax e) {
				System.out.println(e.getMessage());
			}
		}

		input.nextLine(); // Flush out the Scanner buffer

		return toyMinPlayers + "-" + toyMaxPlayers;
	}

	/**
	 * This public String method prompts who is the toy's designer
	 * 
	 * @return the toyDesigner to whoever is calling this method
	 */
	public String promptToyDesigner() {
		System.out.print("\nEnter Designer Names (Use ',' to separate more than one designer): ");
		String toyDesigner = input.nextLine();

		return toyDesigner;
	}

	/**
	 * This public char method ensures if they really do want to delete this toy
	 * from the database
	 * 
	 * @param name is the name of the toy taken in as a parameter
	 * @return the decision of the user
	 */
	public char promptToyRemoval(String name) {
		char decision;
		System.out.print("\nDo you want to remove " + name + " (y/n) ? : ");
		decision = input.nextLine().toLowerCase().charAt(0);
		while (decision != 'y' && decision != 'n') {
			System.out.println("Error: That was an invalid input, Press Enter and Try Again!");
			promptToyRemoval(name);

		}
		return decision;
	}

	/**
	 * This public void method prints out that the changes made are being saved into
	 * the database
	 */
	public void saveAndExitMessage() {
		System.out.println("\n************ THANKS FOR VISITING US! ************");
	}

}
