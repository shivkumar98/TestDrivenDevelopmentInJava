package com.isbntools;

import java.util.Arrays;

public class ValidateISBN {

	public static boolean checkISBN(String isbn) {
		
		if (isbn.length() == 9) {
			throw new NumberFormatException("Please provide a 10 digit length isbn");
		}
		
		if (isbn.length() == 13) {
			int Digit13Sum = 0;
			
			for (int i =0; i<isbn.length();i++) {
				int multiplier = 0;
				if (i%2 == 0) {
					multiplier = 1;}
				else {
					multiplier = 3;
				}
				Digit13Sum += multiplier*Integer.parseInt(isbn.split("")[i]);
			}
			
			if (Digit13Sum%10 == 0) {
				return true;
			} else {
				return false;
			}
		}
		
		
		
		
		
		//convert string to int array
		int[] isbnDigits = new int[10];
		String[] isbnSplit = isbn.split("");

		for (int i =0; i<isbn.length();i++) {
			if(!(Character.isDigit(isbn.charAt(i))) && (i!=9) ) {
				throw new NumberFormatException("Please provide a string only containing digits");
			}
			 else if ((isbn.charAt(i)=='x' || isbn.charAt(i)=='X')
					 	&& i==9) {
				 isbnDigits[i]=10;
				
			} else {
				isbnDigits[i]=Integer.parseInt(isbnSplit[i]);
			}
		}
		
		//verification algorithm:
		int sum = 0;
		for (int j =0;j<isbnDigits.length;j++) {
			sum += isbnDigits[j]*(10-j);
		}
		
		//working out sum%11
		if (sum %11 == 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		checkISBN("helloworld");
		
		
	}

}
