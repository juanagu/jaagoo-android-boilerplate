package co.jagu.data.injection.component;


import javax.inject.Singleton;

import co.jagu.data.injection.module.NetworkModule;
import co.jagu.data.source.remote.api.PersonApi;
import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {NetworkModule.class})
public interface RemoteDataSourceComponent {

    /*--
    Base
    --*/
    Retrofit retrofit();

    /*--
    Api
    --*/
    PersonApi personApi();
}
