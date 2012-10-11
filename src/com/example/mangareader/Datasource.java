package com.example.mangareader;

import java.util.ArrayList;

import readManga.daoDB.Book;
//
//
public class Datasource {
	
	ArrayList<Book> list = new ArrayList<Book>();
	
	public Datasource(){
		populateData();
	}
	
	public ArrayList<Book> getList() {
		return list;
	}
	
	public String getAuthorAtIndex(int index) {
		
		return list.get(index).getAuthor();
	}
	
	public String getTitleAtIndex(int index){
		return list.get(index).getTitle();
	}
	
	public int getDatasourceSize(){
		
		return list.size();
	}	

	public void populateData(){
		
		Book book1 = new Book();
		book1.setTitle("Harry Potter");
		book1.setAuthor("Jeremy");
		
		Book book2 = new Book();
		book2.setTitle("How to use GitHub: For Dummies");
		book2.setAuthor("Some GitHub guy");
		
		Book book3 = new Book();
		book3.setTitle("The Art of Computer Programming");
		book3.setAuthor("Dennis Ritchie");
		
		list.add(book1);
		list.add(book2);
		list.add(book3);		
	}
}
