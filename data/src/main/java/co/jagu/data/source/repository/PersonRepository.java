package co.jagu.data.source.repository;

import java.util.List;

import javax.inject.Inject;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.PersonDataSource;
import io.reactivex.Flowable;

/**
 * Repository for person entity
 */
public class PersonRepository implements PersonDataSource {

    @Inject
    private PersonDataSource mLocalDataSource;
    @Inject
    private PersonDataSource mRemoteDataSource;

    @Override
    public Flowable<List<PersonEntity>> getAll() {
        return null;
    }

    @Override
    public Flowable<PersonEntity> getById(Long id) {
        return null;
    }

    @Override
    public void insertOrUpdate(PersonEntity entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(Long id) {

    }
}
