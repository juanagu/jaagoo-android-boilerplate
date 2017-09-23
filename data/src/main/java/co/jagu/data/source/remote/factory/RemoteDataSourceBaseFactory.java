package co.jagu.data.source.remote.factory;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Base remote factory
 */
public abstract class RemoteDataSourceBaseFactory {

    /**
     * build a gson instance
     *
     * @return
     */
    public static Gson createGson() {
        //Gson configurations
        return new GsonBuilder()
                .create();
    }

    /**
     * Build retrofit with default configurations for test
     *
     * @param baseUrl
     * @param gson
     * @return
     */
    public static Retrofit createRetrofit(String baseUrl,
                                          Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
