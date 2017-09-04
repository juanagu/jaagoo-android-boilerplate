package co.jagu.data.source.local.dao.factory;


import co.jagu.data.entity.PersonEntity;
import co.jagu.data.source.factory.CommonPersonFakeFactory;

public abstract class LocalPersonFakeFactory {


    /*--
    Factory
    --*/

    /**
     * create one person with a random name
     *
     * @return {@link PersonEntity}
     */
    public static PersonEntity createPerson() {

        PersonEntity personEntity = new PersonEntity();

        personEntity.setFirstName(CommonPersonFakeFactory.randomFirstName());
        personEntity.setLastName(CommonPersonFakeFactory.randomLastName());

        return personEntity;
    }
}
