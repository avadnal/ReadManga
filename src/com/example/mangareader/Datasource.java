package com.example.mangareader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import readanga.daoDB.*;

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
	
	public String getDescriptionAtIndex(int index){
		return bookList.get(index).getDescription();
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
		book1.setDescription("Twelve years before the start of the series," +
				" a powerful creature known as the Nine-tailed Demon Fox attacked" +
				" the ninja village Konohagakure, decimating many people. In response," +
				" the leader of Konohagakure's ninja military – the Fourth Hokage – " +
				"sacrificed his life to seal the demon inside his newly born child Naruto Uzumaki." +
				" Konohagakure, however, regarded Naruto as if he were the demon fox itself" +
				" and mistreated him throughout most of his childhood.The plot tells the" +
				" story of Naruto Uzumaki, now a adolescent ninja who constantly searches for" +
				" recognition and dreams to become the Hokage, the ninja in his village who is" +
				" acknowledged as the leader and the strongest of all.");
		book1.setNumberOfChapters(20);
		
		Book book2 = new Book();
		book2.setTitle("How to use GitHub: For Dummies some really" +
				"long name here blah blah");
		book2.setAuthor("Some GitHub guyYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		book2.setYearReleased("2002");
		book2.setGenre(genre2);
		book2.setUrl("http://l.mfcdn.net/store/manga/8/cover.jpg");
		book2.setDescription("Twelve years before the start of the series," +
				" a powerful creature known as the Nine-tailed Demon Fox attacked" +
				" the ninja village Konohagakure, decimating many people. In response," +
				" the leader of Konohagakure's ninja military – the Fourth Hokage – " +
				"sacrificed his life to seal the demon inside his newly born child Naruto Uzumaki." +
				" Konohagakure, however, regarded Naruto as if he were the demon fox itself" +
				" and mistreated him throughout most of his childhood.The plot tells the" +
				" story of Naruto Uzumaki, now a adolescent ninja who constantly searches for" +
				" recognition and dreams to become the Hokage, the ninja in his village who is" +
				" acknowledged as the leader and the strongest of all.");
		book2.setNumberOfChapters(15);
		
		Book book3 = new Book();
		book3.setTitle("Homputer Programming");
		book3.setAuthor("Donald Knuth");
		book3.setYearReleased("1978");
		book3.setGenre(genre2);
		book3.setUrl("http://feministsforchoice.com/wp-content/uploads/2012/06/Manga.png");
		book3.setDescription("Twelve years before the start of the series," +
				" a powerful creature known as the Nine-tailed Demon Fox attacked" +
				" the ninja village Konohagakure, decimating many people. In response," +
				" the leader of Konohagakure's ninja military – the Fourth Hokage – " +
				"sacrificed his life to seal the demon inside his newly born child Naruto Uzumaki." +
				" Konohagakure, however, regarded Naruto as if he were the demon fox itself" +
				" and mistreated him throughout most of his childhood.The plot tells the" +
				" story of Naruto Uzumaki, now a adolescent ninja who constantly searches for" +
				" recognition and dreams to become the Hokage, the ninja in his village who is" +
				" acknowledged as the leader and the strongest of all.");
		book3.setNumberOfChapters(1000);
		Book book4 = new Book();
		book4.setTitle("APPLES AND ORANGES");
		book4.setAuthor("LIL JOHN");
		book4.setYearReleased("2012");
		book4.setGenre(genre3);
		book4.setUrl("http://gamesworldbodmin.co.uk/images/Manga_Academy.jpg");
		book4.setDescription("Twelve years before the start of the series," +
				" a powerful creature known as the Nine-tailed Demon Fox attacked" +
				" the ninja village Konohagakure, decimating many people. In response," +
				" the leader of Konohagakure's ninja military – the Fourth Hokage – " +
				"sacrificed his life to seal the demon inside his newly born child Naruto Uzumaki." +
				" Konohagakure, however, regarded Naruto as if he were the demon fox itself" +
				" and mistreated him throughout most of his childhood.The plot tells the" +
				" story of Naruto Uzumaki, now a adolescent ninja who constantly searches for" +
				" recognition and dreams to become the Hokage, the ninja in his village who is" +
				" acknowledged as the leader and the strongest of all.");
		book4.setNumberOfChapters(10);
		
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
