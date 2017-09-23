package co.jagu.data.source.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.local.dao.factory.LocalPersonFakeFactory;
import io.reactivex.Flowable;

/**
 * Unit test for {@link PersonRepository}
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonRepositoryTest extends BaseRepositoryTest {

    /*--
    Constants
    --*/
    private static final long FAKE_PERSON_ID = 1;

    /*--
    Dependency
    --*/
    @Mock
    private PersonDataSource mLocalPersonDataSource;

    @Mock
    private PersonDataSource mRemotePersonDataSource;
    /*--
    Fields
    --*/
    @InjectMocks
    PersonRepository mPersonRepository;

    /*--
    Conf
    --*/
    @Before
    public void setUp() throws Exception {
        mPersonRepository = new PersonRepository(mLocalPersonDataSource, mRemotePersonDataSource);
    }

    /*--
    Test
    --*/
    @Test
    public void getPersonById() throws Exception {
        //stubbed response
        PersonEntity person = LocalPersonFakeFactory.createPerson();
        person.setId(FAKE_PERSON_ID);

        //stubbed local data source
        Mockito.when(mLocalPersonDataSource.getById(FAKE_PERSON_ID))
                .thenReturn(Flowable.just(person));

        //get first result in repository
        mPersonRepository.getById(FAKE_PERSON_ID)
                .test()
                .assertNoErrors()
                .assertValue(personEntity -> personEntity != null && personEntity.equals(person));
    }
}
