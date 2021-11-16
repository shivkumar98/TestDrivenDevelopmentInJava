package com.isbntools;

public class StockManager {

	private ExternalDataService dataService;
	
	public void setServive(ExternalDataService dataService) {
		this.dataService = dataService;
	}
	
	public String getLocator(String isbn) {
		Book book = dataService.lookup(isbn);
		StringBuilder sb = new StringBuilder();
		sb.append(isbn.substring(isbn.length()-4));
		sb.append(book.getAuthor().split(" ")[1].substring(0, 1));
		sb.append(book.getTitle().split(" ").length);
		return sb.toString();
	}

}
