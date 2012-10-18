package com.example.mangareader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class BookDetail extends Activity {
	
	private int mPosition;
	private Datasource mDataSource;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_detail_view);
        ViewHolder holder = new ViewHolder();
        Intent i = getIntent();
        
        mPosition = i.getIntExtra("position", 0);
        mDataSource = new Datasource();  
        
        
        Button chapterBtn = (Button)findViewById(R.id.chapterBtn);

        chapterBtn.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		Intent newIntent = new Intent(BookDetail.this, ChapterListView.class);
        		newIntent.putExtra("position", mPosition);
        		startActivity(newIntent);

	 	}});
        
        
        holder.mThumbnailLarge = (ImageView)findViewById(R.id.thumbnailLarge);
        
              
        ImageLoader.getInstance().displayImage(mDataSource.getUrlAtIndex(mPosition), holder.mThumbnailLarge);
                
        holder.mTitle = (TextView)findViewById(R.id.titleDetail);
        holder.mAuthor = (TextView)findViewById(R.id.authorDetail);   
        holder.mDescription = (TextView)findViewById(R.id.description);
        
        // Don't like displaying a year as a new line
        String titleAndYearText = String.format("%s (%s)",
        		mDataSource.getTitleAtIndex(mPosition),
        		mDataSource.getYearAtIndex(mPosition));
        
        holder.mTitle.setText(titleAndYearText);
        holder.mAuthor.setText(mDataSource.getAuthorAtIndex(mPosition));      
        holder.mDescription.setText(mDataSource.getDescriptionAtIndex(mPosition));
        
	}

	public static class ViewHolder {
		View mThumbnailParentView;
		TextView mTitle, mAuthor, mDescription;
		ImageView mThumbnailLarge;
    }
	
}
