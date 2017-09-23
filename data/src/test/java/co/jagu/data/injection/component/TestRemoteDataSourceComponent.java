package co.jagu.data.injection.component;


import javax.inject.Singleton;

import co.jagu.data.injection.module.NetworkModule;
import co.jagu.data.source.remote.api.BaseApiTest;
import co.jagu.data.source.remote.api.PersonApiTest;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface TestRemoteDataSourceComponent extends RemoteDataSourceComponent {

    /*--
    Injects
    --*/

    void inject(BaseApiTest baseApiTest);

    void inject(PersonApiTest personApiTest);
}
