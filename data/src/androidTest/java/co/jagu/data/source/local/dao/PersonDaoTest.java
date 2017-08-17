package co.jagu.data.source.local.dao;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.local.dao.factory.PersonFakeFactory;

@RunWith(AndroidJUnit4.class)
public class PersonDaoTest extends BaseDaoTest {
    /*--
    Test
    -- */
    @Test
    public void insertAndGetPersonById() {

        PersonEntity person = PersonFakeFactory.createPerson();
        PersonEntity person1 = PersonFakeFactory.createPerson();

        mDatabase.personDao().insert(person1);
        final long PERSON_ID = mDatabase.personDao().insert(person);


        mDatabase.personDao().getPersonById(PERSON_ID)
                .test()
                .assertValue(personEntity -> personEntity != null
                        && personEntity.getFirstName().equals(person.getFirstName())
                        && personEntity.getLastName().equals(person.getLastName()));
    }
}
