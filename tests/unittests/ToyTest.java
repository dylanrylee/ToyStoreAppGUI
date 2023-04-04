package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Toy;

/**
 * Test cases for toy class
 * @author raphaeldejesus, dylan
 *
 */
class ToyTest {

	/**
	 * This Toy object is used for test case 1
	 */
	private Toy t1;
	
	/**
	 * This Toy object is used for test case 1
	 */
	private Toy t2; 
	
	/**
	 * This Toy object is used for test case 1
	 */
	private Toy t3;
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init1() {
		t1 = new Toy("4568122941", "Test toy", "Test brand", 12.99, 4, 2); //Initializing new toy object
	}
	
	/**
	 * First toy test case
	 */
	@Test
	void test_case_1() {
		assertEquals(t1.getBrand(), "Test brand"); //checks to see if getBrand() method is working correctly
		assertNotEquals(t1.getSerial(), 4568122941L); //checks to see if it differentiates long and string
	}
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init2() {
		t2 = new Toy("4568122941", "Test toy", "Test brand", 15.99, 12, 4); //initializing second toy object
	}

	/**
	 * Second toy test case
	 */
	@Test
	void test_case_2() {
		assertEquals(t2.formatString(), "4568122941;Test toy;Test brand;15.99;12;4;"); //checks to see if formatting is done correctly within the formatString() method
		assertNotEquals(t2.getPrice(), "15.99"); //checks to see if it differentiates string and double
	}
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init3() {
		t3 = new Toy("0918230981", "Test toy", "Test brand", 9.99, 2, 4); //initializing third toy object
	}
	
	/**
	 * Third toy test case
	 */
	@Test
	void test_case_3() {
		assertEquals(t3.getCount(), 2); //checks to see if getCount() method is working correctly
		assertNotEquals(t3.getMinAge(), "4"); //checks to see if it differentiates string and int
	}
}