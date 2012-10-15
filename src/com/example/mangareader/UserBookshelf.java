package com.example.mangareader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class UserBookshelf extends Activity {
	
	public class BookshelfAdapter extends BaseAdapter {
		
		private Context mContext;				
		private LayoutInflater mInflator;
		private Datasource mDataSource;
		
		public BookshelfAdapter(Context c){
			mContext = c;
			mInflator = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mDataSource = new Datasource();
		}
		
		public int getCount(){
			return mDataSource.getDatasourceSize();
		}
		

		public Object getItem(int position) {
			return mDataSource.getList().get(position);
			
		}

		public long getItemId(int position) {
			
			return position;
		}
		
		public Drawable LoadImageFromUrl(String url) {
		    try {
		        InputStream is = (InputStream) new URL(url).getContent();
		        Drawable d = Drawable.createFromStream(is, "src");
		        return d;
		    } catch (Exception e) {
		        return null;
		    }
		}
		
		// Get a view that displays the data at the specified position in the data set.
		
		public View getView(int position, View convertView, ViewGroup parent) {

			TextView title, author, year;			
			ImageView isBookshelf, isRead,tn;

			String url = "http://l.mfcdn.net/store/manga/8/cover.jpg?1349859487";
	
			if (convertView == null){
				convertView = mInflator.inflate(R.layout.list_book, parent, false);
			}
			
			// Thumbnail logic
			tn = (ImageView)convertView.findViewById(R.id.thumbnail);			
			ImageLoader imageLoader = ImageLoader.getInstance();
			// Initialize ImageLoader with configuration. Do it once.
			imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));
			// Load and display image asynchronously
			imageLoader.displayImage(url, tn);	
				
			// Check if bookshelf 
			isBookshelf = (ImageView)convertView.findViewById(R.id.isBookshelf);
			isBookshelf.setImageResource(R.drawable.seal);
			
			// Check if read
			isRead = (ImageView)convertView.findViewById(R.id.isRead);
			isRead.setImageResource(R.drawable.notification);
			
			// Get book title
			title = (TextView)convertView.findViewById(R.id.name);
			title.setText(mDataSource.getTitleAtIndex(position));										
						
			// Get author
			author = (TextView)convertView.findViewById(R.id.author);
			author.setText(mDataSource.getAuthorAtIndex(position));
			
			// Get year
			year = (TextView)convertView.findViewById(R.id.year);
			year.setText(mDataSource.getYearAtIndex(position));					
			
			return convertView;
		}
	}
				
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_bookshelf);

        final ListView listView = (ListView)findViewById(R.id.ListView01);
        listView.setAdapter(new BookshelfAdapter(this));        //
	
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//Object o = listView.getItemAtPosition(position);
		        //Book bookObject = (Book)o;		        
		        
		        Intent i = new Intent(UserBookshelf.this, BookDetail.class);
        		//i.putExtra("position", position);
        		i.putExtra("position", position);
        		startActivity(i);
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_user_bookshelf, menu);
        	
        return true;
    }      
}
