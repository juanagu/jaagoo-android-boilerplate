package co.jagu.data.injection.factory;

import android.content.Context;

import javax.inject.Singleton;

import co.jagu.data.injection.module.DatabaseModule;
import co.jagu.data.injection.module.TestDatabaseModule;

@Singleton
public class TestModuleFactory extends ModuleProvider implements ModuleFactory {

    @Override
    public DatabaseModule createDatabaseModule(Context context, String databaseName) {
        return new TestDatabaseModule(context, databaseName);
    }
}
