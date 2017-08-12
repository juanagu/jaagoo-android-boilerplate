package co.jagu.presentation.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import co.jagu.presentation.AndroidApplication;
import co.jagu.presentation.injection.ApplicationContext;
import co.jagu.presentation.injection.module.ApplicationModule;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AndroidApplication application);

    @ApplicationContext
    Context context();

    Application application();
}
