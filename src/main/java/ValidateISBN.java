

import java.util.Arrays;

public class ValidateISBN {

	public static boolean checkISBN(String isbn) {
		
		if (isbn.length()!=10 && isbn.length()!=13) {
			throw new NumberFormatException("Please provide an ISBN with either 10 or 13 digits");
		}
		
		if (isbn.length() == 13) {
			return IsThisAValid13DigitISBN(isbn);
		}
		else if (isbn.length() == 10) {
			return isThisAValid10DigitISBN(isbn);
		}
		else return false;
		
	}

	private static boolean isThisAValid10DigitISBN(String isbn) {
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
		
		int sum = 0;
		for (int j =0;j<isbnDigits.length;j++) {
			sum += isbnDigits[j]*(10-j);
		}
		
	
		return sum%11 == 0;
	}

	private static boolean IsThisAValid13DigitISBN(String isbn) {
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
		
		return Digit13Sum%10 == 0;
	}
	
	public static void main(String[] args) {
		checkISBN("helloworld");
		
		
	}

}
