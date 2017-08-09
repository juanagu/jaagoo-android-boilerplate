package co.jagu.app.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import co.jagu.app.AndroidApplication;
import co.jagu.app.injection.ApplicationContext;
import co.jagu.app.injection.module.ApplicationModule;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AndroidApplication application);

    @ApplicationContext
    Context context();

    Application application();
}
