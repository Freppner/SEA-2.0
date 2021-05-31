package de.telekom.sea2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class PersonTest {

	private Person cut; 				// ClassUnderTest

	@BeforeEach
	void setup() {
		cut = new Person();
	}

	@Test
	void setFirstname_test() {
		// fail(); 						//Methode aus Junit, schlägt immer fail
		// Assertions.fail();
		
		//Arrange
		cut.setFirstname("Frank");
		
		//Act
		var result = cut.getFirstname();
		
				
		//Assert		
		assertEquals ("Frank",result);		
		
	}

	
	
	@AfterEach
	void teardown() {
		cut = null;
	}

}
