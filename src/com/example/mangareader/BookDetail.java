package com.example.mangareader;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

public class BookDetail extends Activity {
	
	//private static ArrayList<Book> searchArrayList;
	//private LayoutInflater mInflater;
	private int mPosition;
	private TextView mTitle;
	private TextView mAuthor;
	private Datasource mDataSource;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_book);

        Intent i = getIntent();
        mPosition = i.getIntExtra("position", 0);
        mDataSource = new Datasource();                  
        mTitle = (TextView)findViewById(R.id.name);
        mAuthor = (TextView)findViewById(R.id.author);
        
        mTitle.setText(mDataSource.getTitleAtIndex(mPosition));
        mAuthor.setText(mDataSource.getAuthorAtIndex(mPosition));       

	}
	
}
