package co.jagu.data.injection.module;

import co.jagu.data.injection.LocalDataSource;
import co.jagu.data.injection.RemoteDataSource;
import co.jagu.data.injection.Repository;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.local.LocalDataSourceFactory;
import co.jagu.data.source.local.dao.PersonDao;
import co.jagu.data.source.remote.RemoteDataSourceFactory;
import co.jagu.data.source.remote.api.PersonApi;
import co.jagu.data.source.repository.RepositoryFactory;
import dagger.Module;
import dagger.Provides;

@Module(includes = {DatabaseModule.class, NetworkModule.class})
public class PersonRepositoryModule {

    @Provides
    @LocalDataSource
    PersonDataSource provideLocalPersonDataSource(PersonDao personDao) {
        return LocalDataSourceFactory.createPersonDataSource(personDao);
    }

    @Provides
    @RemoteDataSource
    PersonDataSource provideRemotePersonDataSource(PersonApi personApi) {
        return RemoteDataSourceFactory.createPersonDataSource(personApi);
    }

    @Provides
    @Repository
    PersonDataSource providePersonRepository(@LocalDataSource PersonDataSource
                                                     localPersonDataSource,
                                             @RemoteDataSource PersonDataSource
                                                     remotePersonDataSource) {
        return RepositoryFactory
                .createPersonRepository(localPersonDataSource, remotePersonDataSource);
    }
}
