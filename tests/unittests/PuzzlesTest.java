package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Puzzles;

/**
 * Test case for Puzzles class
 * @author raph, dylan
 *
 */
class PuzzlesTest {

	/**
	 * This Puzzles object is used for test case 1 
	 */
	private Puzzles p1;
	
	/**
	 * This Puzzles object is used for test case 1 
	 */
	private Puzzles p2; 
	
	/**
	 * This Puzzles object is used for test case 1 
	 */
	private Puzzles p3;
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init1() {
		p1 = new Puzzles("343589073", "Test name", "Test brand", 10.99, 5, 6, 'M'); //initializing new puzzle object
	}
	
	/**
	 * First puzzle test case
	 */
	@Test
	void test_case_1() {
		assertEquals(p1.getName(), "Test name"); //check to see if getName() method is working correctly
		assertNotEquals(p1.getPrice(), "10.99"); //checks to see if it can differentiate between string and double
	}
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init2() {
		p2 = new Puzzles("4129293712", "Test name", "Test brand", 20.99, 10, 4, 'T'); //Initializing second puzzle object
	}
	
	/**
	 * Second puzzle test case
	 */
	@Test
	void test_case_2() {
		assertEquals(p2.getBrand(), "Test brand"); //checks to see if getBrand() method is working correctly
		assertNotEquals(p2.getPuzzleType(), "T"); //checks to see if it can differentiate between string and char
	}
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init3() {
		p3 = new Puzzles("6129293712", "Test name", "Test brand", 18.99, 1, 4, 'L'); //Initialing new puzzle object
	}
	
	/**
	 * Third puzzle test case
	 */
	@Test
	void test_case_3() {
		assertEquals(p3 instanceof Puzzles, true); //checks to see if p3 is an instance of Puzzles class
		assertNotEquals(p3.getBrand(), "Testbrand"); //checks to see if getBrand can detect spaces within string
	}

}