package readManga.daoDB;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.SqlUtils;

import readManga.daoDB.Page;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table PAGE.
*/
public class PageDao extends AbstractDao<Page, Long> {

    public static final String TABLENAME = "PAGE";

    /**
     * Properties of entity Page.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property PageNumber = new Property(1, String.class, "pageNumber", false, "PAGE_NUMBER");
        public final static Property ImageLink = new Property(2, String.class, "imageLink", false, "IMAGE_LINK");
        public final static Property ChapterId = new Property(3, long.class, "chapterId", false, "CHAPTER_ID");
    };

    private DaoSession daoSession;


    public PageDao(DaoConfig config) {
        super(config);
    }
    
    public PageDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'PAGE' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'PAGE_NUMBER' TEXT," + // 1: pageNumber
                "'IMAGE_LINK' TEXT," + // 2: imageLink
                "'CHAPTER_ID' INTEGER NOT NULL );"); // 3: chapterId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'PAGE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Page entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String pageNumber = entity.getPageNumber();
        if (pageNumber != null) {
            stmt.bindString(2, pageNumber);
        }
 
        String imageLink = entity.getImageLink();
        if (imageLink != null) {
            stmt.bindString(3, imageLink);
        }
        stmt.bindLong(4, entity.getChapterId());
    }

    @Override
    protected void attachEntity(Page entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Page readEntity(Cursor cursor, int offset) {
        Page entity = new Page( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // pageNumber
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // imageLink
            cursor.getLong(offset + 3) // chapterId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Page entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPageNumber(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setImageLink(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setChapterId(cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Page entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Page entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getChapterDao().getAllColumns());
            builder.append(" FROM PAGE T");
            builder.append(" LEFT JOIN CHAPTER T0 ON T.'CHAPTER_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Page loadCurrentDeep(Cursor cursor, boolean lock) {
        Page entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Chapter chapter = loadCurrentOther(daoSession.getChapterDao(), cursor, offset);
         if(chapter != null) {
            entity.setChapter(chapter);
        }

        return entity;    
    }

    public Page loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Page> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Page> list = new ArrayList<Page>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Page> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Page> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
