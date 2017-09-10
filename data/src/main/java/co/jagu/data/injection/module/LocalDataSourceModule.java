package co.jagu.data.injection.module;

import javax.inject.Named;
import javax.inject.Singleton;

import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.local.LocalPersonDataSource;
import co.jagu.data.source.local.dao.PersonDao;
import dagger.Module;
import dagger.Provides;

@Module
public class LocalDataSourceModule {


    @Provides
    @Singleton
    @Named(PersonDataSource.INJECTION_LOCAL_NAME)
    protected PersonDataSource provideLocalPersonDataSource(PersonDao personDao) {
        return new LocalPersonDataSource(personDao);
    }
}
