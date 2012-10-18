package com.example.mangareader;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

import readManga.daoDB.Book;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

public class UserBookshelf extends ListActivity {
	
	private BookshelfAdapter mAdapter;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new BookshelfAdapter(this);
        mAdapter.createDataSource();
        ListView listView = getListView();
//        for (Book book : mAdapter.getBooks()){
//        	if (book.getGenre().getGenreName().equals("adventure")){
//        		mAdapter.addSeparatorItem("Adventure");
//        	}
//        }        
        
//        setListAdapter(mAdapter);
        //setContentView(R.layout.activity_user_bookshelf);

//        final ListView listView = (ListView)findViewById(R.id.ListView01);
        listView.setAdapter(mAdapter);
//
//        
//        
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

		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
	        .cacheInMemory()
	        .cacheOnDisc()
	        .build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
	        .defaultDisplayImageOptions(defaultOptions)
	        .build();
		ImageLoader.getInstance().init(config);

        
    }
	
	public class BookshelfAdapter extends BaseAdapter {
		
		private Context mContext;				
		private LayoutInflater mInflator;
		private Datasource mDataSource;
		private boolean[] separateIndex;
		
		private static final int TYPE_ITEM = 0;
        private static final int TYPE_SEPARATOR = 1;
        private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;
        private TreeSet<Integer> mSeparatorsSet = new TreeSet<Integer>();
		
		
		public BookshelfAdapter(Context c){
			mContext = c;
			mInflator = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			//mDataSource = new Datasource();
			//separateIndex = assignSeparatorPositions();
		}
		
		public void createDataSource(){
			mDataSource = new Datasource();
		}
		
		public void addSeparatorItem(final String item) {
            mSeparatorsSet.add(getCount() - 1);
            notifyDataSetChanged();
        }
		
        @Override
        public int getItemViewType(int position) {
            return mSeparatorsSet.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
        }
        
        @Override
        public int getViewTypeCount() {
            return TYPE_MAX_COUNT;
        }
		
		public int getCount(){
			return mDataSource.getDatasourceSize();
		}
		

		public Object getItem(int position) {
			return mDataSource.getList().get(position);
			
		}
		
		public String getGenreStringAtIndex(int index){
			return mDataSource.getList().get(index).getGenre().getGenreName();

		}

		public long getItemId(int position) {
			
			return position;
		}
		
		public ArrayList<Book> getBooks(){
			return mDataSource.getList();
		}

		// Get a view that displays the data at the specified position in the data set.
		
		public View getView(int position, View convertView, ViewGroup parent) {
						

			ViewHolder holder = null;
			int type = getItemViewType(position);
			System.out.println("TYPE = "+type);
			
			if (convertView == null){
				holder = new ViewHolder();
				switch (type){
					case TYPE_ITEM:						
		                convertView = mInflator.inflate(R.layout.list_book, null);		                		                		                
		                holder.tn = (ImageView)convertView.findViewById(R.id.thumbnail);
		                holder.isBookshelf = (ImageView)convertView.findViewById(R.id.isBookshelf);
		                holder.isRead = (ImageView)convertView.findViewById(R.id.isRead);
		                holder.title = (TextView)convertView.findViewById(R.id.name);
		                holder.author = (TextView)convertView.findViewById(R.id.author);
		                holder.year = (TextView)convertView.findViewById(R.id.year);	
		                break;
		                
		            case TYPE_SEPARATOR:
		            	System.out.println("IN HEREEEEEEEEE");
		                convertView = mInflator.inflate(R.layout.list_section, null);
		                holder.separator = (TextView)convertView.findViewById(R.id.separator);
		                //holder.separator.setVisibility(View.VISIBLE);
		                break;
				}
				convertView.setTag(holder);
				//convertView = mInflator.inflate(R.layout.list_book, parent, false);
			
			} else {
				holder = (ViewHolder)convertView.getTag();
			}
			
//			ImageLoader imageLoader = ImageLoader.getInstance();
//			// Initialize ImageLoader with configuration. Do it once.
//			imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));
//			// Load and display image asynchronously
//			imageLoader.displayImage(mDataSource.getUrlAtIndex(position), holder.tn);	
			ImageLoader.getInstance().displayImage(mDataSource.getUrlAtIndex(position), holder.tn);

			holder.isBookshelf.setImageResource(R.drawable.seal);
			holder.isRead.setImageResource(R.drawable.notification);
			holder.title.setText(mDataSource.getTitleAtIndex(position));										
			holder.author.setText(mDataSource.getAuthorAtIndex(position));
			holder.year.setText(mDataSource.getYearAtIndex(position));	

            return convertView;

		}
	}
				

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_user_bookshelf, menu);
        	
        return true;
    } 
    
    public static class ViewHolder {
    	TextView title, author, year, separator;			
		ImageView isBookshelf, isRead, tn;
    }
    
}
