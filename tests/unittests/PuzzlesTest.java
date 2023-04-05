package unittests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Puzzles;

/**
 * Test cases for puzzles class
 * @author raphaeldejesus
 *
 */
class PuzzlesTest {

	/**
	 * This initializes a Puzzles object
	 */
	Puzzles p1; //declaring variable
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init1() {
		p1 = new Puzzles("343589073", "Test name", "Test brand", 10.99, 5, 6, 'M'); //initializing new puzzle object
	}
	
	/**
	 * First test case for puzzles class that tests superclass methods
	 */
	@Test
	void test_case_1() {
		
		assertEquals(p1.getSerial(), "343589073"); //checks if getSerial method works properly
		assertNotEquals(p1.getSerial(), 343589073L);
		
		assertEquals(p1.getName(), "Test name"); //checks if getName method works properly
		assertNotEquals(p1.getName(), "Testname");
		
		assertEquals(p1.getBrand(), "Test brand"); //checks if getBrand method works properly
		assertNotEquals(p1.getBrand(), "testbrand");
		
		assertEquals(p1.getPrice(), 10.99); //checks if getPrice method works properly
		assertNotEquals(p1.getPrice(), "10.99");
		
		assertEquals(p1.getCount(), 5); //checks if getCount method works properly
		assertNotEquals(p1.getCount(), "5");
		
		assertEquals(p1.getMinAge(), 6); //checks if getMinAge method works properly
		assertNotEquals(p1.getMinAge(), "6");
		
	}
	
	/**
	 * Second test case for puzzles class that tests specific class methods
	 */
	@Test
	void test_case_2() {
		assertEquals(p1.getPuzzleType(), 'M'); //checks if getPuzzleType method is working properly
		assertNotEquals(p1.getPuzzleType(), "M");
		
	}
	
	/**
	 * Third test case for puzzles class that tests string format
	 */	
	@Test
	void test_case_3() { 
		
		assertEquals(p1.formatString(), "343589073;Test name;Test brand;10.99;5;6;M"); //checks if string formatting works properly
		assertNotEquals(p1.formatString(), "343589073,Test name,Test brand,10.99,5,6,M");
		
	}
}