package co.jagu.data.source.remote;

import javax.inject.Inject;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.remote.api.PersonApi;
import io.reactivex.Flowable;

public class RemotePersonDataSource implements PersonDataSource {

    /*--
    Dependency
    --*/
    private PersonApi mPersonApi;

    /*--
    Constructors
    --*/
    @Inject
    public RemotePersonDataSource(PersonApi personApi) {
        this.mPersonApi = personApi;
    }
    /*--
    Implementation of {@link PersonDataSource}
    --*/

    @Override
    public Flowable<PersonEntity> getById(Long id) {
        return mPersonApi.getPersonById(id);
    }

    @Override
    public Flowable<PersonEntity> insertOrUpdate(PersonEntity entity) {
        long personId = entity.getId();
        if (personId == 0) {
            return mPersonApi.insert(entity);
        } else {
            return mPersonApi.update(personId, entity);
        }
    }
}
