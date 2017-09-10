package co.jagu.data.injection.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import co.jagu.data.source.local.dao.AppDatabase;
import co.jagu.data.source.local.dao.PersonDao;
import dagger.Module;
import dagger.Provides;

/**
 * Created by juanagu on 10/9/17.
 */

@Module
public class DatabaseModule {

    /*--
    Dependency
    --*/
    protected Context context;
    private String mDatabaseName;

    public DatabaseModule(Context context, String databaseName) {
        this.context = context;
        this.mDatabaseName = databaseName;
    }

    /*--
    Provides
    --*/
    @Singleton
    @Provides
    protected AppDatabase provideDatabase() {
        return Room.databaseBuilder(context,
                AppDatabase.class,
                mDatabaseName)
                .build();
    }

    @Singleton
    @Provides
    protected PersonDao providePersonDao(AppDatabase database) {
        return database.personDao();
    }
}
