package co.jagu.data.source.local;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.PersonDataSource;
import co.jagu.data.source.local.dao.PersonDao;
import co.jagu.data.source.local.dao.factory.PersonFakeFactory;
import io.reactivex.Flowable;

@RunWith(MockitoJUnitRunner.class)
public class LocalDataSourceTest extends BaseLocalDataSourceTest {

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

        PersonEntity person = PersonFakeFactory.createPerson();

        //Mock
        Mockito.when(mPersonDao.insertOrUpdate(person)).then(invocationOnMock ->
                FAKE_PERSON_ID);
        Mockito.when(mPersonDao.getPersonById(FAKE_PERSON_ID)).then(invocationOnMock -> Flowable
                .fromArray(person));

        //insertOrUpdate others
        mDataSource.insertOrUpdate(PersonFakeFactory.createPerson());
        mDataSource.insertOrUpdate(PersonFakeFactory.createPerson());

        mDataSource.getById(FAKE_PERSON_ID).test().assertValue(personEntity -> personEntity != null
                && personEntity.getFirstName().equals(person.getFirstName())
                && personEntity.getLastName().equals(person.getLastName()));

    }
}
