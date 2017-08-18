package co.jagu.data.source.local;

import javax.inject.Inject;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.local.dao.PersonDao;
import io.reactivex.Flowable;


public class LocalPersonDataSource implements PersonDataSource {

    private final PersonDao mPersonDao;

    @Inject
    public LocalPersonDataSource(PersonDao personDao) {
        this.mPersonDao = personDao;
    }

    /*--
    Implementation of PersonDataSource
    --*/

    @Override
    public Flowable<PersonEntity> getById(Long id) {
        return mPersonDao.getPersonById(id);
    }

    @Override
    public long insertOrUpdate(PersonEntity entity) {
        return mPersonDao.insertOrUpdate(entity);
    }
}
