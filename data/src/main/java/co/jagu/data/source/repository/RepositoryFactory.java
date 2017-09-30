package co.jagu.data.source.repository;

import co.jagu.data.injection.Repository;
import co.jagu.data.source.PersonDataSource;
import co.jagu.domain.repository.PersonRepository;

public interface RepositoryFactory {

    /**
     * create an instance for {@link Repository}
     *
     * @return
     */
    PersonRepository createPersonRepository();
}
