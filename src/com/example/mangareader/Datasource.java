package com.example.mangareader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import readManga.daoDB.*;
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
	
	public String getGenreStringAtIndex(int index){
		return bookList.get(index).getGenre().getGenreName();
	}
	
	public String getTitleAtIndex(int index){
		return bookList.get(index).getTitle();
	}
	
	public String getYearAtIndex(int index){
		return bookList.get(index).getYearReleased();
		
	}
	
	public String getUrlAtIndex(int index){
		return bookList.get(index).getUrl();
		
	}
	
	public int getDatasourceSize(){
		
		return bookList.size();
	}	
	
	
	public void populateData(){
		
		Genre genre1 = new Genre((long)1, "adventure");
		Genre genre2 = new Genre((long)2, "instructional");
		Genre genre3 = new Genre((long)3, "fiction");
		
		Book book1 = new Book();
		book1.setTitle("Harry Potter");
		book1.setAuthor("Jeremy");
		book1.setYearReleased("1997");
		book1.setGenre(genre1);
		book1.setUrl("http://l.mfcdn.net/store/manga/8/cover.jpg?1349859487");

		Book book2 = new Book();
		book2.setTitle("How to use GitHub: For Dummies some really" +
				"long name here blah blah");
		book2.setAuthor("Some GitHub guyYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		book2.setYearReleased("2002");
		book2.setGenre(genre2);
		book2.setUrl("http://l.mfcdn.net/store/manga/8/cover.jpg");
			
		Book book3 = new Book();
		book3.setTitle("Homputer Programming");
		book3.setAuthor("Donald Knuth");
		book3.setYearReleased("1978");
		book3.setGenre(genre2);
		book3.setUrl("http://feministsforchoice.com/wp-content/uploads/2012/06/Manga.png");
		
		Book book4 = new Book();
		book4.setTitle("APPLES AND ORANGES");
		book4.setAuthor("LIL JOHN");
		book4.setYearReleased("2012");
		book4.setGenre(genre3);
		book4.setUrl("http://gamesworldbodmin.co.uk/images/Manga_Academy.jpg");
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
		
		
		Collections.sort(bookList, new Comparator<Book>(){		
		public int compare(Book lhs, Book rhs) {
			String leftGenre = lhs.getGenre().getGenreName();
			String rightGenre = rhs.getGenre().getGenreName();				
			return leftGenre.compareToIgnoreCase(rightGenre);
		}});
	
	}
}
