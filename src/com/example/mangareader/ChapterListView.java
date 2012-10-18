package com.example.mangareader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ChapterListView extends Activity {

	private int mPosition;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_chapters);
        
        final ListView listView = (ListView)findViewById(R.id.chapterListView);
        
        ListAdapter adapter = new ListAdapter(this);
        Intent i = getIntent();
        mPosition = i.getIntExtra("position", 0);
        
        // so we can get the information of the book at position
        adapter.setPosition(mPosition);
        listView.setAdapter(adapter);
        
//        listView.setOnClickListener(new AdapterView.OnItemClickListener() {
//        	public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				//Object o = listView.getItemAtPosition(position);
//		        //Book bookObject = (Book)o;		        
//
//		        Intent i = new Intent(ChapterListView.this, BookCha.class);
//        		//i.putExtra("position", position);
//        		i.putExtra("position", position);
//        		startActivity(i);
//			}
//		});
		
        
        
        
	}
	
	public class ListAdapter extends BaseAdapter {

		private Context mContext;
		private LayoutInflater mInflator;
		private Datasource mDataSource;
		private int mPosition;
		
		public ListAdapter(Context c) {
			mContext = c;
			mInflator = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mDataSource = new Datasource();

		}

		/**
		 * Get count of the CHAPTERS, not the number of books in the list
		 */
		
		public int getCount() {
			
			Integer chapters = mDataSource.getList().get(mPosition).getNumberOfChapters();
			System.out.println("CHAPTERS:"+chapters);
			return (int)chapters;
//			
		}

		public void setPosition(int position){
			mPosition = position;
		}
		
		public Object getItem(int position) {
			return mDataSource.getList().get(position);
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
//			ViewHolder holder = new ViewHolder();
			TextView chapterNumber;
			if (convertView == null){				
				convertView = mInflator.inflate(R.layout.list_chapters_textview, parent, false);	
				System.out.println("NULLLLLLL");
			}
			
			
			chapterNumber = (TextView)convertView.findViewById(R.id.chapterTextView);
			String format = String.format("CHAPTER: %d", position + 1);
			chapterNumber.setText(format);
			
			return convertView;
		}

	}
	
	public static class ViewHolder {
		TextView chapterNumber;
	}
}
