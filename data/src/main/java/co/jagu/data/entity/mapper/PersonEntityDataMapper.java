package co.jagu.data.entity.mapper;

import java.util.Collection;
import java.util.List;

import javax.inject.Singleton;

import co.jagu.data.entity.PersonEntity;
import co.jagu.domain.Person;
import java8.util.stream.Collectors;
import java8.util.stream.StreamSupport;

@Singleton
public class PersonEntityDataMapper implements EntityDataMapper<PersonEntity, Person> {

    @Override
    public PersonEntity mapping(Person domain) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(domain.getId());
        personEntity.setFirstName(domain.getFirstName());
        personEntity.setLastName(domain.getLastName());
        personEntity.setAvatar(domain.getAvatar());
        return personEntity;
    }

    @Override
    public Person transform(PersonEntity entity) {
        Person person = new Person();
        person.setId(entity.getId());
        person.setFirstName(entity.getFirstName());
        person.setLastName(entity.getLastName());
        person.setAvatar(entity.getAvatar());
        return person;
    }

    @Override
    public List<Person> transform(Collection<PersonEntity> entities) {
        return StreamSupport.stream(entities)
                .map(personEntity -> transform(personEntity))
                .collect(Collectors.toList());
    }
}
