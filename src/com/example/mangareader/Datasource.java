package com.example.mangareader;

import java.util.ArrayList;

import readManga.daoDB.Book;
//
//
public class Datasource {
	
	ArrayList<Book> bookList = new ArrayList<Book>();
	
	public Datasource(){
		populateData();
	}
	
	public ArrayList<Book> getList() {
		return bookList;
	}
	
	public String getAuthorAtIndex(int index) {
		
		return bookList.get(index).getAuthor();
	}
	
	public String getTitleAtIndex(int index){
		return bookList.get(index).getTitle();
	}
	
	public String getYearAtIndex(int index){
		return bookList.get(index).getYearReleased();
		
	}
	
	public int getDatasourceSize(){
		
		return bookList.size();
	}	
	

	public void populateData(){
		
		Book book1 = new Book();
		book1.setTitle("Harry Potter");
		book1.setAuthor("Jeremy");
		book1.setYearReleased("1997");
		
		
		
		Book book2 = new Book();
		book2.setTitle("How to use GitHub: For Dummies some really" +
				"long name here blah blah");
		book2.setAuthor("Some GitHub guyYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		book2.setYearReleased("2002");
		
		Book book3 = new Book();
		book3.setTitle("Computer Programming");
		book3.setAuthor("Donald Knuth");
		book3.setYearReleased("1978");
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
	}
}
