package co.jagu.data.source.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.local.dao.factory.LocalPersonFakeFactory;
import io.reactivex.Flowable;

/**
 * Unit test for {@link PersonRepository}
 */
public class PersonRepositoryTest {

    /*--
    Constants
    --*/
    private static final long FAKE_PERSON_ID = 1;

    /*--
    Dependency
    --*/
    @Mock
    PersonDataSource mLocalPersonDataSource;

    @Mock
    PersonDataSource mRemotePersonDataSource;
    /*--
    Fields
    --*/
    @InjectMocks
    private PersonRepository mPersonRepository;

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
        //stubbed response
        PersonEntity person = LocalPersonFakeFactory.createPerson();
        person.setId(FAKE_PERSON_ID);

        //stubbed local data source
        Mockito.when(mLocalPersonDataSource.getById(FAKE_PERSON_ID))
                .then(invocationOnMock -> Flowable.just(person));

        //get first result in repository
        PersonEntity personEntity = mPersonRepository.getById(FAKE_PERSON_ID)
                .test().assertNoErrors()
                .values().get(0);
        //check id is correct
        Assert.assertSame(personEntity.getId(), FAKE_PERSON_ID);
    }
}
