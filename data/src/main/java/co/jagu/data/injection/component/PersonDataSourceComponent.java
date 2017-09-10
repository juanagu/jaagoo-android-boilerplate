package co.jagu.data.injection.component;

import javax.inject.Singleton;

import co.jagu.data.injection.module.RepositoryModule;
import co.jagu.data.source.PersonDataSource;
import dagger.Component;
import dagger.Module;

@Singleton
@Component(modules = {RepositoryModule.class})
public interface PersonDataSourceComponent {

    PersonDataSource personRepository();
}
