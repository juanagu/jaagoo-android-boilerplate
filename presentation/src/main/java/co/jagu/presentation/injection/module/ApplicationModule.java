package co.jagu.presentation.injection.module;

import android.app.Application;
import android.content.Context;

import co.jagu.presentation.AndroidApplication;
import co.jagu.presentation.injection.ApplicationContext;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    /*--
    Fields
    -- */

    private final AndroidApplication mApplication;

    /*--
    Constructor
    -- */
    public ApplicationModule(AndroidApplication application) {
        this.mApplication = application;
    }

    /*--
    Provides
    -- */

    @Provides
    @ApplicationContext
    Context provideContext() {
        return this.mApplication;
    }

    @Provides
    Application provideApplication() {
        return this.mApplication;
    }

}
