package co.jagu.data.source.remote.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import co.jagu.data.source.remote.api.factory.RemotePersonFakeFactory;
import co.jagu.data.source.remote.api.utils.WebServerMockUtils;
import okhttp3.mockwebserver.MockResponse;
import retrofit2.Retrofit;

/**
 * Tests for {@link PersonApi}
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonApiTest extends BaseApiTest {

    /*--
    PersonById tests
    --*/
    @Test
    public void getPersonByIdTest() {

        Retrofit retrofit = buildRetrofit();

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
        //create api
        PersonApi personApi = retrofit.create(PersonApi.class);
        //call
        personApi.getPersonById(FAKE_PERSON_ID)
                .test()
                .assertValue(person1 -> person1 != null && person1.getId() == FAKE_PERSON_ID);

    }

    @Test
    public void getPersonByIdNotFoundTest() {

        Retrofit retrofit = buildRetrofit();

        final long FAKE_PERSON_ID = 1L;

        //create mock response with fake person
        MockResponse mockResponse = new MockResponse();
        //setup
        WebServerMockUtils.setupNotFound(mockResponse);
        //add response
        server.enqueue(mockResponse);
        //create api
        PersonApi personApi = retrofit.create(PersonApi.class);
        //call
        personApi.getPersonById(FAKE_PERSON_ID)
                .test().assertNoValues();

    }
}
