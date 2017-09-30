package co.jagu.data.source.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.entity.mapper.EntityDataMapper;
import co.jagu.data.source.PersonDataSource;
import co.jagu.domain.Person;
import co.jagu.domain.repository.PersonRepository;

@Singleton
public class RepositoryDataFactory implements RepositoryFactory {

    @Inject
    EntityDataMapper<PersonEntity, Person> personEntityDataMapper;

    /**
     * Implementation of {@link RepositoryFactory}
     */

    public PersonRepository createPersonRepository(PersonDataSource localPersonDataSource,
                                                   PersonDataSource remotePersonDataSource) {
        return new PersonDataRepository(localPersonDataSource,
                remotePersonDataSource,
                personEntityDataMapper);
    }
}
