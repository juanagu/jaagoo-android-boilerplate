package co.jagu.data.source.remote;

import javax.inject.Inject;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.remote.api.PersonApi;
import io.reactivex.Flowable;

/**
 * Created by juanagu on 30/8/17.
 */

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
    Implementation of PersonDatasource
    --*/

    @Override
    public Flowable<PersonEntity> getById(Long id) {
        return mPersonApi.getPersonById(id);
    }

    @Override
    public long insertOrUpdate(PersonEntity entity) {
        return 0;
    }
}
