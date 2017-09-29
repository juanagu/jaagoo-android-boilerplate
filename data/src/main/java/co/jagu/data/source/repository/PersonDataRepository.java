package co.jagu.data.source.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.entity.mapper.EntityDataMapper;
import co.jagu.data.injection.LocalDataSource;
import co.jagu.data.injection.RemoteDataSource;
import co.jagu.data.injection.Repository;
import co.jagu.data.source.PersonDataSource;
import co.jagu.domain.Person;
import co.jagu.domain.repository.PersonRepository;
import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * Repository for person entity
 */
@Repository

@Singleton
public class PersonDataRepository extends BaseDataRepository<PersonEntity, Person>
        implements PersonRepository {

    /*--
    Dependency
    -- */
    private PersonDataSource mLocalDataSource;
    private PersonDataSource mRemoteDataSource;

    /*--
    Constructor
    --*/
    @Inject
    public PersonDataRepository(@LocalDataSource PersonDataSource localDataSource,
                                @RemoteDataSource PersonDataSource remoteDataSource,
                                EntityDataMapper<PersonEntity, Person> entityDataMapper) {
        super(entityDataMapper);
        this.mLocalDataSource = localDataSource;
        this.mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Flowable<List<Person>> getAll() {
        return null;
    }

    /*--
        Implementation of {@link PersonRepository}
        --*/
    @Override
    public Flowable<Person> getById(Long id) {
        return mLocalDataSource.getById(id).map(entityDataMapper::transform);
    }

    @Override
    public Completable deleteById(Long id) {
        return Completable.fromAction(() -> mLocalDataSource.deleteById(id));
    }

    @Override
    public Flowable<Person> insertOrUpdate(Person entity) {
        return mLocalDataSource
                .insertOrUpdate(entityDataMapper.mapping(entity))
                .map(entityDataMapper::transform);
    }
}
