package com.isbntools;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class StockManagementTest {
	
	@Test
	public void getLocatorCodeWorks() {
		String isbn = "0141023570";
		ExternalDataService externalDataServiceImp = new ExternalDataService() {
			
			@Override
			public Book lookup(String isbn) {
				return new Book(isbn, "J. Steinback", "Of Mice and Men");
			}
		};
		StockManager stockManager = new StockManager();
		stockManager.setServive(externalDataServiceImp);
		String LocatorCode = stockManager.getLocator(isbn);
		assertEquals("3570S4", LocatorCode);
	}

}
