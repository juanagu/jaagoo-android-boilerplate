package co.jagu.data.injection.component;

import javax.inject.Named;
import javax.inject.Singleton;

import co.jagu.data.injection.module.DatabaseModule;
import co.jagu.data.injection.module.LocalDataSourceModule;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.local.dao.AppDatabase;
import co.jagu.data.source.local.dao.PersonDao;
import dagger.Component;

@Singleton
@Component(modules = {
        LocalDataSourceModule.class,
        DatabaseModule.class})
public interface LocalDataSourceComponent {

    /*--
    base
    --*/
    AppDatabase appDatabase();

    /*--
    Dao
    --*/
    PersonDao personDao();

    /*--
    Data Sources
    --*/
    @Named(PersonDataSource.INJECTION_LOCAL_NAME)
    PersonDataSource localPersonDataSource();


}
