package unittests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Animals;

/**
 * Test cases for animals class
 * @author raphaeldejesus
 *
 */

class AnimalsTest {
	
	/**
	 * declaring Animal variable for 1st test case
	 */
	private Animals a1; 
	
	/**
	 * declaring Animal variable for 2nd test case
	 */
	private Animals a2; 
	
	/**
	 * declaring Animal variable for 3rd test case
	 */
	private Animals a3;
	

	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init1(){
		a1 = new Animals("2234567890", "Testname", "test brand", 49.99, 2, 2, "Test material", 'L'); //initializing new animal object
	}
	
	/**
	 * First test case for animals class
	 */
	@Test
	void test_case_1() {
		assertEquals(a1.getPrice(), 49.99); //checking to see if getPrice() method is working correctly
		assertNotEquals(a1.getSerial(), 2234567890L); //L makes it so that the compiler reads it as a long rather than an int
	}
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init2() {
		a2 = new Animals("3120120123", "Testname", "test brand", 23.12, 2, 2, "Test material", 'M'); //initializing second animal object
	}
	
	/**
	 * Second test case for animals class
	 */
	@Test
	void test_case_2() {
		assertEquals(a2.getMaterial(), "Test material"); //checking to see if getMaterial() method is working correctly
		assertNotEquals(a2.getSize(), "M"); //checks to see if it can differentiate between char and string
	}
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init3() {
		a3 = new Animals("21010101011", "Testname", "test brand", 15.99, 3, 5, "Test material", 'S'); //initializing third animal object
	}
	
	/**
	 * Third test case for animals class
	 */
	@Test
	void test_case_3() {
		assertEquals(a3.formatString(), "21010101011;Testname;test brand;15.99;3;5;Test material;S"); //checking to see if string format is working correctly
		assertNotEquals(a3.getCount(), "3"); //checks to see if it can differentiate between string and int
	}

}