package unittests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.BoardGames;

/**
 * Test cases for board games class
 * @author raphaeldejesus
 *
 */
class BoardGamesTest {
	
	/**
	 * This initializes a new BoardGames object
	 */
	BoardGames bg1; //declaring variables
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init1(){
		bg1 = new BoardGames("7897897890", "Testbg", "test brand", 29.99, 4, 5, "2-4", "Raph de jesus"); //initializing new board game object
	}
	
	
	/**
	 * First test case for board games class that tests superclass methods
	 */
	@Test
	void test_case_1() {
		
		assertEquals(bg1.getSerial(), "7897897890"); //checks if getSerial method works properly
		assertNotEquals(bg1.getSerial(), 7897897890L);
		
		assertEquals(bg1.getName(), "Testbg"); //checks if getName method works properly
		assertNotEquals(bg1.getName(), "Test bg");
		
		assertEquals(bg1.getBrand(), "test brand"); //checks if getBrand method works properly
		assertNotEquals(bg1.getBrand(), "testbrand");
		
		assertEquals(bg1.getPrice(), 29.99); //checks if getPrice method works properly
		assertNotEquals(bg1.getPrice(), "29.99");
		
		assertEquals(bg1.getCount(), 4); //checks if getCount method works properly
		assertNotEquals(bg1.getCount(), "4");
		
		assertEquals(bg1.getMinAge(), 5); //checks if getMinAge method works properly
		assertNotEquals(bg1.getMinAge(), "5");
		
	}
	
	/**
	 * Second test case for board games class that tests specific class methods
	 */
	@Test
	void test_case_2() {
		assertEquals(bg1.getNumOfPlayers(), "2-4"); //checks if getNumOfPlayers method is working properly
		assertNotEquals(bg1.getNumOfPlayers(), "2,4");
		
		assertEquals(bg1.getDesigner(), "Raph de jesus"); //checks if getDesigner method is working properly
		assertNotEquals(bg1.getDesigner(), "RaphdeJesus");
	}
	
	/**
	 * Third test case for board games class that tests string format
	 */
	@Test
	void test_case_3() { 
		
		assertEquals(bg1.formatString(), "7897897890;Testbg;test brand;29.99;4;5;2-4;Raph de jesus"); //checks if string is being formatted properly
		assertNotEquals(bg1.formatString(), "7897897890,Testbg,test brand,29.99,4,5,2-4,Raph de jesus");
		
	}


}