package readManga.daoDB;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.IdentityScopeType;

import readManga.daoDB.Genre;
import readManga.daoDB.Book;
import readManga.daoDB.Chapter;
import readManga.daoDB.Page;

import readManga.daoDB.GenreDao;
import readManga.daoDB.BookDao;
import readManga.daoDB.ChapterDao;
import readManga.daoDB.PageDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig genreDaoConfig;
    private final DaoConfig bookDaoConfig;
    private final DaoConfig chapterDaoConfig;
    private final DaoConfig pageDaoConfig;

    private final GenreDao genreDao;
    private final BookDao bookDao;
    private final ChapterDao chapterDao;
    private final PageDao pageDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        genreDaoConfig = daoConfigMap.get(GenreDao.class).clone();
        genreDaoConfig.initIdentityScope(type);

        bookDaoConfig = daoConfigMap.get(BookDao.class).clone();
        bookDaoConfig.initIdentityScope(type);

        chapterDaoConfig = daoConfigMap.get(ChapterDao.class).clone();
        chapterDaoConfig.initIdentityScope(type);

        pageDaoConfig = daoConfigMap.get(PageDao.class).clone();
        pageDaoConfig.initIdentityScope(type);

        genreDao = new GenreDao(genreDaoConfig, this);
        bookDao = new BookDao(bookDaoConfig, this);
        chapterDao = new ChapterDao(chapterDaoConfig, this);
        pageDao = new PageDao(pageDaoConfig, this);

        registerDao(Genre.class, genreDao);
        registerDao(Book.class, bookDao);
        registerDao(Chapter.class, chapterDao);
        registerDao(Page.class, pageDao);
    }
    
    public void clear() {
        genreDaoConfig.getIdentityScope().clear();
        bookDaoConfig.getIdentityScope().clear();
        chapterDaoConfig.getIdentityScope().clear();
        pageDaoConfig.getIdentityScope().clear();
    }

    public GenreDao getGenreDao() {
        return genreDao;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public ChapterDao getChapterDao() {
        return chapterDao;
    }

    public PageDao getPageDao() {
        return pageDao;
    }

}
