package co.jagu.data.source.repository;

import javax.inject.Inject;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.PersonDataSource;
import io.reactivex.Flowable;

/**
 * Repository for person entity
 */
public class PersonRepository implements PersonDataSource {

    /*--
    Dependency
    -- */
    private PersonDataSource mLocalDataSource;
    private PersonDataSource mRemoteDataSource;

    /*--
    Constructor
    --*/
    @Inject
    public PersonRepository(PersonDataSource localDataSource,
                            PersonDataSource remoteDataSource) {
        this.mLocalDataSource = localDataSource;
        this.mRemoteDataSource = remoteDataSource;
    }

    /*--
    Implementation of {@link PersonDataSource}
    --*/
    @Override
    public Flowable<PersonEntity> getById(Long id) {
        return mLocalDataSource.getById(id);
    }

    @Override
    public long insertOrUpdate(PersonEntity entity) {
        return mLocalDataSource.insertOrUpdate(entity);
    }
}
