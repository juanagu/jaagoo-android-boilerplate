package co.jagu.data.injection.module;


import android.content.Context;

import javax.inject.Inject;

import co.jagu.data.injection.DatabaseInfo;
import co.jagu.data.source.local.dao.AppDatabase;
import co.jagu.data.source.local.factory.LocalDataSourceBaseFactory;

public class TestDatabaseModule extends DatabaseModule {

    @Inject
    public TestDatabaseModule(Context context,
                              @DatabaseInfo String databaseName) {
        super(context, databaseName);
    }


    @Override
    protected AppDatabase provideDatabase() {
        return LocalDataSourceBaseFactory.createAppDatabase(context, databaseName, true);
    }
}
