package co.jagu.data.source.factory;


import java.util.Random;

public abstract class CommonPersonFakeFactory {

    /*--
    Fake Data
    --*/

    public static final String[] FIRST_NAME = {"Juan", "Ignacio", "Manuel", "Matias", "Gerardo"};
    public static final String[] LAST_NAME = {"Agú", "Gonzales", "Perez", "Rodriguez", "Aguirre"};

    /*--
    Utils
    --*/

    /**
     * max must be greater than min, if not max = max + min
     *
     * @param min
     * @param max
     * @return
     */
    public static int randomInt(final int min, int max) {
        if (min >= max) {
            max += min;
        }
        Random rn = new Random();
        int range = max - min + 1;
        return rn.nextInt(range) + min;
    }

    /**
     * Gets random first name using FIRST_NAME array
     *
     * @return
     */
    public static String randomFirstName() {
        return FIRST_NAME[randomInt(0, FIRST_NAME.length - 1)];
    }

    /**
     * Gets random last name using LAST_NAME array
     *
     * @return
     */
    public static String randomLastName() {
        return LAST_NAME[randomInt(0, LAST_NAME.length - 1)];
    }
}
