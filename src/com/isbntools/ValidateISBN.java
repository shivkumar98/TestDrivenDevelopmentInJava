package com.isbntools;

import java.util.Arrays;

public class ValidateISBN {

	public static boolean checkISBN(String isbn) {
		
		String[] stringArray = isbn.split("");
		int[] integerArray = new int[stringArray.length];
		
		if (integerArray.length != 10) {
			throw new NumberFormatException();
		}
		
		
		
		for (int j =0; j<stringArray.length;j++) {
			if (j!=9) {
				if (!Character.isDigit(stringArray.toString().charAt(j))) {
				throw new NumberFormatException("please provide ISBN with only digits");
				} else {
					integerArray[j]=Integer.parseInt(stringArray[j]) ;
				}
			} else { // j=9
				if (stringArray.toString().charAt(j)== 'X') {
					integerArray[j] = 10;
				} else {
				integerArray[j] = Integer.parseInt(stringArray[j]) ;
				}
			}
		}
		
		int sum = 0;
		
			sum = sum +10*integerArray[0]
					+ 9*integerArray[1]
					+ 8*integerArray[2]
					+ 7*integerArray[3]
					+ 6*integerArray[4]
					+ 5*integerArray[5]
					+ 4*integerArray[6]
					+ 3*integerArray[7]
					+ 2*integerArray[8]
					+ 1*integerArray[9];
					
		System.out.println(sum);
		int remainder = sum % 11;
		
		if (remainder == 0
				) {
			return true;
		} else {
			return false;
		}
	
		
	}
	
	public static void main(String[] args) {
		checkISBN("0198534540");
		
		System.out.println(Integer.parseInt("X"));
	}

}
