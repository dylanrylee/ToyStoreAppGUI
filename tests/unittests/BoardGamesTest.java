package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.BoardGames;

/**
 * Test cases for board games class
 * @author raphaeldejesus, dylan
 * 
 */
class BoardGamesTest {
	
	/**
	 * This creates a BoardGames object for test case 1
	 */
	private BoardGames bg1;
	/**
	 * This creates a BoardGames object for test case 2
	 */
	private BoardGames bg2; 
	/**
	 * This creates a BoardGames object for test case 3
	 */
	private BoardGames bg3;
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init1(){
		bg1 = new BoardGames("7897897890", "Testbg", "test brand", 29.99, 4, 5, "2-4", "Raph de jesus"); //initializing new board game object
	}
	
	/**
	 * First test case for board games class
	 */
	@Test
	void test_case_1() {
		assertEquals(bg1.getDesigner(), "Raph de jesus"); //checks to see if getDesigner() method is working correctly
		assertNotEquals(bg1.getPrice(), "29.99"); //checks to see if it can differentiate between string and double
	}
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init2() {
		bg2 = new BoardGames("9801234231", "Testbg", "test brand", 59.99, 4, 7, "6-8", "Dylan lizon"); //initializing second board game object
	}
	
	/**
	 * Second test case for board games class
	 */
	@Test
	void test_case_2() {
		assertEquals(bg2.getCount(), 4); //checks to see if getCount() method is working correctly
		assertNotEquals(bg2.getNumOfPlayers(), 2-4); //checks to see if it can differentiate between string and int
	}
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init3() {
		bg3 = new BoardGames("8122341237", "Testbg", "test brand", 12.99, 2, 5, "3-5", "Dylan lizon, Raphael de jesus"); //initializing third board game object
	}
	
	/**
	 * Third test case for board games class
	 */
	@Test
	void test_case_3() {
		assertEquals(bg3.formatString(), "8122341237;Testbg;test brand;12.99;2;5;3-5;Dylan lizon, Raphael de jesus"); //checks to see if formatString() is working properly
		assertNotEquals(bg3.getSerial(), 8122341237L); //L makes it so that the compiler reads it as a long rather than an int
	}
	
	

}