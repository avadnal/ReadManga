package com.example.mangareader;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomBookshelfAdapter extends BaseAdapter {
	
	private static ArrayList<Book> searchArrayList;
	private LayoutInflater mInflater;

	public CustomBookshelfAdapter(Context context, ArrayList<Book> results) {
		  searchArrayList = results;
		  mInflater = LayoutInflater.from(context);
	}
	
	public int getCount(){
		return searchArrayList.size();
	}
	


	public Object getItem(int position) {
		return searchArrayList.get(position);
		
	}

	public long getItemId(int position) {
		
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		  if (convertView == null) {
			   convertView = mInflater.inflate(R.layout.list_book, null);
			   holder = new ViewHolder();
			   holder.txtName = (TextView) convertView.findViewById(R.id.name);
			   holder.txtAuthor = (TextView) convertView.findViewById(R.id.author);
			   holder.txtYear = (TextView) convertView.findViewById(R.id.year);
	
			   convertView.setTag(holder);
		  } else {
			  holder = (ViewHolder) convertView.getTag();
		  }
		  
		  holder.txtName.setText(searchArrayList.get(position).getTitle());
		  holder.txtAuthor.setText(searchArrayList.get(position).getAuthor());
		  holder.txtYear.setText(searchArrayList.get(position).getYearReleased());

		  return convertView;
		 }
	
		 static class ViewHolder {
			 TextView txtName;
			 TextView txtAuthor;
			 TextView txtYear;
		 }
}
