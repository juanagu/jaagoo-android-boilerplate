package co.jagu.data.source.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.injection.LocalDataSource;
import co.jagu.data.injection.RemoteDataSource;
import co.jagu.data.source.PersonDataSource;
import io.reactivex.Flowable;

/**
 * Repository for person entity
 */
@Singleton
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
    public PersonRepository(@LocalDataSource PersonDataSource localDataSource,
                            @RemoteDataSource PersonDataSource remoteDataSource) {
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
    public Flowable<PersonEntity> insertOrUpdate(PersonEntity entity) {
        return mLocalDataSource.insertOrUpdate(entity);
    }
}
