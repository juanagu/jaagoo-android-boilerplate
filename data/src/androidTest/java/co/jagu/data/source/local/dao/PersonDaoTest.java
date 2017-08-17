package co.jagu.data.source.local.dao;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import co.jagu.data.entity.PersonEntity;

@RunWith(AndroidJUnit4.class)
public class PersonDaoTest extends BaseDaoTest {

    private final static PersonEntity PERSON = new PersonEntity("Juan", "Agú");

    /*--
    Test
    -- */
    @Test
    public void insertAndGetPersonById() {
        mDatabase.personDao().insert(PERSON);
        mDatabase.personDao().getPersonById(PERSON.getId()).test().assertValue(PERSON);
    }
}
