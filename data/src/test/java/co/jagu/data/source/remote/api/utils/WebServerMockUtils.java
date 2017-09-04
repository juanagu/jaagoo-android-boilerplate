package co.jagu.data.source.remote.api.utils;

import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import okhttp3.mockwebserver.MockResponse;

/**
 * Utils class for WebServerMock
 */
public class WebServerMockUtils {

    /*--
    MockResponse Utils
    --*/

    /**
     * add content-type application json
     *
     * @param mockResponse
     */
    public static void setupJsonHeader(MockResponse mockResponse) {
        mockResponse.addHeader("Content-Type", "application/json; charset=utf-8");
    }

    /**
     * add cache-control no-cache
     *
     * @param mockResponse
     */
    public static void setupNoCacheHeader(MockResponse mockResponse) {
        mockResponse.addHeader("Cache-Control", "no-cache");
    }

    /**
     * simulate slow network
     *
     * @param mockResponse
     */
    public static void setupSlowNetwork(MockResponse mockResponse) {
        mockResponse.throttleBody(1024, 1, TimeUnit.SECONDS);
    }

    /**
     * simulate not found response
     *
     * @param mockResponse
     */
    public static void setupNotFound(MockResponse mockResponse) {
        mockResponse.setBody("not found");
        mockResponse.setResponseCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    /**
     * simulate internal error
     *
     * @param mockResponse
     */
    public static void setupInternalError(MockResponse mockResponse) {
        mockResponse.setBody("Error");
        mockResponse.setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR);
    }
}
