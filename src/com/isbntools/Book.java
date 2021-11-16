package com.isbntools;

public class Book {
	
	private String isbn;
	private String author;
	private String title;
	public Book(String isbn, String author, String title) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	
	

}
