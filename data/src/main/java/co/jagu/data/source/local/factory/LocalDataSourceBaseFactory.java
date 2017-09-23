package co.jagu.data.source.local.factory;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import co.jagu.data.source.local.dao.AppDatabase;

/**
 * Use this class for create instance the base local data source objects
 */
public abstract class LocalDataSourceBaseFactory {


    /**
     * Build room database with {@link AppDatabase}
     *
     * @param context
     * @param databaseName
     * @param forTest
     * @return
     */
    public static AppDatabase createAppDatabase(Context context,
                                                String databaseName,
                                                boolean forTest) {

        RoomDatabase.Builder<AppDatabase> appDatabaseBuilder;

        if (forTest) {
            //create database in memory and allow queries in main thread
            appDatabaseBuilder = Room
                    .inMemoryDatabaseBuilder(context, AppDatabase.class)
                    .allowMainThreadQueries();
        } else {
            appDatabaseBuilder = Room
                    .databaseBuilder(context, AppDatabase.class, databaseName);
        }

        return appDatabaseBuilder.build();
    }
}
