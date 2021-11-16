package com.isbntools;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateISBNTest {

	
	@Test
	public void checkThatTheISBN_IsValid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0545010225");
		assertTrue(result);
	}
	

}
