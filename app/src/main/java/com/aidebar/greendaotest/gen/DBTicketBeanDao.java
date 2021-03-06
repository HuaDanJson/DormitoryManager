package com.aidebar.greendaotest.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.dormitory.myoschinatest.bean.DBTicketBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DBTICKET_BEAN".
*/
public class DBTicketBeanDao extends AbstractDao<DBTicketBean, Long> {

    public static final String TABLENAME = "DBTICKET_BEAN";

    /**
     * Properties of entity DBTicketBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property JingDianID = new Property(0, long.class, "jingDianID", true, "_id");
        public final static Property JingDianName = new Property(1, String.class, "jingDianName", false, "DBTicketBean");
        public final static Property JingDianYuPiao = new Property(2, int.class, "jingDianYuPiao", false, "JING_DIAN_YU_PIAO");
    }


    public DBTicketBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DBTicketBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DBTICKET_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: jingDianID
                "\"DBTicketBean\" TEXT," + // 1: jingDianName
                "\"JING_DIAN_YU_PIAO\" INTEGER NOT NULL );"); // 2: jingDianYuPiao
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DBTICKET_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DBTicketBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getJingDianID());
 
        String jingDianName = entity.getJingDianName();
        if (jingDianName != null) {
            stmt.bindString(2, jingDianName);
        }
        stmt.bindLong(3, entity.getJingDianYuPiao());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DBTicketBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getJingDianID());
 
        String jingDianName = entity.getJingDianName();
        if (jingDianName != null) {
            stmt.bindString(2, jingDianName);
        }
        stmt.bindLong(3, entity.getJingDianYuPiao());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public DBTicketBean readEntity(Cursor cursor, int offset) {
        DBTicketBean entity = new DBTicketBean( //
            cursor.getLong(offset + 0), // jingDianID
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // jingDianName
            cursor.getInt(offset + 2) // jingDianYuPiao
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DBTicketBean entity, int offset) {
        entity.setJingDianID(cursor.getLong(offset + 0));
        entity.setJingDianName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setJingDianYuPiao(cursor.getInt(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DBTicketBean entity, long rowId) {
        entity.setJingDianID(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DBTicketBean entity) {
        if(entity != null) {
            return entity.getJingDianID();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DBTicketBean entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
