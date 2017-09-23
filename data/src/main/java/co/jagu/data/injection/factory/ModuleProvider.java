package co.jagu.data.injection.factory;


import android.content.Context;

import javax.inject.Singleton;

import co.jagu.data.injection.module.DatabaseModule;
import co.jagu.data.injection.module.NetworkModule;

@Singleton
public class ModuleProvider implements ModuleFactory {

    @Override
    public DatabaseModule createDatabaseModule(Context context, String databaseName) {
        return new DatabaseModule(context, databaseName);
    }

    @Override
    public NetworkModule createNetworkModule(String url) {
        return new NetworkModule(url);
    }

}
