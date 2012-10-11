package com.example.mangareader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
//import roboguice.activity.RoboActivity;
//import roboguice.inject.ContentView;
import android.widget.TextView;

// TEST COMMENT
//@ContentView(R.layout.activity_user_bookshelf)
public class UserBookshelf extends Activity{//RoboActivity {
	
	public class BookshelfAdapter extends BaseAdapter {
		
		private Context mContext;
		
		// mInflator used to instantiate layout XML file into its corresponding View objects.
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
		
		// Get a view that displays the data at the specified position in the data set.
		
		public View getView(int position, View convertView, ViewGroup parent) {
			//ImageView thumbnail;
			TextView title;
			TextView author;
			
			if (convertView == null){
				convertView = mInflator.inflate(R.layout.list_book, parent, false);
						//(R.layout.list_item_layout, parent, false);
			}
			
//			thumbnail = (ImageView)convertView.findViewById(R.list.thumb);
//			thumb\nail.setImageResource(mDataSource.getmPhotoPool().get(position));
			
			title = (TextView)convertView.findViewById(R.id.name);
			title.setText(mDataSource.getTitleAtIndex(position));										
						
			author = (TextView)convertView.findViewById(R.id.author);
			author.setText(mDataSource.getAuthorAtIndex(position));
			
			return convertView;
		}
	}
		
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_bookshelf);

        final ListView listView = (ListView)findViewById(R.id.ListView01);
        listView.setAdapter(new BookshelfAdapter(this));
        //listView.setAdapter(new CustomBookshelfAdapter(this, dataList));
	
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