package co.jagu.data.injection.module;

import javax.inject.Singleton;

import co.jagu.data.source.remote.api.PersonApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by juanagu on 10/9/17.
 */
@Module
public class NetworkModule {

    /*--
    Dependency
    --*/
    private String mBaseUrl;

    public NetworkModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    /*--
    Provides
    --*/
    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    PersonApi providePersonApi(Retrofit retrofit) {
        return retrofit.create(PersonApi.class);
    }
}
