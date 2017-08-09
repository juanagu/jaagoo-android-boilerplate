package co.jagu.app.injection.module;

import android.app.Application;
import android.content.Context;

import co.jagu.app.AndroidApplication;
import co.jagu.app.injection.ApplicationContext;
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
