package co.jagu.data.source.remote.api;


import org.junit.After;
import org.junit.Before;

import co.jagu.data.injection.component.DaggerTestBaseDataComponent;
import co.jagu.data.injection.component.DaggerTestRemoteDataSourceComponent;
import co.jagu.data.injection.component.TestRemoteDataSourceComponent;
import co.jagu.data.injection.factory.ModuleFactory;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockWebServer;

public abstract class BaseApiTest {

    /*--
    Fields
    --*/
    protected MockWebServer server;

    protected TestRemoteDataSourceComponent testRemoteDataSourceComponent;

    /*--
    Config
    -- */
    @Before
    public void setup() throws Exception {
        // Create a MockWebServer. These are lean enough that you can create a new
        // instance for every unit test.
        server = new MockWebServer();
        HttpUrl url = server.url("");

        ModuleFactory moduleFactory = DaggerTestBaseDataComponent
                .builder()
                .build()
                .getModuleFactory();

        //create dagger component
        testRemoteDataSourceComponent = DaggerTestRemoteDataSourceComponent
                .builder()
                .networkModule(moduleFactory.createNetworkModule(url.toString()))
                .build();

        testRemoteDataSourceComponent.inject(this);

    }

    @After
    public void cleanUp() throws Exception {
        // Shut down the server. Instances cannot be reused.
        server.shutdown();
    }

}
