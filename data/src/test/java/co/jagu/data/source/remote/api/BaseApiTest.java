package co.jagu.data.source.remote.api;


import org.junit.After;
import org.junit.Before;

import okhttp3.mockwebserver.MockWebServer;

public abstract class BaseApiTest {

    /*--
    Fields
    --*/
    protected MockWebServer server;

    @Before
    public void setup() throws Exception {
        // Create a MockWebServer. These are lean enough that you can create a new
        // instance for every unit test.
        server = new MockWebServer();
    }

    @After
    public void cleanUp() throws Exception {
        // Shut down the server. Instances cannot be reused.
        server.shutdown();
    }
}
