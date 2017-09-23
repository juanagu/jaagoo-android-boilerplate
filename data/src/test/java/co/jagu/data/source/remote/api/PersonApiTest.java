package co.jagu.data.source.remote.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;

import co.jagu.data.source.remote.api.factory.RemotePersonFakeFactory;
import co.jagu.data.source.remote.api.utils.WebServerMockUtils;
import okhttp3.mockwebserver.MockResponse;

/**
 * Tests for {@link PersonApi}
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonApiTest extends BaseApiTest {

    /*--
    Dependencies
    --*/

    @Inject
    PersonApi personApi;

    /*--
    Config
    --*/
    @Override
    public void setup() throws Exception {
        super.setup();
        testRemoteDataSourceComponent.inject(this);
    }

    /*--
    PersonById tests
    --*/


    @Test
    public void getPersonByIdTest() {


        final long FAKE_PERSON_ID = 1L;

        //create mock response with fake person
        MockResponse mockResponse = new MockResponse()
                .setBody(RemotePersonFakeFactory.createResponseBodyGetPersonById(FAKE_PERSON_ID));
        //setup
        WebServerMockUtils.setupJsonHeader(mockResponse);
        WebServerMockUtils.setupNoCacheHeader(mockResponse);
        WebServerMockUtils.setupSlowNetwork(mockResponse);
        //add response
        server.enqueue(mockResponse);
        //call
        personApi.getPersonById(FAKE_PERSON_ID)
                .test()
                .assertValue(person1 -> person1 != null && person1.getId() == FAKE_PERSON_ID &&
                        !person1.getFirstName().isEmpty() && !person1.getLastName().isEmpty());
    }

    @Test
    public void getPersonByIdNotFoundTest() {

        final long FAKE_PERSON_ID = 1L;

        //create mock response with fake person
        MockResponse mockResponse = new MockResponse();
        //setup
        WebServerMockUtils.setupNotFound(mockResponse);
        //add response
        server.enqueue(mockResponse);
        //call
        personApi.getPersonById(FAKE_PERSON_ID)
                .test().assertNoValues();
    }
}
