package co.jagu.data.injection.component;

import javax.inject.Singleton;

import co.jagu.data.injection.module.DatabaseModule;
import co.jagu.data.source.local.dao.BaseDaoTest;
import co.jagu.data.source.local.dao.PersonDaoTest;
import dagger.Component;

@Singleton
@Component(modules = {
        DatabaseModule.class})
public interface TestLocalDataSourceComponent extends LocalDataSourceComponent {

    /*--
    Injects
    --*/

    void inject(BaseDaoTest baseDaoTest);

    void inject(PersonDaoTest personDaoTest);
}
