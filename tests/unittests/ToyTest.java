package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Toy;

/**
 * Test cases for toy class
 * @author raphaeldejesus
 *
 */
class ToyTest {

	/**
	 * This initializes a Toy object
	 */
	Toy t1; //declaring variables
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init1() {
		t1 = new Toy("4568122941", "Test toy", "Test brand", 12.99, 4, 2); //Initializing new toy object
	}
	
	/**
	 * First test case for toys superclass that tests superclass methods
	 */
	@Test
	void test_case_1() {
		
		assertEquals(t1.getSerial(), "4568122941"); //checks if getSerial method works properly
		assertNotEquals(t1.getSerial(), 4568122941L);
		
		assertEquals(t1.getName(), "Test toy"); //checks if getName method works properly
		assertNotEquals(t1.getName(), "Testtoy");
		
		assertEquals(t1.getBrand(), "Test brand"); //checks if getBrand method works properly
		assertNotEquals(t1.getBrand(), "testbrand");
		
		assertEquals(t1.getPrice(), 12.99); //checks if getPrice method works properly
		assertNotEquals(t1.getPrice(), "12.99");
		
		assertEquals(t1.getCount(), 4); //checks if getCount method works properly
		assertNotEquals(t1.getCount(), "4");
		
		assertEquals(t1.getMinAge(), 2); //checks if getMinAge method works properly
		assertNotEquals(t1.getMinAge(), "2");
		
	}
	
	/**
	 * Second test case for toys superclass that tests string format
	 */
	@Test
	void test_case_2() { 
		
		assertEquals(t1.formatString(), "4568122941;Test toy;Test brand;12.99;4;2;"); //checks if string formatting works properly
		assertNotEquals(t1.formatString(), "4568122941,Test toy,Test brand,12.99,4,2");
		
	}
}
