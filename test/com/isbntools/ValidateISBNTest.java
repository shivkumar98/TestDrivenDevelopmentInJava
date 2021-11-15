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
	
	@Test
	public void checkThatAnotherISBN_isValid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0198534530");

	}
	
	@Test
	public void checkAnInvalidISBN_returnsFalse() {
		ValidateISBN validateISBN=new ValidateISBN();
		assertFalse(validateISBN.checkISBN("0198534540"));
	}
	
	
	

	
	@Test(expected = NumberFormatException.class)
	public void checkNineDigitISNBThrowsException() {
		ValidateISBN validateISBN=new ValidateISBN();
		assertFalse(validateISBN.checkISBN("123456789"));
	}

}
