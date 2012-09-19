package com.example.mangareader;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

import android.widget.ListView;
//import roboguice.activity.RoboActivity;
//import roboguice.inject.ContentView;


//@ContentView(R.layout.activity_user_bookshelf)
public class UserBookshelf extends ListActivity{//RoboActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_bookshelf);
        //static String[] = new String{"aa", "bb", "cc"};
        ArrayList<Book> dataList = this.populateData();	
        final ListView listView = (ListView)findViewById(R.id.ListView01);
        listView.setAdapter(new CustomBookshelfAdapter(this, dataList));
	
//		listView.setOnItemClickListener(new OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				//Object o = listView.getItemAtPosition(position);
//		          //Book fullObject = (Book)o;
//		          //Toast.makeText(getApplicationContext().this, "You have chosen: " + " " + fullObject.getName(), Toast.LENGTH_LONG).show();
//			    // When clicked, show a toast with the TextView text
//			    //Toast.makeText(getApplicationContext(),
//				//((TextView) view).getText(), Toast.LENGTH_SHORT).show();
//			}
//		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_user_bookshelf, menu);
        	
        return true;
    }
    
	public ArrayList<Book> populateData(){
		ArrayList<Book> list = new ArrayList<Book>();
		Book book1 = new Book(0,"some book title","2012","andrew");
		Book book2 = new Book(1,"some book title2","2012","jeremy");
		Book book3 = new Book(2,"some book title3","2012","qiju");
		list.add(book1);
		list.add(book2);
		list.add(book3);
	return list;
	
}
     
}