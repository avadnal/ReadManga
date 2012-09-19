package com.example.mangareader;

public class Book {

	int id;
	String name, year, author;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getYear() {
		return year;
	}

	public String getAuthor() {
		return author;
	}

	public Book(int id, String name, String year, String author) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.author = author;
	}

	
}
