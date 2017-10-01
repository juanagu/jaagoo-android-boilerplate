package co.jagu.data.injection.component;

import javax.inject.Singleton;

import co.jagu.data.injection.module.DatabaseModule;
import co.jagu.data.source.local.dao.AppDatabase;
import co.jagu.data.source.local.dao.PersonDao;
import dagger.Component;

@Singleton
@Component(modules = {DatabaseModule.class})
public interface LocalDataSourceComponent {

    /*--
    base
    --*/
    AppDatabase appDatabase();

    /*--
    Dao
    --*/
    PersonDao personDao();


}
