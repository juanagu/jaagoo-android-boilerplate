package co.jagu.data.source.remote;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.injection.RemoteDataSource;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.local.dao.factory.LocalPersonFakeFactory;
import co.jagu.data.source.remote.api.PersonApi;
import io.reactivex.Flowable;

/**
 * Unit test for {@link RemotePersonDataSource}
 */
@RunWith(MockitoJUnitRunner.class)
public class RemotePersonDataSourceTest extends BaseRemoteDataSourceTest {

    /*--
    Constants
    --*/
    private static final long FAKE_PERSON_ID = 1L;
    /*--
    Dependency
    --*/

    @Mock
    private PersonApi mPersonApi;

    /*--
    Fields
    --*/
    @InjectMocks
    RemotePersonDataSource mRemotePersonDataSource;

    /*--
    Conf
    --*/
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    /*--
    Test
    --*/

    @Test
    public void getPersonById() {

        PersonEntity person = LocalPersonFakeFactory.createPerson();

        //Mock get in personApi
        Mockito.when(mPersonApi.getPersonById(FAKE_PERSON_ID)).then(invocationOnMock -> Flowable
                .fromArray(person));

        mRemotePersonDataSource.getById(FAKE_PERSON_ID).test()
                .assertValue(personEntity -> personEntity != null
                        && personEntity.getFirstName().equals(person.getFirstName())
                        && personEntity.getLastName().equals(person.getLastName()));

    }

}
