package com.isbntools;

import java.util.Arrays;

public class ValidateISBN {

	public boolean checkISBN(String isbn) {
		
		String[] stringArray = isbn.split("");
		int[] integerArray = new int[stringArray.length];
		
		if (integerArray.length != 10) {
			return false;
		}
		
		for (int j =0; j<stringArray.length;j++) {
			integerArray[j] = Integer.parseInt(stringArray[j]) ;
		}
		
		int sum = 0;
		sum = sum + 10*integerArray[0]
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

}
