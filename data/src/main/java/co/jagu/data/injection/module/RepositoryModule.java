package co.jagu.data.injection.module;

import javax.inject.Named;
import javax.inject.Singleton;

import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.repository.PersonRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by juanagu on 10/9/17.
 */

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    @Named(PersonDataSource.INJECTION_REPOSITORY_NAME)
    PersonDataSource providePersonRepository(PersonDataSource local,
                                             PersonDataSource remote) {
        return new PersonRepository(local, remote);
    }
}
