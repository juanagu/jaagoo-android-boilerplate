package co.jagu.data.source.local;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.local.dao.PersonDao;
import co.jagu.data.source.local.dao.factory.LocalPersonFakeFactory;
import io.reactivex.Flowable;
import io.reactivex.subscribers.TestSubscriber;

/**
 * Unit test for {@link LocalPersonDataSource}
 */
@RunWith(MockitoJUnitRunner.class)
public class LocalPersonDataSourceTest extends BaseLocalDataSourceTest {

    /*--
    Constants
    --*/
    private static final long FAKE_PERSON_ID = 1;

    /*--
    Dependency
    --*/
    @Mock
    private PersonDao mPersonDao;

    /*--
    Fields
    --*/
    @InjectMocks
    private LocalPersonDataSource mLocalPersonDataSource;

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
    public void insertAndGetPerson() {

        PersonEntity person = LocalPersonFakeFactory.createPerson();

        //Mock insert in dao
        Mockito.when(mPersonDao.insertOrUpdate(person)).then(invocationOnMock ->
                FAKE_PERSON_ID);

        //insert person
        TestSubscriber<PersonEntity> insertOrUpdateTestSubscriber = mLocalPersonDataSource
                .insertOrUpdate(person).test();
        //check only return one result
        Assert.assertEquals(insertOrUpdateTestSubscriber.valueCount(), 1);

        long personId = insertOrUpdateTestSubscriber.values().get(0).getId();
        //check id is correct
        Assert.assertSame(personId, FAKE_PERSON_ID);

        //insertOrUpdate others
        mLocalPersonDataSource.insertOrUpdate(LocalPersonFakeFactory.createPerson());
        mLocalPersonDataSource.insertOrUpdate(LocalPersonFakeFactory.createPerson());

        //Mock get in dao
        Mockito.when(mPersonDao.getPersonById(FAKE_PERSON_ID)).then(invocationOnMock -> Flowable
                .fromArray(person));

        mLocalPersonDataSource.getById(FAKE_PERSON_ID).test()
                .assertValue(personEntity -> personEntity != null
                        && personEntity.getFirstName().equals(person.getFirstName())
                        && personEntity.getLastName().equals(person.getLastName()));

    }


}
