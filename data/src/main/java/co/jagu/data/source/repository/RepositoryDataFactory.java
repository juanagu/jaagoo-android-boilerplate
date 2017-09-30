package co.jagu.data.source.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.entity.mapper.EntityDataMapper;
import co.jagu.data.injection.LocalDataSource;
import co.jagu.data.injection.RemoteDataSource;
import co.jagu.data.source.PersonDataSource;
import co.jagu.domain.Person;
import co.jagu.domain.repository.PersonRepository;

@Singleton
public class RepositoryDataFactory implements RepositoryFactory {

    @Inject
    EntityDataMapper<PersonEntity, Person> personEntityDataMapper;

    @Inject
    @RemoteDataSource
    PersonDataSource remotePersonDataSource;

    @Inject
    @LocalDataSource
    PersonDataSource localPersonDataSource;

    /**
     * Implementation of {@link RepositoryFactory}
     */

    public PersonRepository createPersonRepository() {
        return new PersonDataRepository(localPersonDataSource,
                remotePersonDataSource,
                personEntityDataMapper);
    }
}
