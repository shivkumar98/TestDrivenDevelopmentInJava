package com.isbntools;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateISBNTest {

	
	@Test
	public void testThatValidISBN_returnsTrue() {
		ValidateISBN validator = new ValidateISBN();
		// valid isbn 0140449116 
		
		assertTrue(validator.checkISBN("0140449116"));
	}
	
	@Test 
	public void testValidateISBN_WhenISBNisNineDigitsLong_ReturnFalse() {
		ValidateISBN validator = new ValidateISBN();

		assertThrows(NumberFormatException.class,
				()-> {
					validator.checkISBN("140449116");
				});
	}
	
	@Test
	public void testThatInvalidISBN_returnsFalse() {
		ValidateISBN validator = new ValidateISBN();
		assertFalse(validator.checkISBN("0120449116"));
		
	}
	
	@Test
	public void testThat_WhenIsbnContainsNonDigits_CheckIsbnReturnsFalse() {
		ValidateISBN validator = new ValidateISBN();
		assertThrows(NumberFormatException.class,() -> {
				validator.checkISBN("helloworld");});
	}
	
	@Test
	public void testWhenValidIsbnWithX_checkIsb_returnsTrue() {
		ValidateISBN validator = new ValidateISBN();
		
		assertTrue(validator.checkISBN("043942089x"));
	}
	
	@Test
	public void testWhenIsbnWith13Digits_checkIsbnReturnsTrue() {
		ValidateISBN validator = new ValidateISBN();
		
		assertTrue(validator.checkISBN("9780199535569"));
	}
	
	@Test
	public void testInvalid13DigitIsbn_CheckIsbnReturnsFalse() {
		ValidateISBN validator = new ValidateISBN();
		
		assertFalse(validator.checkISBN("9740199535569"));
	}

}
