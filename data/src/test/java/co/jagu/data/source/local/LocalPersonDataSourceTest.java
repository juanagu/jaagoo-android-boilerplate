package co.jagu.data.source.local;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.local.dao.PersonDao;
import co.jagu.data.source.local.dao.factory.LocalPersonFakeFactory;
import io.reactivex.Flowable;
import io.reactivex.subscribers.TestSubscriber;

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
    private PersonDataSource mDataSource;

    /*--
     Conf
     --*/
    @Before
    public void init() {
        mDataSource = new LocalPersonDataSource(mPersonDao);
    }

    /*--
     Test
     --*/
    @Test
    public void insertAndGetUser() {

        PersonEntity person = LocalPersonFakeFactory.createPerson();

        //Mock insert in dao
        Mockito.when(mPersonDao.insertOrUpdate(person)).then(invocationOnMock ->
                FAKE_PERSON_ID);

        TestSubscriber<PersonEntity> insertOrUpdateTestSubscriber = mDataSource
                .insertOrUpdate(person).test();
        Assert.assertEquals(insertOrUpdateTestSubscriber.valueCount(), 1);
        long personId = insertOrUpdateTestSubscriber.values().get(0).getId();

        Assert.assertSame(personId, FAKE_PERSON_ID);

        //insertOrUpdate others
        mDataSource.insertOrUpdate(LocalPersonFakeFactory.createPerson());
        mDataSource.insertOrUpdate(LocalPersonFakeFactory.createPerson());

        //Mock get in dao
        Mockito.when(mPersonDao.getPersonById(FAKE_PERSON_ID)).then(invocationOnMock -> Flowable
                .fromArray(person));

        mDataSource.getById(FAKE_PERSON_ID).test().assertValue(personEntity -> personEntity != null
                && personEntity.getFirstName().equals(person.getFirstName())
                && personEntity.getLastName().equals(person.getLastName()));

    }
}
