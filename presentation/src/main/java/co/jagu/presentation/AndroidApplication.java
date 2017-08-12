package co.jagu.presentation;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import co.jagu.app.BuildConfig;
import co.jagu.presentation.injection.component.ApplicationComponent;
import co.jagu.presentation.injection.component.DaggerApplicationComponent;
import co.jagu.presentation.injection.module.ApplicationModule;

/**
 * Android main application
 */

public class AndroidApplication extends Application {

    /*--
    Fields
    -- */
    private ApplicationComponent mApplicationComponent;

    /*--
    Lifecycle
    -- */
    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    /*--
    private methods
    -- */
    private void initializeInjector() {
        this.mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    /**
     * Initialize leak canary only for debug
     */
    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    /*--
    public methods
    -- */
    public ApplicationComponent getApplicationComponent() {
        return this.mApplicationComponent;
    }


}
