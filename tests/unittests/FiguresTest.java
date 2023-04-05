package unittests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Figures;

/**
 * Test cases for figures class
 * @author raphaeldejesus
 *
 */
class FiguresTest {
	
	/** 
	 * This initializes a Figures object for the first test case
	 */
	Figures f1;
	
	/** 
	 * This initializes a Figures object for the first test case
	 */
	Figures f2; //declaring variables
	
	/** 
	 * This initializes a Figures object for the first test case
	 */
	Figures f3;
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init1() {
		f1 = new Figures("0123475612", "Test name", "Test brand", 9.99, 2, 5, 'A'); //initializing new figure object
	}
	
	/**
	 * First test case for figures class that tests superclass methods
	 */
	@Test
	void test_case_1() {
		
		assertEquals(f1.getSerial(), "0123475612"); //checks if getSerial method works properly
		assertNotEquals(f1.getSerial(), 0123475612L);
		
		assertEquals(f1.getName(), "Test name"); //checks if getName method works properly
		assertNotEquals(f1.getName(), "Testname");
		
		assertEquals(f1.getBrand(), "Test brand"); //checks if getBrand method works properly
		assertNotEquals(f1.getBrand(), "testbrand");
		
		assertEquals(f1.getPrice(), 9.99); //checks if getPrice method works properly
		assertNotEquals(f1.getPrice(), "9.99");
		
		assertEquals(f1.getCount(), 2); //checks if getCount method works properly
		assertNotEquals(f1.getCount(), "2");
		
		assertEquals(f1.getMinAge(), 5); //checks if getMinAge method works properly
		assertNotEquals(f1.getMinAge(), "5");
		
	}
	
	/**
	 * Second test case for figures class that tests specific class methods
	 */
	@Test
	void test_case_2() {
		assertEquals(f1.getClassification(), 'A'); //checks if getClassification method is working properly
		assertNotEquals(f1.getClassification(), "A");
		
	}
	
	/**
	 * Third test case for figures class that tests string format
	 */
	@Test
	void test_case_3() { 
		
		assertEquals(f1.formatString(), "0123475612;Test name;Test brand;9.99;2;5;A"); //checks if string formatting works properly
		assertNotEquals(f1.formatString(), "0123475612,Test name,Test brand,9.99,2,5,A");
		
	}
}