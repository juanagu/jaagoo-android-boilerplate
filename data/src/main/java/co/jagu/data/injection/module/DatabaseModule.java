package co.jagu.data.injection.module;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.jagu.data.injection.DatabaseInfo;
import co.jagu.data.source.local.dao.AppDatabase;
import co.jagu.data.source.local.dao.PersonDao;
import co.jagu.data.source.local.factory.LocalDataSourceBaseFactory;
import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    /*--
    Dependency
    --*/
    protected Context context;
    protected String databaseName;

    @Inject
    public DatabaseModule(Context context,
                          @DatabaseInfo String databaseName) {
        this.context = context;
        this.databaseName = databaseName;
    }

    /*--
    Provides
    --*/
    @Provides
    @Singleton
    protected AppDatabase provideDatabase() {
        return LocalDataSourceBaseFactory.createAppDatabase(context,
                databaseName,
                false);
    }

    @Provides
    @Singleton
    protected PersonDao providePersonDao(AppDatabase database) {
        return database.personDao();
    }
}
