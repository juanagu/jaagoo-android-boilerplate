package co.jagu.data.injection.factory;


import android.content.Context;

import co.jagu.data.injection.module.DatabaseModule;
import co.jagu.data.injection.module.NetworkModule;

/**
 * factory module for DI using dagger
 */
public interface ModuleFactory {

    /**
     * {@link DatabaseModule}
     *
     * @param context
     * @param databaseName
     * @return
     */
    DatabaseModule createDatabaseModule(Context context, String databaseName);

    /**
     * {@link NetworkModule}
     *
     * @param url
     * @return
     */
    NetworkModule createNetworkModule(String url);


}
