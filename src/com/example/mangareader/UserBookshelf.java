package com.example.mangareader;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import android.os.Bundle;
import android.view.Menu;

@ContentView(R.layout.activity_user_bookshelf)
public class UserBookshelf extends RoboActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	//test
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_user_bookshelf, menu);
        
        return true;
    }
}
