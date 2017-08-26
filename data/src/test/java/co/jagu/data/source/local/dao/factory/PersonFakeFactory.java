package co.jagu.data.source.local.dao.factory;


import java.util.Random;

import co.jagu.data.entity.PersonEntity;

public abstract class PersonFakeFactory {

    /*--
    Fake Data
    --*/

    private static final String[] FIRST_NAME = {"Juan", "Ignacio", "Manuel", "Matias", "Gerardo"};
    private static final String[] LAST_NAME = {"Agú", "Gonzales", "Perez", "Rodriguez", "Aguirre"};

    /*--
    Utils
    --*/

    private static int randomInt(final int min, final int max) {
        Random rn = new Random();
        int range = max - min + 1;
        return rn.nextInt(range) + min;
    }

    private static String randomFirstName() {
        return FIRST_NAME[randomInt(0, FIRST_NAME.length - 1)];
    }

    private static String randomLastName() {
        return LAST_NAME[randomInt(0, LAST_NAME.length - 1)];
    }

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

        personEntity.setFirstName(randomFirstName());
        personEntity.setLastName(randomLastName());

        return personEntity;
    }
}
