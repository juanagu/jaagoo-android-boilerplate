package co.jagu.presentation;

import android.app.Activity;
import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

import co.jagu.presentation.injection.AppInjector;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Android main application
 */

public class AndroidApplication extends Application implements HasActivityInjector {

    /*--
    Fields
    -- */
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    /*--
    Lifecycle
    -- */
    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
        this.initializeLeakDetection();
    }


    /**
     * Initialize leak canary only for debug
     */
    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
