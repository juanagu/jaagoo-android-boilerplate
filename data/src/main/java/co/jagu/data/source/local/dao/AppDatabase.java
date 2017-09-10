package co.jagu.data.source.local.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import co.jagu.data.entity.PersonEntity;

/**
 * The Room Database
 */
@Database(entities = {PersonEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    /*--
    Constant
    --*/
    public final static String DB_NAME = "app_db";

    /*--
    Dao
    -- */
    public abstract PersonDao personDao();

}
