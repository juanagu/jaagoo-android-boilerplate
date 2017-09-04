package co.jagu.data.source.remote.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.junit.After;
import org.junit.Before;

import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseApiTest {

    /*--
    Fields
    --*/
    protected MockWebServer server;


    /*--
    Config
    -- */
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

    /**
     * Build retrofit with default configurations for test
     *
     * @return
     */
    protected Retrofit buildRetrofit() {
        //Gson configurations
        Gson gson = new GsonBuilder()
                .create();

        return new Retrofit.Builder()
                .baseUrl(server.url("").toString())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                //TODO Add your Retrofit parameters here
                .build();
    }


}
