package co.jagu.data.source.local.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.local.dao.factory.LocalPersonFakeFactory;

@RunWith(RobolectricTestRunner.class)
public class PersonDaoTest extends BaseDaoTest {
    /*--
    Test
    -- */
    @Test
    public void insertAndGetPersonById() {

        PersonEntity person = LocalPersonFakeFactory.createPerson();
        PersonEntity person1 = LocalPersonFakeFactory.createPerson();

        mDatabase.personDao().insertOrUpdate(person1);
        final long PERSON_ID = mDatabase.personDao().insertOrUpdate(person);

        mDatabase.personDao().getPersonById(PERSON_ID)
                .test()
                .assertValue(personEntity -> personEntity != null
                        && personEntity.getFirstName().equals(person.getFirstName())
                        && personEntity.getLastName().equals(person.getLastName()));
    }
}
