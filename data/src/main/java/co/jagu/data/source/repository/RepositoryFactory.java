package co.jagu.data.source.repository;

import co.jagu.data.injection.Repository;
import co.jagu.data.source.PersonDataSource;

public abstract class RepositoryFactory {

    /**
     * create an instance for {@link Repository} {@link PersonDataSource} implementation
     *
     * @param localPersonDataSource
     * @param remotePersonDataSource
     * @return
     */
    public static PersonDataSource createPersonRepository(PersonDataSource localPersonDataSource,
                                                          PersonDataSource remotePersonDataSource) {
        return new PersonRepository(localPersonDataSource, remotePersonDataSource);
    }
}
