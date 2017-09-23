package co.jagu.data.injection.component;

import javax.inject.Singleton;

import co.jagu.data.injection.Repository;
import co.jagu.data.injection.module.PersonRepositoryModule;
import co.jagu.data.source.PersonDataSource;
import dagger.Component;


@Singleton
@Component(modules = {PersonRepositoryModule.class})
public interface RepositoryComponent {

    @Repository
    PersonDataSource getPersonRepository();
}
