package unittests;

import static org.junit.jupiter.api.Assertions.*;

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
	 * This initializes an Animals object
	 */
	Animals a1; //declaring variables
	
	/**
	 * Initializing variables and objects
	 */
	@BeforeEach
	public void init1(){
		a1 = new Animals("2234567890", "Testname", "test brand", 49.99, 2, 2, "Test material", 'L');
	}
	
	/**
	 * First test case for animals class that tests superclass methods
	 */
	@Test
	void test_case_1() {
		
		assertEquals(a1.getSerial(), "2234567890");
		assertNotEquals(a1.getSerial(), 2234567890L);
		
		assertEquals(a1.getName(), "Testname");
		assertNotEquals(a1.getName(), "Test name");
		
		assertEquals(a1.getBrand(), "test brand");
		assertNotEquals(a1.getBrand(), "testbrand");
		
		assertEquals(a1.getPrice(), 49.99);
		assertNotEquals(a1.getPrice(), "49.99");
		
		assertEquals(a1.getCount(), 2);
		assertNotEquals(a1.getCount(), "2");
		
		assertEquals(a1.getMinAge(), 2);
		assertNotEquals(a1.getMinAge(), "2");
		
	}
	
	/**
	 * Second test case for animals class that tests specific class methods
	 */
	@Test
	void test_case_2() {
		assertEquals(a1.getMaterial(), "Test material"); //checks if getMaterial method is working properly
		assertNotEquals(a1.getMaterial(), "Testmaterial");
		
		assertEquals(a1.getSize(), 'L'); //checks if getSize method is working properly
		assertNotEquals(a1.getSize(), "L");
	}
	
	/**
	 * Third test case for animals class that tests string format
	 */
	@Test
	void test_case_3() { 
		
		assertEquals(a1.formatString(), "2234567890;Testname;test brand;49.99;2;2;Test material;L"); //checks to see if string is being formatted properly
		assertNotEquals(a1.formatString(), "2234567890,Testname,test brand,49.99,2,2,Test material,L");
		
	}

}