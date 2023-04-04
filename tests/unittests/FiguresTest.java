package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Figures;

/**
 * Test cases for figures class
 * @author raphaeldejesus, dylan
 *
 */
class FiguresTest {

	/**
	 * This Figures object is for test case 1
	 */
	private Figures f1;
	
	/**
	 * This Figures object is for test case 2
	 */
	private Figures f2; 
	
	/**
	 * This Figures object is for test case 3
	 */
	private Figures f3;
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init1() {
		f1 = new Figures("0123475612", "Test name", "Test brand", 9.99, 2, 5, 'A'); //initializing new figure object
	}
	
	/**
	 * First test case for figures class
	 */
	@Test
	void test_case_1() {
		assertEquals(f1.getSerial(), "0123475612"); //checks to see if getSerial() is working correctly and is returning a string
		assertNotEquals(f1.getSerial(), 0123475612L); //checks to see if it can differentiate between string and long (L makes it so the compiler reads it as a long rather than an int)
	}
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init2() {
		f2 = new Figures("1234567890", "Test name", "Test brand", 10.99, 10, 2, 'H'); //initializing new figure object
	}
	
	/**
	 * First test case for figures class
	 */
	@Test
	void test_case_2() {
		assertEquals(f2.getClassification(), 'H'); //checks to see if getClassification() method is working properly and is returning the proper figure classification
		assertNotEquals(f2.getPrice(), "10.99"); //checks to see if it can differentiate between string and double
	}
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init3() {
		f3 = new Figures("1239213950", "Test name", "Test brand", 15.99, 1, 6, 'D'); // Initializing new figure object
	}
	
	/**
	 * First test case for figures class
	 */
	@Test
	void test_case_3() {
		assertEquals(f3.formatString(), "1239213950;Test name;Test brand;15.99;1;6;D"); //checks to see if formatString() is working properly and returning proper format
		assertNotEquals(f3.getClassification(), 'A'); //checks to see if f3 has the same classification as input
	}
}