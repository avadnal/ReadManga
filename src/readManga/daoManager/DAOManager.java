package readManga.daoManager;

import java.util.ArrayList;

import readManga.daoDB.*;
import android.content.Context;
import readManga.daoDB.DaoMaster.DevOpenHelper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DAOManager
{
	private Context context;
	private SQLiteDatabase db;
	private DaoMaster daoMaster;
	private DaoSession daoSession;
	private Cursor cursor;
	
	public DAOManager(Context context)
	{
		this.context = context;
		DevOpenHelper helper = new DaoMaster.DevOpenHelper(this.context, "", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
	}
	
	public ArrayList<Book> getAllBooks()
	{
		BookDao bookDao = daoSession.getBookDao();
		ArrayList<Book> bookArray = new ArrayList<Book>();
		cursor = db.query(bookDao.getTablename(), bookDao.getAllColumns(), null, null, null, null, null);
		if (cursor.getCount() > 0)
		{
			do
			{
				Book b = new Book();
				b.setTitle(cursor.getString(cursor.getColumnIndex(BookDao.Properties.Title.columnName)));
				bookArray.add(b);
			}
			while (!cursor.isLast());
		}
		cursor.close();
		System.out.println("book found = " + bookArray.size());
		return bookArray;
	}
	
	public Book getBookById(int id)
	{
		BookDao bookDao = daoSession.getBookDao();
		Book returnBook = null;
		cursor = db.query(bookDao.getTablename(), bookDao.getAllColumns(), "id = ?", new String[] {(new Integer(id)).toString()}, null, null, null);
		if (cursor.getCount() > 0)
		{
			returnBook = new Book();
			returnBook.setTitle(cursor.getString(cursor.getColumnIndex(BookDao.Properties.Title.columnName)));
		}
		cursor.close();
		System.out.println("book found = " + returnBook.getTitle());
		return returnBook;
	}
	
	public void insertBook(Book newBook)
	{
		BookDao bookDao = daoSession.getBookDao();
		
	}

	public Context getContext()
	{
		return context;
	}

	public void setContext(Context context)
	{
		this.context = context;
	}
}
