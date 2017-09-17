package co.jagu.data.source.local;

import org.reactivestreams.Subscriber;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.injection.LocalDataSource;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.local.dao.PersonDao;
import io.reactivex.Flowable;

@Singleton
@LocalDataSource
public class LocalPersonDataSource implements PersonDataSource {

    /*--
    Dependency
    --*/

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
    public Flowable<PersonEntity> insertOrUpdate(PersonEntity entity) {
        return new Flowable<PersonEntity>() {
            @Override
            protected void subscribeActual(Subscriber<? super PersonEntity> s) {
                try {
                    //insert or replace person
                    long personId = mPersonDao.insertOrUpdate(entity);
                    //set id
                    entity.setId(personId);

                    s.onNext(entity);
                    s.onComplete();
                } catch (Exception e) {
                    s.onError(e);
                }

            }
        };
    }
}
