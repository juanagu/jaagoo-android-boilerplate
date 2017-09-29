package co.jagu.data.entity.mapper;


import android.support.test.filters.SmallTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.factory.CommonPersonFakeFactoryTest;
import co.jagu.data.source.local.dao.factory.LocalPersonFakeFactory;
import co.jagu.domain.Person;

@RunWith(MockitoJUnitRunner.class)
public class PersonEntityDataMapperTest {

    /*--
    Fields
    --*/
    private EntityDataMapper<PersonEntity, Person> mPersonEntityDataMapper;

    @Before
    public void setUp() throws Exception {
        mPersonEntityDataMapper = new PersonEntityDataMapper();
    }

    @SmallTest
    @Test
    public void transformAndMappingTest() throws Exception {

        PersonEntity personEntity = LocalPersonFakeFactory.createPerson();

        //transform
        Person person = mPersonEntityDataMapper.transform(personEntity);

        assertPersonEntityWithPerson(personEntity, person);

        //mapping
        PersonEntity personEntityMapping = mPersonEntityDataMapper.mapping(person);

        assertPersonEntityWithPerson(personEntityMapping, person);
    }

    @SmallTest
    @Test
    public void transformListTest() throws Exception {

        List<PersonEntity> personEntities = new ArrayList<>();
        personEntities.add(LocalPersonFakeFactory.createPerson());
        personEntities.add(LocalPersonFakeFactory.createPerson());

        Assert.assertEquals(mPersonEntityDataMapper.transform(personEntities).size(),
                personEntities.size());

    }


    private void assertPersonEntityWithPerson(PersonEntity personEntity,
                                              Person person) throws Exception {
        Assert.assertEquals(personEntity.getId(), person.getId());
        Assert.assertEquals(personEntity.getFirstName(), person.getFirstName());
        Assert.assertEquals(personEntity.getLastName(), person.getLastName());
        Assert.assertEquals(personEntity.getAvatar(), person.getAvatar());
    }


}
