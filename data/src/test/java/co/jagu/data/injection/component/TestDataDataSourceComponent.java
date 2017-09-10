package co.jagu.data.injection.component;

import javax.inject.Singleton;

import co.jagu.data.injection.module.TestDatabaseModule;
import co.jagu.data.source.local.dao.BaseDaoTest;
import dagger.Component;

@Singleton
@Component(modules = {TestDatabaseModule.class})
public interface TestDataDataSourceComponent extends LocalDataSourceComponent {

    void inject(BaseDaoTest baseDaoTest);
}
