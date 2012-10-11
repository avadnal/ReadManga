package readManga.daoManager;

import readManga.daoDB.*;
import android.content.Context;
import readManga.daoDB.DaoMaster.OpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DAOManager
{
	public void insertBook(Context context, Book newBook)
	{
		OpenHelper helper = new DaoMaster.DevOpenHelper(context, "", null);
		SQLiteDatabase db 
		DaoMaster daoMaster = new DaoMaster(db);
	}
}
