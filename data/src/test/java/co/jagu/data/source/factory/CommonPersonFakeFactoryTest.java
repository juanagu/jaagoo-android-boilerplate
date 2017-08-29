package co.jagu.data.source.factory;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonPersonFakeFactoryTest {


    /*--
    Random int tests
    --*/

    @Test
    public void randomIntTestWhenMinSmallerThanMax() {
        final int MIN = 5;
        final int MAX = 4;

        int randomInt = CommonPersonFakeFactory.randomInt(MIN, MAX);

        assertThat(randomInt).isBetween(MIN, (MIN + MAX));
    }

    @Test
    public void randomIntTestWhenMaxGreaterThanMin() {
        final int MIN = 5;
        final int MAX = 10;

        int randomInt = CommonPersonFakeFactory.randomInt(MIN, MAX);

        assertThat(randomInt).isBetween(MIN, MAX);
    }

    @Test
    public void randomIntTestWhenMaxJustLikeMin() {
        final int MIN = 5;
        final int MAX = 5;

        int randomInt = CommonPersonFakeFactory.randomInt(MIN, MAX);

        assertThat(randomInt).isBetween(MIN, (MIN + MAX));

    }

    /*--
    Random first name tests
    -- */

    @Test
    public void randomFirstName() {

        String firstName = CommonPersonFakeFactory.randomFirstName();

        List<String> firstNameList = Arrays.asList(CommonPersonFakeFactory.FIRST_NAME);

        int indexOf = firstNameList.indexOf(firstName);

        assertThat(indexOf).isNotEqualTo(-1);
    }

    /*--
    Random last name tests
    -- */

    @Test
    public void randomLastName() {

        String lastName = CommonPersonFakeFactory.randomLastName();

        List<String> lastNameList = Arrays.asList(CommonPersonFakeFactory.LAST_NAME);

        int indexOf = lastNameList.indexOf(lastName);

        assertThat(indexOf).isNotEqualTo(-1);
    }
}
