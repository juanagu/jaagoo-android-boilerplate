package co.jagu.data.source.repository;

import org.apache.tools.ant.taskdefs.Length;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.entity.mapper.EntityDataMapper;
import co.jagu.data.entity.mapper.PersonEntityDataMapper;
import co.jagu.data.entity.mapper.PersonEntityDataMapperTest;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.local.dao.factory.LocalPersonFakeFactory;
import co.jagu.domain.Person;
import co.jagu.domain.repository.PersonRepository;
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

    private EntityDataMapper<PersonEntity, Person> mEntityDataMapper;
    /*--
    Fields
    --*/
    @InjectMocks
    PersonDataRepository mPersonRepository;

    /*--
    Conf
    --*/
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        //inject
        mEntityDataMapper = new PersonEntityDataMapper();
        //repository test
        mPersonRepository = new PersonDataRepository(mLocalPersonDataSource,
                mRemotePersonDataSource,
                mEntityDataMapper
        );
    }

    /*--
    Test
    --*/
    @Test
    public void getPersonById() throws Exception {
        //stubbed response
        PersonEntity personEntity = LocalPersonFakeFactory.createPerson();

        personEntity.setId(FAKE_PERSON_ID);

        //stubbed local data source
        Mockito.when(mLocalPersonDataSource.getById(FAKE_PERSON_ID))
                .thenReturn(Flowable.just(personEntity));

        //get first result in repository
        mPersonRepository.getById(FAKE_PERSON_ID)
                .test()
                .assertNoErrors()
                .assertValue(person1 -> person1 != null && person1.equals(personEntity));
    }
}
