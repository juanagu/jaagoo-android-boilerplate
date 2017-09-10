package co.jagu.data.injection.module;

import javax.inject.Named;
import javax.inject.Singleton;

import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.remote.RemotePersonDataSource;
import co.jagu.data.source.remote.api.PersonApi;
import dagger.Module;
import dagger.Provides;


@Module
public class RemoteDataSourceModule {

    @Provides
    @Singleton
    @Named(PersonDataSource.INJECTION_REMOTE_NAME)
    PersonDataSource provideRemotePersonDataSource(PersonApi personApi) {
        return new RemotePersonDataSource(personApi);
    }
}
