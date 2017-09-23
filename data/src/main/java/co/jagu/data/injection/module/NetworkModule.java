package co.jagu.data.injection.module;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.jagu.data.injection.ServerInfo;
import co.jagu.data.source.remote.api.PersonApi;
import co.jagu.data.source.remote.factory.RemoteDataSourceBaseFactory;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    /*--
    Dependency
    --*/
    protected String baseUrl;

    @Inject
    public NetworkModule(@ServerInfo String baseUrl) {
        this.baseUrl = baseUrl;
    }


    /*--
    Provides
    --*/
    @Provides
    @Singleton
    Gson provideGson() {
        return RemoteDataSourceBaseFactory.createGson();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson) {
        return RemoteDataSourceBaseFactory.createRetrofit(baseUrl, gson);

    }

    @Provides
    @Singleton
    PersonApi providePersonApi(Retrofit retrofit) {
        return retrofit.create(PersonApi.class);
    }
}
