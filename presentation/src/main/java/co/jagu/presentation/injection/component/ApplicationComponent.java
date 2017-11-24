package co.jagu.presentation.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import co.jagu.data.injection.module.DatabaseModule;
import co.jagu.data.injection.module.NetworkModule;
import co.jagu.presentation.AndroidApplication;
import co.jagu.presentation.injection.ApplicationContext;
import co.jagu.presentation.injection.module.ApplicationModule;
import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class, DatabaseModule.class})
public interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(AndroidApplication application);

        AndroidApplication build();
    }

    void inject(AndroidApplication androidApplication);
}
